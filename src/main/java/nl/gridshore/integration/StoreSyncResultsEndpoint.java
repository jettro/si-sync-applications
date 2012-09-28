package nl.gridshore.integration;

/**
 * @author Jettro Coenradie
 */
public class StoreSyncResultsEndpoint {
    private boolean state = true;

    public boolean storeItems(Object payload) {
        System.out.println(payload.toString());
        return state = !state;
    }
}
