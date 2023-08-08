package modelo;

public class Fornecedor {
	
	private String NomeEmpresa;
	private Long cnpj;
	private Long cep;
	private Long telefone;
	
	public Fornecedor(){
		
	}
	
	public String getNomeEmpresa() {
		return NomeEmpresa;
	}
	public void setNomeEmpresa(String NomeEmpresa) {
		this.NomeEmpresa = NomeEmpresa;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	

}
