package com.bancolombia.com.steps;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import java.util.List;
import com.bancolombia.com.pageObjects.LoginTestPage;
import com.bancolombia.com.pageObjects.MakePaymentTestPage;

import DTO.AutenticacionDTO;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTestSteps {
	
	AutenticacionDTO autenticacio;
	LoginTestPage loginTestPage;
	MakePaymentTestPage makePaymentTestPage;

	public List<AutenticacionDTO> datosUsuario = null;

	@Step	
	public void iniciar_app() {
		// TODO Auto-generated method stub
		loginTestPage.gotoWPLoginPage();
	}
	@Step
	public void logueoEribank(AutenticacionDTO autenticacion) {
		// TODO Auto-generated method stub
		loginTestPage.ingresarUsuario(autenticacion.getUsuario());
		loginTestPage.ingresarContrasena(autenticacion.getClave());
		loginTestPage.btnLogin();
}
	/*@Step
	public void logueoEribankDataDriven(AutenticacionDTO autenticacion, String rutaData) throws Exception{
		// TODO Auto-generated method stub
		loginTestPage.ingresarUsuario(autenticacion.getUsuario());
		//String resultado = commonsFunction.abrirGmail(autenticacion);
		//loginTestPage.ingresarContrasena(resultado);
		loginTestPage.ingresarContrasena(autenticacion.getClave());
		loginTestPage.btnLogin();
		loginTestPage.autenticacion(autenticacion);
		//datosExcel.resultadoCasoAutenticacion(null);
		return;
	}*/

	@Step
	public void verificarLoginExitoso(AutenticacionDTO autenticacion) throws InterruptedException  {
		String resul= autenticacion.getMensaje();	
		
		// TODO Auto-generated method stub
		//boolean logueoExito;
		//String logueoExito1;
		//logueoExito = loginTestPage.home(autenticacion.getResultado());
		//logueoExito1 = loginTestPage.home(autenticacion);
		//assertThat(logueoExito).isTrue();
		
		if (resul.equals("EriBank")) {
			boolean logueoExito;
			//logueoExito = autenticaciogetResultadoEsperado();
			logueoExito = loginTestPage.home(autenticacion.getMensaje());
			assertThat(logueoExito).isTrue();
			Thread.sleep(1000);
			loginTestPage.btnLogout();		
			
		}
		else {
			
			boolean logueoNoExitoso;
			logueoNoExitoso = loginTestPage.logueoNoExitoso(autenticacion.getMensaje());
			assertThat(logueoNoExitoso).isTrue();
			loginTestPage.btnCerrarMsnErrorLogin();

		}
		}
		
		//loginTestPage.btnLogout();
		//Thread.sleep(3000);
	}
	
//	if (resul1.equals("Fecha actual")) {
//	boolean logueoExito;
//	//logueoExito = autenticaciogetResultadoEsperado();
//	logueoExito = testPage.home(autenticacio.getResultadoEsperado());
//	assertThat(logueoExito).isTrue();
//	btnMenu.click();;
//	btnLogout.click();
//	Thread.sleep(1000);
//	btnConfirmarLogout.click();
//}
//else {
//	boolean logueoNoExitoso;
//	logueoNoExitoso = testPage.logueoNoExitoso(autenticacion.getResultadoEsperado());
//	assertThat(logueoNoExitoso).isTrue();
//	conexionAppium.navigate().back();
//	//loginTestPage.btnCerrarMsnErrorLogin();
//	//loginTestPage.btnLogout();
//	
//}
	
	/*
	@Step
	public void verificarLoginNoExitoso(String noLogueo) {
		// TODO Auto-generated method stub
		boolean logueoNoExitoso;
		logueoNoExitoso = loginTestPage.logueoNoExitoso(noLogueo);
		assertThat(logueoNoExitoso).isTrue();
		loginTestPage.btnCerrarMsnErrorLogin();
		//loginTestPage.btnLogout();
	}*/

