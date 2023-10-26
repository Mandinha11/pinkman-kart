package modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.xml.crypto.Data;

public class Vendas {
	
	

	private Long FuncionarioCPF;
	private Float ValorDaVenda;
	private LocalDate dataVendas;
	private Integer idKarts;
	
	
	public Vendas(){
		
	}
	
	public void setidKarts(Integer idKarts) {
		this.idKarts = idKarts;
	}

	public Integer getidkarts() {
		return idKarts;
	}
	public void setFuncionarioCPF(Long FuncionarioCPF) {
		this.FuncionarioCPF = FuncionarioCPF;
	}
	public Long getFuncionarioCPF() {
		return FuncionarioCPF;
	}

	public void setValorDaVenda(Float ValorDaVenda) {
		this.ValorDaVenda = ValorDaVenda;
		
	}
	public Float getValorDaVenda() {
		return ValorDaVenda;
	}


	public void setdataVendas(LocalDate dataVendas) {
	this.dataVendas = dataVendas;
		
	}
	public LocalDate getdataVendas() {
		return dataVendas;
	}
	
}

	
	
	



