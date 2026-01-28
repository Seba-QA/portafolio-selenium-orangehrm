package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import config.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;

import static utils.EvidenceHelper.writeEnvironmentInfo;

public class Hooks {
    private static Scenario scenario;

    @Before
    public void setUp() {
        DriverFactory.initDriver("chrome"); // aquí podrías parametrizar el navegador
    }
    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    "Estado final al fallar el escenario"
            );
        }
    }

    @AfterAll
    public static void generateEnvironmentInfo() {
        try {
            writeEnvironmentInfo();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear environment.properties", e);
        }
    }
}


