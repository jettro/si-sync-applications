import nl.gridshore.integration.BaseSyncInitializer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jettro Coenradie
 */
public class Runner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("sync-context.xml", "dummy-context.xml");

        BaseSyncInitializer baseSyncInitializer = context.getBean("syncInitializer", BaseSyncInitializer.class);

        baseSyncInitializer.startSyncAll();
    }
}
