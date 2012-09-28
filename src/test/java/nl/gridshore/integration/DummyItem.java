package nl.gridshore.integration;

/**
 * @author Jettro Coenradie
 */
public class DummyItem {
    private String name;

    public DummyItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DummyItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
