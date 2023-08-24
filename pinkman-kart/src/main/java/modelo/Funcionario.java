package modelo;

import java.sql.Date;

public class Funcionario {
	
	private Long Matricula;
	private Long Cpf;
	private String nomeCompleto;
	private java.util.Date dataNac;
	private String cargo;
	
    public Funcionario(){
		this.Matricula = 1l;
	}
    
    public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public java.util.Date getDataNac() {
		return dataNac;
	}

	public void setDataNac(java.util.Date dataNascimento) {
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
