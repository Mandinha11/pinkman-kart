package modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.xml.crypto.Data;

public class Vendas {
	
<<<<<<< HEAD
	private Long idVendas;
	private String kart;
	private String cliente;
	private Long preco;
	private Long data;
	
=======
	private Long FuncionarioCPF;
	private Long ValorDaVenda;
	private LocalDate dataVendas;
	private Long idKarts;
>>>>>>> TelaKarts-Vendas
	
	
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
<<<<<<< HEAD
	
=======


	public void setdataVendas(LocalDate dataVendas) {
	this.dataVendas = dataVendas;
		
	}
	public LocalDate getdataVendas() {
		return dataVendas;
	}
	
}

	
	
	



