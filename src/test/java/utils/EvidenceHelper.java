package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import steps.Hooks;

public class EvidenceHelper {

    private EvidenceHelper() {}

    public static void attachScreenshot(WebDriver driver, String descripcion) {
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Hooks.getScenario().attach(
                screenshot,
                "image/png",
                descripcion
        );
    }

    public static void writeEnvironmentInfo() {
        try {
            Path path = Paths.get("target/allure-results/environment.properties");
            Files.createDirectories(path.getParent());

            Properties props = new Properties();
            props.setProperty("Browser", "Chrome");
            props.setProperty("OS", System.getProperty("os.name"));
            props.setProperty("Java", System.getProperty("java.version"));
            props.setProperty("Environment", "QA");

            try (OutputStream os = Files.newOutputStream(path)) {
                props.store(os, null);
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear environment.properties", e);
        }
    }
}

