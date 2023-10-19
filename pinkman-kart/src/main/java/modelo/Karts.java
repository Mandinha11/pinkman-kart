package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Karts {
	
	private String modelo;
	private String marca;
	private long preco;
	private long ano;
	private long quantidade;
	private String cor;
	private LocalDate dataEntrada;
	private long Id;
	private String motor;
	private long CNPJ;
	
	public Karts(){
		
	}
	
	public String getmodelo() {
		return modelo;
	}
	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getmarca() {
		return marca;
	}
	public void setmarca(String marca) {
		this.marca = marca;
	}
	
	
	public long getpreco() {
		return preco;
	}
	public void setpreco(long preco) {
		this.preco = preco;
	}
	
	
	public long getano() {
		return ano;
	}
	public void setano(long ano) {
		this.ano = ano;
	}
	
	
	public long getquantidade() {
		return quantidade;
	}
	public void setquantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getcor() {
		return cor;
	}
	public void setcor(String cor) {
		this.cor = cor;
	}
	
	public String getmotor() {
		return motor;
	}
	public void setmotor(String motor) {
		this.motor = motor;
	}
	
	public LocalDate getdataEntrada() {
		return dataEntrada;
	}
	public void setdataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}

	public void setCNPJ(long CNPJ) {
		this.CNPJ = CNPJ;
		
	}
	public long CNPJ() {
		return CNPJ;
	}
	

}



