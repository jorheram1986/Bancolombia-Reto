package com.bancolombia.com.steps;

import java.util.List;

import com.bancolombia.com.pageObjects.LoginTestPage;
import com.bancolombia.com.pageObjects.MakePaymentTestPage;

import DTO.AutenticacionDTO;
import DTO.PagosDTO;
import net.thucydides.core.annotations.Step;

public class MakePaymentTestSteps {

		AutenticacionDTO autenticacio;
		MakePaymentTestPage makePaymentTestPage;
		LoginTestPage loginTestPage;
		
		public List<AutenticacionDTO> datosUsuario = null;
		@Step
		public void logueoEribankPagos(AutenticacionDTO autenticacion) throws InterruptedException {
			// TODO Auto-generated method stub
			loginTestPage.ingresarUsuario(autenticacion.getUsuario());
			loginTestPage.ingresarContrasena(autenticacion.getClave());
			loginTestPage.btnLogin();
			Thread.sleep(5000);
			makePaymentTestPage.makePayment();
	}
		@Step
		public void hacer_pago(PagosDTO pagos)  {
			makePaymentTestPage.ingresarPhone(pagos.getTelefono());
			makePaymentTestPage.ingresarNombre(pagos.getNombre());
			makePaymentTestPage.ingresarCantidad(pagos.getCantidad());
			makePaymentTestPage.ingresarPais(pagos.getPais());
			
	     }
		
		@Step
		public void confirmarPago(AutenticacionDTO autenticacion) throws InterruptedException  {
			makePaymentTestPage.enviarPago();
			Thread.sleep(3000);
			makePaymentTestPage.confirmarPagoExitoso();
			Thread.sleep(3000);
			makePaymentTestPage.tuBalanceEs();
			Thread.sleep(3000);
			loginTestPage.btnLogout();
			
		}

}
