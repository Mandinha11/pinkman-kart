package modelo;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		
		
		
		MaskFormatter mascaraCNPJ1 = null;
		try {
			MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
	        mask.setValueContainsLiteralCharacters(false);
	        return mask.valueToString(String.valueOf(cnpj));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("fora");
		return String.valueOf(cnpj);
	}	

}
