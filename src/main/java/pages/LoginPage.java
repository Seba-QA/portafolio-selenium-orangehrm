package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Selectores
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private By errorEmpty = By.xpath("//span[text()='Required']");

    // Elementos con PageFactory
    @FindBy(name = "username")
    private WebElement inputUser;
    @FindBy(name = "password")
    private WebElement inputPass;
    @FindBy(css = "button[type='submit']")
    private WebElement btnLogin;
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement titleDash;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // URL del login
    private final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // Métodos de interacción
    public void openLoginPage() {
        driver.get(url);
    }

    public void enterUsername(String username) {
        WebElement user = waitForElement(usernameField, 10);
        user.clear();
        user.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement pass = waitForElement(passwordField, 10);
        pass.clear();
        pass.sendKeys(password);
    }

    public void clickLogin() {
        WebElement btn = waitForElement(loginButton, 10);
        btn.click();
    }

    // Métodos de validación (devuelven boolean)
    public boolean isDashboardVisible() {
        return waitForElement(dashboardTitle, 10).isDisplayed();
    }

    public boolean isErrorVisible() {
        return waitForElement(errorMessage, 10).isDisplayed();
    }

    public boolean isErrorEmptyVisible() {
        return waitForElement(errorEmpty, 10).isDisplayed();
    }

    public enum LoginResult {
        SUCCESS,
        INVALID_CREDENTIALS,
        EMPTY_USER,
        EMPTY_PASSWORD
    }

    public boolean validateLoginResult(LoginResult expected) {
        boolean resultado;
    switch (expected) {
        case SUCCESS:
            resultado =isDashboardVisible();
            break;

        case INVALID_CREDENTIALS:
            resultado = isErrorVisible();
            break;

        case EMPTY_USER:
            resultado = isErrorEmptyVisible();
            break;

        case EMPTY_PASSWORD:
            resultado = isErrorEmptyVisible();
            break;

        default:
            throw new IllegalStateException("Resultado no soportado: " + expected);
    }
    return resultado;
}

}
