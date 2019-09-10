package br.com.selenium.cadastro_conta.tela;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.acoes_genericas.AcoesGenericas;

public class TelaMenuInicial extends AcoesGenericas{
	
	public static WebDriver driver;
	public static WebDriverWait wait;
//	private static Actions actions;

	/// SELETORES
	public static final String DROPDOWN_CONTAS = "//li[@class='dropdown']/a[contains(text(),'Contas')]";
	public static final String OPTION_ADICIONAR_CONTA = "//a[contains(text(),'Adicionar')]";
	public static final String OPTION_LISTAR_CONTAS = "//a[contains(text(),'Listar')]";
	public static final String SAIR = "//a[contains(text(),'Sair')]";
	public static final String MSG_BEM_VINDO = "//div[@class='alert alert-success'][contains(.,'Bem vindo, Emanuel Preto Cardoso!')]";
	public static final String MSG_CONTA_ADICIONADA = "//div[@class='alert alert-success'][contains(.,'Conta adicionada com sucesso!')]";
	public static final String HIDDEN_LINK_RESET = "//a[contains(text(),'reset')]";
	
	public TelaMenuInicial(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clicaNoDropdownContas() {
		clicarNoElemento(DROPDOWN_CONTAS);
	}
	
	public void clicaParaAdicionarConta() {
		clicarNoElemento(OPTION_ADICIONAR_CONTA);
	}
	
	public void clicaParaListarContas() {
		clicarNoElemento(OPTION_LISTAR_CONTAS);
	}
	
	public void clicaSair() {
		clicarNoElemento(SAIR);
	}
	
	public boolean verificaMensagemDeBemVindo() {
		return verificaExistenciaDoElemento(MSG_BEM_VINDO);
	}
	
	public boolean verificaMensagemContaAdicionadaComSucesso() {
		return verificaExistenciaDoElemento(MSG_CONTA_ADICIONADA);
	}

	public void clicarNoBotaoResetData() {
		clicarNoElemento(HIDDEN_LINK_RESET);
	}
}
