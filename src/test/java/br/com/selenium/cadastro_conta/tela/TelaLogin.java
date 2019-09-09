package br.com.selenium.cadastro_conta.tela;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.acoes_genericas.AcoesGenericas;

public class TelaLogin extends AcoesGenericas {

	public static WebDriver driver;
	public static WebDriverWait wait;
//	private static Actions actions;

	/// SELETORES
	public static final String INPUT_USUARIO = "//input[@id='email']";
	public static final String INPUT_SENHA = "//input[@id='senha']";
	public static final String BUTTON_LOGIN = "//button[text()='Entrar']";

	public TelaLogin(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		this.wait = wait;
	}

	public void preencherUsuario(String usuario) {
		preencherCampo(INPUT_USUARIO, usuario);
	}

	public void preencherSenha(String senha) {
		preencherCampo(INPUT_SENHA, senha);
	}

	public void clicarNoBotaoLogin() {
		clicarNoElemento(BUTTON_LOGIN);
	}

}
