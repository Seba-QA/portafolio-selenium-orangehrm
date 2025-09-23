package steps.Auth;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.LoginPage;

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

    @Then("debería validar el resultado {string}")
    public void validarResultado(String resultado) {
        switch (resultado.toLowerCase()) {
            case "exitoso":
                Assert.assertTrue("El Dashboard no es visible", loginPage.isDashboardVisible());
                break;
            case "incorrectas":
                Assert.assertTrue("No apareció mensaje de error", loginPage.isErrorVisible());
                break;
            case "emptyuser":
                Assert.assertTrue("No apareció error por usuario vacío", loginPage.isErrorVisible());
                break;
            case "emptypass":
                Assert.assertTrue("No apareció error por contraseña vacía", loginPage.isErrorVisible());
                break;
            default:
                throw new IllegalArgumentException("Resultado no soportado: " + resultado);
        }
    }
}


