package modelo;

public class Karts {
	
	private String modelo;
	private String marca;
	private Long preco;
	private Long ano;
	private Long quantidade;
	private String cor;
	private Long dataEntrada;
	private Long Id;
	private String motor;
	private Long CNPJ;
	
	public Karts(){
		
	}
	
	public String getmodelo() {
		return modelo;
	}
	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getmarca() {
		return marca;
	}
	public void setmarca(String marca) {
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
	
	public String getcor() {
		return cor;
	}
	public void setcor(String cor) {
		this.cor = cor;
	}
	
	public String getmotor() {
		return motor;
	}
	public void setmotor(String motor) {
		this.motor = motor;
	}
	
	public Long getdataEntrada() {
		return dataEntrada;
	}
	public void setdataEntrada(Long dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}

	public void setCNPJ( Long CNPJ) {
		this.CNPJ = CNPJ;
		
	}
	public Long getCNPJ() {
		return CNPJ;
		
	}
	

}



