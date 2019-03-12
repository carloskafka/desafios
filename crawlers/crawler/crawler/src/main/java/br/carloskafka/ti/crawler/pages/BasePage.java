package br.carloskafka.ti.crawler.pages;

import org.openqa.selenium.support.PageFactory;

import br.carloskafka.ti.crawler.utils.DriverUtils;

public abstract class BasePage {

	public BasePage() {
		PageFactory.initElements(DriverUtils.getDriver(), this);		
	}

	protected boolean validPage(String titulo) {
		DriverUtils.esperarTituloConterTexto(titulo);
		return tituloCorreto(titulo);
	}

	private boolean tituloCorreto(String titulo) {
		return DriverUtils.getDriver().getTitle().equals(titulo);
	}

}