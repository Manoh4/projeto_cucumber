package br.com.cucumber.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.cadastro_conta.tela.TelaAdicionarConta;
import br.com.selenium.cadastro_conta.tela.TelaLogin;
import br.com.selenium.cadastro_conta.tela.TelaMenuInicial;
import br.com.selenium.utils.InitializeWebDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/CadastrarConta.feature",// Identificará a pasta em que se encontra o arquivo de features.
glue = "br.com.cucumber.steps", // Identificará o pacote em que estão os steps.
tags = {"~@Ignore"}, // Executará tudo, exceto o ue possuir a tag negada(~);{"@Tipo1", "@Tipo2"} - Executará somente cenários que possuem as duas tags; {"@Tipo1, @Tipo2"} - Executará todos os cenários que posssuirem uma das tags.
plugin = {"pretty", "json:target/json-reports/cucumber.json"}, // Formata a visualização dos relatórios do JUnit
monochrome = true, // Ignora as formatações de caracteres acentuados.
//snippets = SnippetType.CAMELCASE, // Formata os códigos não implementados ue forem gerados automaticamente no padrão cameo case ao invés de separar as palavras com underline.
dryRun = false, //Verifica se o validamento está sendo feito corretamente; Bom para validar testes muito demorados;
strict = false // Caso hajam especificações não implementadas, o teste falhará
)
public class Runner {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static TelaLogin telaLogin;
	private static TelaMenuInicial telaMenuInicial;
	private static TelaAdicionarConta telaAdicionarConta;
	
	@BeforeClass
	public static void instanciacaoDasVariaveis() {
		driver = InitializeWebDriver.getWebDriver();
		wait = new WebDriverWait(driver, 15);
		telaLogin = new TelaLogin(driver, wait);
		telaMenuInicial = new TelaMenuInicial(driver, wait);
		telaAdicionarConta = new TelaAdicionarConta(driver, wait);
		resetBanco();
	}

	
	public static void resetBanco() {
		driver.get("http://srbarriga.herokuapp.com/login");
		telaLogin.preencherUsuario("emanuel.estevao2.479@gmail.com");
		telaLogin.preencherSenha("Sorria123");
		telaLogin.clicarNoBotaoLogin();
		telaMenuInicial.clicarNoBotaoResetData();
	}

}
