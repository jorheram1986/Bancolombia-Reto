package com.bancolombia.com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import DTO.AutenticacionDTO;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginTestPage extends MobilePageObject {
	
	public LoginTestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
	private WebElement tvUsuario;

    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
    private WebElement tvContrasena;

    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
    private WebElement btnLogin;
    
    @AndroidFindBy (xpath ="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.TextView[1]")
    private WebElement lbhome;
    
    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ScrollView[1]/android.widget.TextView[1]")
    private WebElement lbMensajeError;
    
    @AndroidFindBy (xpath = "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[4]")
    private WebElement btnLogout;
    
    @AndroidFindBy (xpath = "//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.Button[1]")
    private WebElement btnCerrarMsnErrorLogin;
    
	public void gotoWPLoginPage() {		
	}
	
	public void ingresarUsuario(String usuario) {		
		tvUsuario.sendKeys(usuario);
	}
	public void ingresarContrasena(String contrasena) {		
		tvContrasena.sendKeys(contrasena);
	}
	public void btnLogin() {		
		btnLogin.click();
	}

	
	public String autenticacion(AutenticacionDTO autenticacion) throws Exception {
		String resul= autenticacion.getMensaje();
		@SuppressWarnings("unused")
		String orientacion = null;
		if (resul.contains("EriBank")) {
			//excel.resultadoCasoAutenticacion(null);
			//aca llamo al metodo de excel update
			//orientacion= "Acierto";
			btnLogout.click();
			}
		else {
			orientacion= "Error";
		     btnCerrarMsnErrorLogin.click();
		    return orientacion;
		}
		return orientacion;
	}
	
	
	public void btnLogout() throws InterruptedException {		
		btnLogout.click();
		Thread.sleep(3000);
	}
	
	public void btnCerrarMsnErrorLogin() {		
		btnCerrarMsnErrorLogin.click();
	}
	
	
	public String home1(String EriBank) {	

		String verificarResultado = null;
		return verificarResultado;
		
	}
	
	public boolean home(String EriBank) {	
		boolean verificarResultado;
		String resultado = lbhome.getText();
		verificarResultado = resultado.contains(EriBank);
		return verificarResultado;
		
	}
	
	public boolean logueoNoExitoso(String Invalid) {		
		boolean verificarResultado;
		String resultado = lbMensajeError.getText();
		verificarResultado = resultado.contains(Invalid);
		return verificarResultado;
	}


}
