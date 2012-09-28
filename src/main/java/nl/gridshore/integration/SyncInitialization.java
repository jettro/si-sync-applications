package nl.gridshore.integration;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jettro Coenradie
 */
public interface SyncInitialization<E> {
    void startSyncAll();

    void startSyncAllSince(DateTime time);

    void startSyncAllSinceLastTime();

    void syncItems(List<E> items);
}
