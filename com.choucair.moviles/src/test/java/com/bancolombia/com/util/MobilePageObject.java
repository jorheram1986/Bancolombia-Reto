package com.bancolombia.com.util;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.google.common.base.Predicate;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class MobilePageObject extends PageObject{

	// https://github.com/ricardorlg/serenityappiumbug/issues/1
	// WhenUsingCustomLogicForElementsInit.java, PageObject.java
	public MobilePageObject(final WebDriver driver) {
		super(driver, new Predicate<PageObject>() {
			public boolean apply(PageObject page) {

				PageFactory.initElements(
						new AppiumFieldDecorator(((WebDriverFacade) page
								.getDriver()).getProxiedDriver(), page
								.getImplicitWaitTimeout().in(TimeUnit.SECONDS),
								TimeUnit.SECONDS), page);
				return true;
			}

		});

	}




}
