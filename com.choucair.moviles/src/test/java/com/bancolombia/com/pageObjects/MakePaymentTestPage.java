package com.bancolombia.com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.bancolombia.com.util.CommonsFunction;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MakePaymentTestPage extends MobilePageObject{
	public MakePaymentTestPage (WebDriver driver) {
		super (driver);
	}
	CommonsFunction cm = new CommonsFunction(getDriver());

	
	@AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
	private WebElement btnPagos;
	
	@AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
	private WebElement tvPhone;
	
	@AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
	private WebElement tvName;
	
	@AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]")
	private WebElement tvCantidad;
	
	@AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.EditText[1]")
	private WebElement tvPais;
	
    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
    private WebElement EnviarPago;
	
    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.Button[1]")
    private WebElement ConfirmarPagoExitoso;
	
    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]")
    private WebElement tuBalanceEs;
	
	public void makePayment() {
		btnPagos.click();
		
	}
     	
    public void ingresarPhone(String telefono) {
		tvPhone.sendKeys(telefono);
	}
	
	public void ingresarNombre(String nombre) {
		tvName.sendKeys(nombre);
	}
	
	public void ingresarCantidad(String cantidad) {
		tvCantidad.sendKeys(cantidad);
	}
	
	public void ingresarPais(String pais) {
		tvPais.sendKeys(pais);
	}
	
	public void enviarPago () {
		EnviarPago.click();
	}
	public void confirmarPagoExitoso () {
		ConfirmarPagoExitoso.click();
	}
	
	public boolean tuBalanceEs () {
		boolean verificarResultado;
		String tuBalance = "balance";
		String resultado = tuBalanceEs.getText();
		verificarResultado = resultado.contains(tuBalance);
		return verificarResultado;
		
	}
}
