package modelo;

import java.time.LocalDate;

public class Funcionario {

	
	private Long Cpf;
	private String nomeCompleto;
	private LocalDate dataNac;
	private String cargo;
	

	public Funcionario() {
	
	}
	public Funcionario(Long cpf, String nomeCompleto, LocalDate dataNac, String cargo) {
		this.Cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.dataNac = dataNac;
		this.cargo = cargo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNac() {
		return dataNac;
	}

	public void setDataNac(LocalDate dataNascimento) {
		this.dataNac = dataNascimento;
	}

	public Long getCpf() {
		return Cpf;
	}

	public void setCpf(Long cpf) {
		this.Cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
