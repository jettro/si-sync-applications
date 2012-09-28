package nl.gridshore.integration;

import org.joda.time.DateTime;

/**
 * @author Jettro Coenradie
 */
public interface SourceApi<T> {
    DateTime obtainLastSyncTime();

    void storeItem(T t);
}
