package com.bancolombia.com.definition;
import java.util.List;

import com.bancolombia.com.pageObjects.MakePaymentTestPage;
import com.bancolombia.com.steps.LoginTestSteps;
import com.bancolombia.com.steps.MakePaymentTestSteps;

import DTO.AutenticacionDTO;
import DTO.PagosDTO;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MakePaymentTestDefinition {
	AutenticacionDTO autenticacion = new AutenticacionDTO();
	@Steps	
	PagosDTO pagos = new PagosDTO();
	@Steps	
	MakePaymentTestSteps  makePaymentTestSteps;	
	@Steps	
	LoginTestSteps loginTestSteps;	
	
	@Given("^Ingreso las credenciales$")
	public void ingresoLasCredenciales(List<String> data) throws Throwable {
		autenticacion.setUsuario(data.get(0));
		autenticacion.setClave(data.get(1));
		makePaymentTestSteps.logueoEribankPagos(autenticacion);
	}

	@When("^Deligencio los datos del pago$")
	public void deligencioLosDatosDelPago(List<String> data) throws Throwable {
		pagos.setTelefono(data.get(0));
		pagos.setNombre(data.get(1));
		pagos.setCantidad(data.get(2));		
		pagos.setPais(data.get(3));
		makePaymentTestSteps.hacer_pago(pagos);
	}

	@Then("^Comprobar envio del pago$")
	public void comprobarEnvioDelPago(List<String> data) throws Throwable {
		autenticacion.setMensaje(data.get(0));
		makePaymentTestSteps.confirmarPago(autenticacion);

	}
	
}
