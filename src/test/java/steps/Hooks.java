package steps;

import config.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver("chrome"); // aquí podrías parametrizar el navegador
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}


