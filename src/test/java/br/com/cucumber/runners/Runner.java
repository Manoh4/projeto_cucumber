package br.com.cucumber.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
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

}
