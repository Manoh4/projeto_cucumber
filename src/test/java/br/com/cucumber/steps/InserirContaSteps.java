package br.com.cucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.cadastro_conta.tela.TelaAdicionarConta;
import br.com.selenium.cadastro_conta.tela.TelaLogin;
import br.com.selenium.cadastro_conta.tela.TelaMenuInicial;
import br.com.selenium.utils.InitializeWebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class InserirContaSteps {
	private WebDriver driver;
	private WebDriverWait wait;
	private TelaLogin telaLogin;
	private TelaMenuInicial telaMenuInicial;
	private TelaAdicionarConta telaAdicionarConta;
	
	@Before
	public void instanciacaoDasVariaveis() {
		driver = InitializeWebDriver.getWebDriver();
		wait = new WebDriverWait(driver, 15);
		telaLogin = new TelaLogin(driver, wait);
		telaMenuInicial = new TelaMenuInicial(driver, wait);
		telaAdicionarConta = new TelaAdicionarConta(driver, wait);
	}

	@After
	public void closeSession() {
		driver.close();
	}
	
	@Dado("^que estou acessando a aplicação$")
	public void que_estou_acessando_a_aplicação() throws Throwable {
		driver.get("http://srbarriga.herokuapp.com/login");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informo_o_usuário(String arg1) throws Throwable {
		telaLogin.preencherUsuario("emanuel.estevao2.479@gmail.com");
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void a_senha(String arg1) throws Throwable {
		telaLogin.preencherSenha("Sorria123");
	}

	@Quando("^seleciono entrar$")
	public void seleciono_entrar() throws Throwable {
		telaLogin.clicarNoBotaoLogin();
	}

	@Então("^visualizo a página inicial$")
	public void visualizo_a_página_inicial() throws Throwable {
		Assert.assertTrue("O menu inicial não foi carregado!", telaMenuInicial.verificaMensagemDeBemVindo());
	}

	@Quando("^seleciono Contas$")
	public void seleciono_Contas() throws Throwable {
		telaMenuInicial.clicaNoDropdownContas();
	}

	@Quando("^seleciono Adicionar$")
	public void seleciono_Adicionar() throws Throwable {
		telaMenuInicial.clicaParaAdicionarConta();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informo_a_conta(String texto) throws Throwable {
		telaAdicionarConta.preencherNomeDaConta(texto);
	}

	@Quando("^seleciono Salvar$")
	public void seleciono_Salvar() throws Throwable {
		telaAdicionarConta.clicaNoBotaoSalvar();
	}

	@Então("^a conta é inserida com sucesso$")
	public void a_conta_é_inserida_com_sucesso() throws Throwable {
		Assert.assertTrue("A mensagem 'Conta adicionada com sucesso não foi exibida'!",telaMenuInicial.verificaMensagemContaAdicionadaComSucesso());
	}
}
