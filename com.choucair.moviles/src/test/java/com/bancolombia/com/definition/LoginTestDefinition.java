package com.bancolombia.com.definition;
import java.util.List;
import com.bancolombia.com.steps.LoginTestSteps;
import DTO.AutenticacionDTO;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginTestDefinition {
	public List<AutenticacionDTO> autentic = null;
	AutenticacionDTO autenticacion = new AutenticacionDTO();

	@Steps	
	LoginTestSteps loginTestSteps;	
	
	@Given("^Iniciar App Eribank$")
	public void iniciar_App_Eribank() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginTestSteps.iniciar_app();
	}
	
	@When("^Iniciar Sesion Exitosa$")
	public void iniciarSesionExitosa(List<String> data) throws Throwable {
		autenticacion.setUsuario(data.get(0));
		autenticacion.setClave(data.get(1));
		loginTestSteps.logueoEribank(autenticacion);
	}

	@Then("^Verificar Acceso App$")
	public void verificarAccesoApp(List<String> data) throws Throwable {
		autenticacion.setMensaje(data.get(0));
		loginTestSteps.verificarLoginExitoso(autenticacion);
		//
	}
}
