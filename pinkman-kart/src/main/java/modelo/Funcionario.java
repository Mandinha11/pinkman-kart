package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Funcionario {

	private Long Matricula;
	private Long Cpf;
	private String nomeCompleto;
	private LocalDate dataNac;
	private String cargo;
	private String senha;

	public Funcionario() {
		this.senha = "usuario";
	}

	public Funcionario(Long matricula, Long cpf, String nomeCompleto, LocalDate dataNac, String cargo, String senha) {

		Matricula = matricula;
		Cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.dataNac = dataNac;
		this.cargo = cargo;
		this.senha = "Usuario";
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Long getMatricula() {

		return Matricula;
	}

	public void setMatricula(Long matricula) {
		Matricula = matricula;
	}

}
