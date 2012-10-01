package nl.gridshore.integration;

import org.joda.time.DateTime;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import java.util.List;

/**
 * T represents the identifier of the items to obtain from the target system.
 * E Represents the objects to store in the source system
 *
 * @author Jettro Coenradie
 */
public class BaseSyncInitializer<T, E> implements SyncInitialization<E> {
    private TargetApi<T, E> targetApi;
    private SourceApi sourceApi;
    private MessageChannel channel;

    public BaseSyncInitializer(MessageChannel channel, SourceApi sourceApi, TargetApi<T, E> targetApi) {
        this.channel = channel;
        this.sourceApi = sourceApi;
        this.targetApi = targetApi;
    }

    public void startSyncAll() {
        List<T> itemsToSync = targetApi.obtainItemsToSync();
        sendMessage(itemsToSync);
    }

    public void startSyncAllSince(DateTime time) {
        List<T> itemsToSync = targetApi.obtainItemsToSyncSince(time);
        sendMessage(itemsToSync);
    }

    public void startSyncAllSinceLastTime() {
        DateTime lastSyncTime = sourceApi.obtainLastSyncTime();
        startSyncAllSince(lastSyncTime);
    }

    public void syncItems(List<E> identifiers) {
        List<T> itemsToSync = targetApi.obtainItemsToSync(identifiers);
        sendMessage(itemsToSync);
    }

    private void sendMessage(List<T> itemsToSync) {
        Message message = MessageBuilder.withPayload(itemsToSync)
                .setHeader(Constants.START_TIME_HEADER_KEY, new DateTime())
//                .setHeader("ERROR_CHANNEL", "aggregateResultsChannel")
                .build();
        channel.send(message);
    }
}
