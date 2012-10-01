package nl.gridshore.integration;

import org.joda.time.DateTime;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.Header;

import java.util.List;

import static nl.gridshore.integration.Constants.DISCARD_CHANNEL_HEADER_KEY;
import static nl.gridshore.integration.Constants.START_TIME_HEADER_KEY;

/**
 * @author Jettro Coenradie
 */
public class GatherStatisticsAggregator {

    @Aggregator
    public Statistics aggregate(List<Message> messages, @Header(value = START_TIME_HEADER_KEY) DateTime startTime) {
        DateTime endTime = new DateTime();

        int success = 0;
        int failure = 0;
        for (Message message : messages) {
            if (null == message.getHeaders().get(DISCARD_CHANNEL_HEADER_KEY)) {
                success++;
            } else {
                failure++;
            }
        }
        return new Statistics(startTime, endTime, messages.size(), success, failure);
    }
}
