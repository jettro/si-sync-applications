package nl.gridshore.integration;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;

/**
 * @author Jettro Coenradie
 */
public abstract class StoreSyncResultsEndpoint<T> {

    @ServiceActivator
    public Message<?> storeItems(Message<T> message) {
        try {
            Object result = doStoreItem(message.getPayload());
            if (result == null) {
                result = "Success";
            }
            return MessageBuilder.withPayload(result).copyHeaders(message.getHeaders()).build();
        } catch (Exception e) {
            return MessageBuilder.fromMessage(message).setHeader("DISCARD_CHANNEL", "syncResultsStoredChannel").build();
        }
    }

    protected abstract Object doStoreItem(T item);
}
