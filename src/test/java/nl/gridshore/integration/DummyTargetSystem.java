package nl.gridshore.integration;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jettro Coenradie
 */
@Component(value = "targetApi")
public class DummyTargetSystem implements TargetApi<DummyTargetItem, String> {
    private List<DummyTargetItem> targetItems;

    {
        targetItems = new ArrayList<DummyTargetItem>();
        targetItems.add(new DummyTargetItem("name 1"));
        targetItems.add(new DummyTargetItem("name 2"));
        targetItems.add(new DummyTargetItem("name 3"));
        targetItems.add(new DummyTargetItem("name 4"));
        targetItems.add(new DummyTargetItem("name 5"));
        targetItems.add(new DummyTargetItem("name 6"));
        targetItems.add(new DummyTargetItem("name 7"));
        targetItems.add(new DummyTargetItem("name 8"));
        targetItems.add(new DummyTargetItem("name 9"));
    }

    public List<DummyTargetItem> obtainItemsToSync() {
        return targetItems;
    }

    public List<DummyTargetItem> obtainItemsToSyncSince(DateTime time) {
        return targetItems.subList(5, 8);
    }

    public List<DummyTargetItem> obtainItemsToSync(List<String> identifiers) {
        return targetItems.subList(2, 3);
    }
}
