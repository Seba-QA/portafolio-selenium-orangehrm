package steps.Auth;

import static org.junit.Assert.assertTrue;

import config.DriverFactory;
import io.cucumber.java.en.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import pages.LoginPage;
import pages.LoginPage.LoginResult;
import utils.EvidenceHelper;

@Epic ("Autenticación")
@Feature ("Login de usuarios")
@Story ("Login con diferentes credenciales")
@Owner("QA Team")
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
    @Severity(io.qameta.allure.SeverityLevel.CRITICAL)
    public void validarResultado(String resultadoEsperado) {
        LoginResult esperado;
        try {
            esperado = LoginResult.valueOf(resultadoEsperado.toUpperCase());
        } catch (IllegalArgumentException e) {

            EvidenceHelper.attachScreenshot(
                DriverFactory.getDriver(),
                "Valor de resultado inválido recibido: " + resultadoEsperado
            );

            throw new AssertionError(
                "Resultado esperado no válido en el feature: " + resultadoEsperado,
                e
            );
        }
        boolean resultado = loginPage.validateLoginResult(esperado);
        EvidenceHelper.attachScreenshot(
            DriverFactory.getDriver(),
            "Resultado login esperado: " + esperado
        );

        assertTrue(
            "Resultado esperado: " + esperado + "| Obtenido: " + resultadoEsperado,
            resultado
        );
    }
}


