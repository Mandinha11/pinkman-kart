package modelo;

public class Cliente {

	private String nomeCompleto;
	private Long cpf;
	private Long dataNac;
	private Long telefone;
	private Long IdCliente;
	
	
	public Cliente(String nomeCompleto, Long cpf, Long dataNac, Long telefone, Long idCliente) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.dataNac = dataNac;
		this.telefone = telefone;
		IdCliente = idCliente;
	}

	public Long getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Long idCliente) {
		IdCliente = idCliente;
	}

	public Cliente() {
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
