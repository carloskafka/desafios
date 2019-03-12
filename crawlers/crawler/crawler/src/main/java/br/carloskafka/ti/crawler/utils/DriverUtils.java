package br.carloskafka.ti.crawler.utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {
	private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String GECKODRIVER_PATH = "src/test/resources/geckodriver.exe";

	private static final int TEMPO_ESPERA_EM_SEGUNDOS = 3;
	private static final int TEMPO_POOLING_EM_SEGUNDOS = 1;

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	private static List<WebElement> obterElementosPor(By by) {
		try {
			return driver.findElements(by);
		} catch (StaleElementReferenceException e) {
			return obterElementosPor(by);
		}
	}

	public static List<WebElement> obterElementosPorTag(String tag) {
		return obterElementosPor(By.tagName(tag));
	}

	public static void clicar(WebElement elemento) {
		elemento.click();
	}

	public static String obterTexto(WebElement elemento) {
		try {
			return elemento.getText();
		} catch (StaleElementReferenceException e) {
			return obterTexto(elemento);
		}
	}

	private static WebElement esperarElementoAparecer(WebElement elemento) {
		return obterWebDriverWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elemento)));
	}

	public static WebElement esperarElementoAparecerPorElemento(WebElement elemento) {
		return esperarElementoAparecer(elemento);
	}

	public static boolean esperarTituloConterTexto(String titulo) {
		return obterWebDriverWait().until(ExpectedConditions.titleIs(titulo));
	}

	private static FluentWait<WebDriver> obterWebDriverWait() {
		return new WebDriverWait(driver, TEMPO_ESPERA_EM_SEGUNDOS)
				.pollingEvery(Duration.ofSeconds(TEMPO_POOLING_EM_SEGUNDOS));
	}

	public static void ir(String url) {
		getDriver().get(url);
	}

	public static void finalizarDriver() {
		if (driver != null) {
			driver.close();
		}
	}

	public static void inicializarFirefoxDriver() {
		if (driver == null) {
			System.setProperty(GECKO_DRIVER_PROPERTY, GECKODRIVER_PATH);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(TEMPO_ESPERA_EM_SEGUNDOS, TimeUnit.SECONDS);
		}
	}

}