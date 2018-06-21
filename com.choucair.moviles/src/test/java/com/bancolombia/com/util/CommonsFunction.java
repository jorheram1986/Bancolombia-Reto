package com.bancolombia.com.util;

import static org.junit.Assert.assertThat;

import java.util.List;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import com.choucairtesting.eribank.util.CommonsFunction;
import DTO.AutenticacionDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.webdriver.WebDriverFacade;

public class CommonsFunction extends MobilePageObject {

	@SuppressWarnings("unchecked")
	AppiumDriver<MobileElement> conexionAppium = ((AppiumDriver<MobileElement>) ((WebDriverFacade) getDriver())
			.getProxiedDriver());

	public CommonsFunction(WebDriver driver) {

		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

	}

	/**
	 * Método que se encarga de esconder el teclado en la App
	 * 
	 * @param driver
	 * @throws Exception
	 */

	public void hideKeyboard() throws Exception {

		try {
			conexionAppium.hideKeyboard();

		} catch (Exception e) {
			System.out.println("Error al esconder el teclado");
		}
	}

	
	public String abrirGmail(AutenticacionDTO autenticacion) throws Exception {
		CommonsFunction funciones = new CommonsFunction(getDriver());
		String gmailTomarCorreo = "//android.view.View[@content-desc=\"\"]";
		String gmailAppPackageName = "com.google.android.gm";
		String gmailAppActivityName = ".GmailActivity";
		Activity activity = new Activity(gmailAppPackageName, gmailAppActivityName);
		activity.setAppWaitPackage(gmailAppPackageName);
		activity.setAppWaitActivity(gmailAppActivityName);
		activity.setStopApp(false); 
		Thread.sleep(2000);
		((AndroidDriver<MobileElement>) conexionAppium).startActivity(activity);
		Thread.sleep(2000);
		funciones.swipeVertical();
		funciones.swipeVertical();

		 WebElement  listaGmail= getDriver().findElement(By.className("android.support.v7.widget.RecyclerView"));				 
		 List<WebElement> contenidoGmail = listaGmail.findElements(By.className("android.view.View"));

		  for(WebElement el : contenidoGmail)  {
			  if(el.getAttribute("contentDescription") != null) {
				  if(el.getAttribute("contentDescription").contains("Seguridad")) 
			  		{
					  //gmailTomarCorreo = el.getAttribute("contentDescription").substring(66, 72);
					  gmailTomarCorreo = el.getAttribute("contentDescription").substring(74, 80);
					  break;
			  		}
				  }
	  }

		 conexionAppium.navigate().back();
		return gmailTomarCorreo;		
		
	}
	// ------------------------------------------------------------------------------------------------------------------------
	public void swipeHorizontal() throws Exception {

		try {
			for (int i = 0; i < 3; i++) {

				TouchAction action = new TouchAction(conexionAppium);
				action.press(0, 752).waitAction();
				action.moveTo(410, 0).waitAction();
				Thread.sleep(1000);
				action.release().perform().waitAction();
				Thread.sleep(1000);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void swipeVertical() throws Exception {

		try {
			for (int i = 0; i < 1; i++) {

				TouchAction action = new TouchAction(conexionAppium);

				action.press(500, 0).waitAction();
				action.moveTo(0, 300).waitAction();

				action.press(620, 0).waitAction();
				action.moveTo(0, 200).waitAction();

				Thread.sleep(1000);
				action.release().perform().waitAction();
				Thread.sleep(1000);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * Método que se encarga de interactuar con el teclado de Android presionando la
	 * tecla buscar
	 * 
	 * @param keycodeEnter
	 */
	@SuppressWarnings("unchecked")
	public void pressKey(int keycodeEnter) {
		try {
			CharSequence valorTeclado = "";
			System.out.println("Key " + keycodeEnter + " clicked");
			String funcionTeclado = String.valueOf(keycodeEnter);

			valorTeclado = funcionTeclado;

			assertThat("They are not equal!", "123", is("1234"));
			assertThat("123", is("123"));
			assertThat("Son iguales", "123456", is("1234"));
			// assertThat("Help! Integers don't work", 0, is(1));

			conexionAppium.getKeyboard().pressKey(valorTeclado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Matcher is(String string) {
		return null;
	}


	public String abrirAppMensaje() {
		String msnBancolombia="//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[2]/com.huawei.mms.ui.AvatarWidget[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
		String msnBancolombiaDentro="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/com.huawei.mms.ui.AvatarWidget[4]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";

		String mensajesAppPackageName = "com.android.mms";
		String mensajesAppActivityName = "com.android.mms.ui.ConversationList";
		//String mensajesAppActivityName = "com.huawei.rcs.ui.RcsGroupChatComposeMessageActivity";

		Activity activity = new Activity(mensajesAppPackageName, mensajesAppActivityName);
		activity.setAppWaitPackage(mensajesAppPackageName);
		activity.setAppWaitActivity(mensajesAppActivityName);
		activity.setStopApp(false);
		((AndroidDriver<MobileElement>) conexionAppium).startActivity(activity);
		conexionAppium.findElement(By.xpath(msnBancolombia)).click();
		msnBancolombia = conexionAppium.findElement(By.xpath(msnBancolombiaDentro)).getText().substring(135, 144);
		conexionAppium.navigate().back();
		conexionAppium.navigate().back();
		return msnBancolombia;		
		
	}
}