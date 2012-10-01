package nl.gridshore.integration;

/**
 * @author Jettro Coenradie
 */
public class DummyTargetItem {
    private String name;

    public DummyTargetItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DummyTargetItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
