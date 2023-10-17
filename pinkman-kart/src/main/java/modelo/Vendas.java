package modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.xml.crypto.Data;

public class Vendas {
	
	private Long FuncionarioCPF;
	private Long clienteCPF;
	private Long ValorDaVenda;
	private LocalDate dataVendas;
	private Long idKarts;
	
	
	public Vendas(){
		
	}
	
	public void setidKarts(Long idKarts) {
		this.idKarts = idKarts;
	}

	public Long getidkarts() {
		return idKarts;
	}
	public void setFuncionarioCPF(Long FuncionarioCPF) {
		this.FuncionarioCPF = FuncionarioCPF;
	}
	public Long getFuncionarioCPF() {
		return FuncionarioCPF;
	}

	public void setValorDaVenda(Long ValorDaVenda) {
		this.ValorDaVenda = ValorDaVenda;
		
	}
	public Long getValorDaVenda() {
		return ValorDaVenda;
	}

	public void setclienteCPF(Long clienteCPF) {
		this.clienteCPF = clienteCPF;
	}
	public Long getclienteCPF() {
		return clienteCPF;
		
	}



	public void setdataVendas(LocalDate dataVendas) {
	this.dataVendas = dataVendas;
		
	}
	public LocalDate getdataVendas() {
		return dataVendas;
	}
	
}

	
	
	



