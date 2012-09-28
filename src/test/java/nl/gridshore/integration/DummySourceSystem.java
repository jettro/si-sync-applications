package nl.gridshore.integration;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * @author Jettro Coenradie
 */
@Component(value = "sourceApi")
public class DummySourceSystem implements SourceApi<DummySourceItem> {
    public DateTime obtainLastSyncTime() {
        return new DateTime();
    }

    public void storeItem(DummySourceItem dummySourceItem) {
        System.out.println(dummySourceItem.toString());
    }

}
