 
 
 #Author: your.email@your.domain.com

@Login
Feature: Realizar operaciones realacionadas con el Login

  @TestCase1
    Scenario Outline: Realizar login exitoso
    Given Iniciar App Eribank
    When Iniciar Sesion Exitosa 
    |<Usuario>|<Contrasena>|
    Then Verificar Acceso App 
    |<Mensaje>|

    Examples: 
      |ID|Usuario|Contrasena|Mensaje|
      ##@externaldata@./src/test/resources/DataDriven/Login.xlsx@LoginExitoso
      |1|company|company|EriBank|
      |2|compan|compan|Invalid username or password!|

     
