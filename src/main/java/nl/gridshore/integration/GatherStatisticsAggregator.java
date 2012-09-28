package nl.gridshore.integration;

import org.joda.time.DateTime;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.Header;

import java.util.List;

/**
 * @author Jettro Coenradie
 */
public class GatherStatisticsAggregator {
    public Statistics aggregate(List<Message> messages, @Header(value = "START_TIME") DateTime startTime) {
        DateTime endTime = new DateTime();

        int success = 0;
        int failure = 0;
        for (Message message : messages) {
            if ((Boolean) message.getPayload()) {
                success++;
            } else {
                failure--;
            }
        }
        return new Statistics(startTime, endTime, messages.size(), success, failure);
    }
}
