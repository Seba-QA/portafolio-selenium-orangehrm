Feature: Autenticación de usuarios

  @login
  Scenario Outline: Validación de inicio de sesión
    Given que estoy en la página de login
    When ingreso el usuario "<usuario>" y la contraseña "<contraseña>"
    And hago clic en el botón de login
    Then valida el resultado "<resultado>"

  Examples:
    | usuario      | contraseña   | resultado             |
    | Admin        | admin123     | SUCCESS               |
    | FakeUser     | wrong123     | INVALID_CREDENTIALS   |
    | Admin        |              | EMPTY_PASSWORD        |
    |              | admin123     | EMPTY_USER            |

