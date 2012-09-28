package nl.gridshore.integration;

/**
 * @author Jettro Coenradie
 */
public class StatisticsEndpoint {
    public void handleStatistics(Statistics statistics) {
        System.out.println(statistics.toString());
    }
}
