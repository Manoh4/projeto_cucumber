package br.com.cucumber.servicos;

import java.util.Calendar;

import br.com.cucumber.entidades.Filme;
import br.com.cucumber.entidades.NotaAluguel;
import br.com.cucumber.utils.DateUtil;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme, String tipoAluguel) {
		if(filme.getEstoque() == 0)throw new RuntimeException("Filme sem estoque");
			
		NotaAluguel nota = new NotaAluguel();
		if("extendido".equals(tipoAluguel)) {
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(DateUtil.obterDataComDiferencaDeDias(3));
			nota.setPontuacao(2);
		}
		else {
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(DateUtil.obterDataComDiferencaDeDias(1));
			nota.setPontuacao(1);
		}	
		filme.setEstoque(filme.getEstoque()-1);
		return nota;
	}
}
