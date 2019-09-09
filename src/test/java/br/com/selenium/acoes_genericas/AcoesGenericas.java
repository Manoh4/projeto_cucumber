package br.com.selenium.acoes_genericas;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcoesGenericas {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Actions actions;
	
	public AcoesGenericas(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	protected void preencherCampo(String input, String texto) {
		esperarElementoEstarDisponivel(input).sendKeys(texto);
//		wait.until(ExpectedConditions.textToBe(By.xpath(input), texto));
	}
	
	protected void clicarNoElemento(String elemento) {
		esperarElementoEstarDisponivel(elemento).click();
	}

	
	protected boolean verificaExistenciaDoElemento(String elemento) {
		try {
			esperarElementoEstarDisponivel(elemento);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	/**
	 * Irá esperar que o elemento cujo xpath foi passado por parâmetro esteja disponível para ser utilizado.
	 * @param elemento
	 */
	protected WebElement esperarElementoEstarDisponivel(String elemento) throws TimeoutException{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elemento)));
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elemento)));
	}
}
