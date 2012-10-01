package nl.gridshore.integration;

import org.springframework.stereotype.Component;

/**
 * @author Jettro Coenradie
 */
@Component(value = "targetToSourceTransformer")
public class DummyTargetToSourceTransformer extends TargetToSourceTransformer<DummySourceItem, DummyItem> {

    @Override
    protected DummySourceItem doTransform(DummyItem targetItem) {
        if (targetItem.getName().equals("name 4")) {
            throw new RuntimeException("error in transformer");
        }
        return new DummySourceItem(targetItem.getName());
    }
}
