package br.com.cucumber.entidades;

public class Filme {

	private Integer estoque;
	private Integer aluguel;

	public void setEstoque(int qtd) {
		this.estoque = qtd;
	}

	public void setAluguel(int valor) {
		this.aluguel = valor;
	}

	public Integer getAluguel() {
		return aluguel;
	}
	
	public Integer getEstoque() {
		return estoque;
	}

}
