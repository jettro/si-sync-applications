package nl.gridshore.integration;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jettro Coenradie
 */
@Component(value = "targetApi")
public class DummyTargetSystem implements TargetApi<DummyItem, String> {
    private List<DummyItem> items;

    {
        items = new ArrayList<DummyItem>();
        items.add(new DummyItem("name 1"));
        items.add(new DummyItem("name 2"));
        items.add(new DummyItem("name 3"));
        items.add(new DummyItem("name 4"));
        items.add(new DummyItem("name 5"));
        items.add(new DummyItem("name 6"));
        items.add(new DummyItem("name 7"));
        items.add(new DummyItem("name 8"));
        items.add(new DummyItem("name 9"));
    }

    public List<DummyItem> obtainItemsToSync() {
        return items;
    }

    public List<DummyItem> obtainItemsToSyncSince(DateTime time) {
        return items.subList(5, 8);
    }

    public List<DummyItem> obtainItemsToSync(List<String> identifiers) {
        return items.subList(2, 3);
    }
}
