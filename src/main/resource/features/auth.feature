Feature: Autenticación de usuarios

  @login
  Scenario Outline: Validación de inicio de sesión
    Given que estoy en la página de login
    When ingreso el usuario "<usuario>" y la contraseña "<contraseña>"
    And hago clic en el botón de login
    Then debería validar el resultado "<resultado>"

  Examples:
    | usuario      | contraseña   | resultado     |
    | Admin        | admin123     | exitoso       |
    | FakeUser     | wrong123     | incorrectas   |
    | Admin        |              | emptyPass     |
    |              | admin123     | emptyUser     |


