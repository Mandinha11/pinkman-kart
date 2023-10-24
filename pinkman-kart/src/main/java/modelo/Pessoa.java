package modelo;

import java.time.LocalDate;

public abstract class Pessoa {

	private String nomeCompleto;
	private Long cpf;
	private LocalDate dataNac;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNac() {
		return dataNac;
	}

	public void setDataNac(LocalDate dataNac) {
		this.dataNac = dataNac;
	}

}
