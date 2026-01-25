package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resource/features",
        glue = {"steps"},                        
        tags = "@login",                            
        plugin = {
                //"pretty",
                // "html:target/cucumber-reports.html",
                // "json:target/cucumber.json"
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner {
}
