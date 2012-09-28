package nl.gridshore.integration;

import org.joda.time.DateTime;

/**
 * @author Jettro Coenradie
 */
public class Statistics {
    private DateTime startTime;
    private DateTime endTime;

    private int totalItems;
    private int handledItems;
    private int discardedItems;

    public Statistics(DateTime startTime, DateTime endTime, int totalItems, int handledItems, int discardedItems) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalItems = totalItems;
        this.handledItems = handledItems;
        this.discardedItems = discardedItems;
    }

    public int getDiscardedItems() {
        return discardedItems;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public int getHandledItems() {
        return handledItems;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public int getTotalItems() {
        return totalItems;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalItems=" + totalItems +
                ", handledItems=" + handledItems +
                ", discardedItems=" + discardedItems +
                '}';
    }
}
