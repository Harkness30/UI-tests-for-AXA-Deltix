package RunnerTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"Steps"},
        tags = "@Run",
        plugin = {"pretty"})

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    private static Properties testProperties;

    private static Logger log = Logger.getLogger(RunCucumberTest.class);

    @BeforeSuite
    public static void initData() throws IOException {
        testProperties = new Properties();
        testProperties.load(new FileInputStream("src/test/resources/project.properties"));
        for (
                Object entry : testProperties.entrySet()) {
            log.debug("property value:" + entry.toString());
        }
        log.info("Initialization completed");
    }
}
