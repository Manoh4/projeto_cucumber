package br.com.selenium.cadastro_conta.tela;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.acoes_genericas.AcoesGenericas;

public class TelaAdicionarConta extends AcoesGenericas{

	public static WebDriver driver;
	public static WebDriverWait wait;

	/// SELETORES
	public static final String INPUT_CONTA = "//input[@id='nome']";
	public static final String BUTTON_SALVAR = "//button[text()='Salvar']";
	public static final String MSG_INFORME_NOME_DA_CONTA = "//div[text()='Informe o nome da conta']";
	public static final String MSG_CONTA_JA_CADASTRADA = "//div[text()='Já existe uma conta com esse nome!']";

	public TelaAdicionarConta(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void preencherNomeDaConta(String texto) {
		preencherCampo(INPUT_CONTA, texto);
	}
	
	public void clicaNoBotaoSalvar() {
		clicarNoElemento(BUTTON_SALVAR);
	}
	
	public boolean verificarExistenciaDaMsgInformeONomeDaConta() {
		return verificaExistenciaDoElemento(MSG_INFORME_NOME_DA_CONTA);
	}
	
	public boolean verificarExistenciaDaMsgContaJaCadastrada() {
		return verificaExistenciaDoElemento(MSG_CONTA_JA_CADASTRADA);
	}
}
