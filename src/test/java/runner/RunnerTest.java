package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"
        }
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
