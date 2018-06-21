 
 
 #Author: your.email@your.domain.com

@Pagos
Feature: Realizar pago

  @TestCase1
  Scenario Outline:  Realizar el pago exitoso
    Given Iniciar App Eribank
    And Ingreso las credenciales 
   			|<Usuario>|<Contrasena>|
    When Deligencio los datos del pago 
        |<Phone>|<Name>|<Amount>|<Country>|
    Then Comprobar envio del pago 
    		|<Mensaje>|

    Examples: 
        |ID|Usuario|Contrasena|Phone|Name|Amount|Country|Mensaje|
      ##@externaldata@./src/test/resources/DataDriven/Pagos.xlsx@PagoExitoso
      |1|company|company|34535345|Jorge|3|Colombia|Your balance is:|



 








