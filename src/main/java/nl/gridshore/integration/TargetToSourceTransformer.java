package nl.gridshore.integration;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;

/**
 * @author Jettro Coenradie
 */

public abstract class TargetToSourceTransformer<S, T> {
    @Transformer
    public Message<?> transform(Message<T> targetItem) {
        try {
            S sourceItem = doTransform(targetItem.getPayload());
            return MessageBuilder.withPayload(sourceItem).copyHeaders(targetItem.getHeaders()).build();
        } catch (Exception e) {
            return MessageBuilder.fromMessage(targetItem).setHeader("DISCARD_CHANNEL", "syncResultsStoredChannel").build();
        }
    }

    protected abstract S doTransform(T targetItem);
}
