@all @PIM
Feature: Creación de empleados en OrangeHRM

  Background:
    Given El usuario abre la página de OrangeHRM
    When Ingresa usuario "admin" y contraseña "admin123"
    Then Accede al panel principal del sistema

  @CreacionDeEmpleado
  Scenario Outline: Registrar un nuevo empleado
    Given El usuario ingresa el nombre <nombre> y apellido <apellido>
    Then El sistema muestra un mensaje de éxito confirmando la creación
    Examples:
      |nombre   |apellido |
      |Nicolas  |Cardoso  |

  @BuscarEmpleado
  Scenario Outline: Busqueda de empleado
    Given El administrador busca el empleado con nombre <nombre> Y apellido <apellido>
    Then El sistema muestra al empleado <nombre> <apellido>
    Examples:
      |nombre   |apellido |
      |Nicolas  |Cardoso  |

