package nl.gridshore.integration;

import java.util.List;

/**
 * @author Jettro Coenradie
 */
public interface SyncGateway {
    void startSyncFor(List items);
}
