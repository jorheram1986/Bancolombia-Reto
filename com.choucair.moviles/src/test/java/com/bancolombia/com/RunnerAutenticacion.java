package com.bancolombia.com;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import com.bancolombia.com.util.BeforeSuite;
import com.bancolombia.com.util.DataToFeature;
//import Utilidades.BeforeSuite;
//import Utilidades.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;


@CucumberOptions(features = "src/test/resources/feature/Login.feature", tags = "@TestCase1", snippets = SnippetType.CAMELCASE, plugin = {
		"json:target/cucumber_json/cucumber.json" })

@RunWith(RunnerPersonalizado.class)
public class RunnerAutenticacion {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/feature/");
	}
}

