package nl.gridshore.integration;

/**
 * @author Jettro Coenradie
 */
public class DummySourceItem {
    private String name;

    public DummySourceItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DummySourceItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
