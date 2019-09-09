package br.com.cucumber.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.cucumber.entidades.Filme;
import br.com.cucumber.entidades.NotaAluguel;
import br.com.cucumber.servicos.AluguelService;
import br.com.cucumber.utils.DateUtil;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AlugarFilmesSteps {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private String tipoAluguel;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void um_filme_com_estoque_de_unidades(int qtd) throws Throwable {
		filme = new Filme();
		filme.setEstoque(qtd);
	}

	@Dado("^que o preço do aluguel seja R\\$(\\d+)$")
	public void que_o_preço_do_aluguel_seja_R$(int valor) throws Throwable {
		filme.setAluguel(valor);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Então("^o preço do aluguel será R\\$ (\\d+)$")
	public void o_preço_do_aluguel_será_R$(Integer arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void o_estoque_do_filme_será_unidade(Integer arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	}

	@Então("^não será possível por falta de estoque$")
	public void não_será_possível_por_falta_de_estoque() throws Throwable {
		Assert.assertEquals("Filme sem estoque", erro);
	}

	@Dado("^que o tipo do aluguel seja (.*)$")
	public void que_o_tipo_do_aluguel_seja_extendido(String categoria) throws Throwable {
		tipoAluguel = categoria;
	}

	@Então("^a data da entrega será em (\\d+) dias?$")// S é opcional com o ?
	public void a_data_da_entrega_será_em_dias(Integer dias) throws Throwable {
		Date dataEsperada = DateUtil.obterDataComDiferencaDeDias(dias);
		Date dataReal = nota.getDataEntrega();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Então("^a pontuação será de (\\d+) pontos$")
	public void a_pontuação_será_de_pontos(Integer arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPontuacao());
	}
	

}
