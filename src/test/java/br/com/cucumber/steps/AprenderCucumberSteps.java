package br.com.cucumber.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.cucumber.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {

	@Dado("^que criei o arquivo corretamente$")
	public void que_criei_o_arquivo_corretamente() throws Throwable {
	}

	@Quando("^executá-lo$")
	public void executá_lo() throws Throwable {
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void a_especificação_deve_finalizar_com_sucesso() throws Throwable {
	}

	private Integer contador = 0;

	@Dado("^que o valor do contador é (\\d+)$")
	public void que_o_valor_do_contador_é(Integer valor) throws Throwable {
		contador = valor;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void eu_incrementar_em(Integer valor) throws Throwable {
		contador += valor;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void o_valor_do_contador_será(Integer valor) throws Throwable {
		Assert.assertEquals(valor, contador);
	}

	private Date entrega = new Date();
	@Dado("^que a entrega é dia (.*)$")
	public void que_a_entrega_é_dia(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void a_entrega_atrasar_em_dias(Integer valor, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if(tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, valor);
		}
		if(tempo.equals("meses")) {
			cal.add(Calendar.MONTH, valor);
		}
		entrega = cal.getTime();
	}

	@Então("^a entrega será efetuada no dia (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void a_entrega_será_efetuada_no_dia(String data) throws Throwable {
		DateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}

	@Dado("^que o ticket( especial)? é (A.\\d{3})$")// O espaço antes do especial é importante!
	public void que_o_ticket_é_AF(String tipo, String arg1) throws Throwable {
	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void que_o_valor_da_passagem_é_R$(Double valor) throws Throwable {
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void que_o_nome_do_passageiro_é(String arg1) throws Throwable {
	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void que_o_telefone_do_passageiro_é(String telefone) throws Throwable {
	}

	@Quando("^criar os steps$")
	public void criar_os_steps() throws Throwable {
	}

	@Então("^o teste vai funcionar$")
	public void o_teste_vai_funcionar() throws Throwable {
	}
}
