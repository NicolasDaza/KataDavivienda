@all @Login
Feature: Inicio de sesión en OrangeHRM

  @IngresoExitoso
  Scenario: Acceso exitoso con credenciales válidas
    Given El usuario abre la página de OrangeHRM
    When Ingresa usuario "admin" y contraseña "admin123"
    Then Accede al panel principal del sistema