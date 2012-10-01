package nl.gridshore.integration;

import org.springframework.stereotype.Component;

/**
 * @author Jettro Coenradie
 */
@Component(value = "storeSyncResultsEndpoint")
public class DummyStoreSyncResultsEndpoint extends StoreSyncResultsEndpoint<DummySourceItem> {
    @Override
    protected Object doStoreItem(DummySourceItem item) {
        if (item.getName().equals("name 7")) {
            throw new RuntimeException("Hmm, something wrong with name 7");
        }
        return "Great Success";
    }
}
