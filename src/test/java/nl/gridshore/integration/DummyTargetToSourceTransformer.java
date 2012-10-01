package nl.gridshore.integration;

import org.springframework.stereotype.Component;

/**
 * @author Jettro Coenradie
 */
@Component(value = "targetToSourceTransformer")
public class DummyTargetToSourceTransformer extends TargetToSourceTransformer<DummySourceItem, DummyTargetItem> {

    @Override
    protected DummySourceItem doTransform(DummyTargetItem targetTargetItem) {
        if (targetTargetItem.getName().equals("name 4")) {
            throw new RuntimeException("error in transformer");
        }
        return new DummySourceItem(targetTargetItem.getName());
    }
}
