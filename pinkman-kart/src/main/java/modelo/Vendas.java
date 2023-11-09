package modelo;

import java.time.LocalDate;

public class Vendas {

	private int idVenda;
	private Long FuncionarioCPF;
	private Float ValorDaVenda;
	private LocalDate dataVendas;
	private Integer idKarts;

	public Vendas() {}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public Long getFuncionarioCPF() {
		return FuncionarioCPF;
	}

	public void setFuncionarioCPF(Long funcionarioCPF) {
		FuncionarioCPF = funcionarioCPF;
	}

	public Float getValorDaVenda() {
		return ValorDaVenda;
	}

	public void setValorDaVenda(Float valorDaVenda) {
		ValorDaVenda = valorDaVenda;
	}

	public LocalDate getDataVendas() {
		return dataVendas;
	}

	public void setDataVendas(LocalDate dataVendas) {
		this.dataVendas = dataVendas;
	}

	public Integer getIdKarts() {
		return idKarts;
	}

	public void setIdKarts(Integer idKarts) {
		this.idKarts = idKarts;
	}

}
