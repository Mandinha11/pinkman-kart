package modelo;

import java.time.LocalDate;

public class Cliente {

	private String nomeCompleto;
	private Long cpf;
	private LocalDate dataNac;
	private Long telefone;

	public Cliente() {
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

	public void setDataNac(LocalDate dataNac) {
		this.dataNac = dataNac;
	}

	public String getNomeEmpresa() {
		return nomeCompleto;
	}

	public void setNomeEmpressa(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

}
