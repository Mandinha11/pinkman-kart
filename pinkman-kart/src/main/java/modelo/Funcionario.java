package modelo;

public class Funcionario {
	
	private String Matricula;
	private Long Cpf;
	private String nomeCompleto;
	private Long dataNac;
	private String cargo;
	
    public Funcionario(){
		
	}
    
    
    
    public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public Long getDataNac() {
		return dataNac;
	}

	public void setDataNac(Long dataNac) {
		this.dataNac = dataNac;
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

		public String getMatricula() {
			
			return Matricula;
		}
    
    
	
}
