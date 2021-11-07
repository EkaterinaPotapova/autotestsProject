package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        strict = true,
        monochrome = true,
        features="src/test/resources/features",
plugin = {
        "pretty",
        "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"
})


public class RunnerTest {
}
