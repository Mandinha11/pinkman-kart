package controle;

import java.util.ArrayList;

import modelo.Vendas;



public class VendasDAO {

	
	private static VendasDAO instancia;
	private static ArrayList<Vendas> listaVendas;

	public static VendasDAO getinstancia() {

		if (instancia == null) {
			instancia = new VendasDAO();
			listaVendas = new ArrayList<>();
		}
		return instancia;
	}

	public Boolean Inserir(Vendas v) {
		if(v!=null) {
			listaVendas.add(v);
			return true;
		}
		return false;
	}

	public Boolean Alterar(Vendas v) {
		return false;
	}

	public Boolean Deletar(Vendas v) {
		return false;
	}

	public ArrayList<Vendas> Listar() {
		return listaVendas;
	}
}



