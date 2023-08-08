package modelo;

public class Vendas {
	
	private String kart;
	private String cliente;
	private Long preco;
	private Long data;
	private Long matricula;
	
	
	public Vendas(){
		
	}
	
	public String getkarts() {
		return kart;
	}
	public void setkarts(String karts) {
		this.kart = karts;
	}
	
	public String getcliente() {
		return cliente;
	}
	public void setcliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	public Long getpreco() {
		return preco;
	}
	public void setpreco(Long preco) {
		this.preco = preco;
	}
	
	
	public Long getdata() {
		return data;
	}
	public void setdata(Long data) {
		this.data = data;
	}
	public Long getmatricula() {
		return matricula;
	}
	public void setmatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	
		
	}
	
	
	



