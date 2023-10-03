package modelo;

public class Vendas {
	
	private Long idVendas;
	private String kart;
	private String cliente;
	private Long preco;
	private Long data;
	
	
	
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
	

	public void setIdVendas(Long idVendas) {
		this.idVendas = idVendas;
	}

	public long getIdVendas() {
		
		return idVendas;
	}
	
	
		
	}
	
	
	



