package steps.Auth;

import org.junit.Assert;

import config.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.LoginPage.LoginResult;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(config.DriverFactory.getDriver());
    }
    
    @Given("que estoy en la página de login")
    public void abrirLogin() {
        loginPage.openLoginPage();
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingresarCredenciales(String usuario, String contrasena) {
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(contrasena);
    }

    @And("hago clic en el botón de login")
    public void clicEnLogin() {
        loginPage.clickLogin();
    }

    @Then("valida el resultado {string}")
    public void validarResultado(String resultadoEsperado) {
        LoginResult esperado = LoginResult.valueOf(resultadoEsperado.toUpperCase());
        loginPage.validateLoginResult(esperado);
    }
}


