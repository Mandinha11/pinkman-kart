package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Karts {
	
	private String modelo;
	private String marca;
	private Long preco;
	private long ano;
	private long quantidade;
	private String cor;
	private LocalDate dataEntrada;
	private Integer Id;
	private Long CNPJ;
	
	public Karts(){
		
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public Long getpreco() {
		return preco;
	}
	public void setpreco(Long preco) {
		this.preco = preco;
	}
	
	
	public Long getano() {
		return ano;
	}
	public void setano(Long ano) {
		this.ano = ano;
	}
	
	
	public Long getquantidade() {
		return quantidade;
	}
	public void setquantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}

	public void setCNPJ(Long CNPJ) {
		this.CNPJ = CNPJ;
		
	}
	public Long CNPJ() {
		return CNPJ;
	}

	public void setCNPJ1(Long cNPJ) {
		CNPJ = CNPJ;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(Id);

}
	


}
