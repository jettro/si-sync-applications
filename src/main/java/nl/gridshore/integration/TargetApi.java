package nl.gridshore.integration;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Jettro Coenradie
 */
public interface TargetApi<T, E> {
    List<T> obtainItemsToSync();

    List<T> obtainItemsToSyncSince(DateTime time);

    List<T> obtainItemsToSync(List<E> identifiers);
}
