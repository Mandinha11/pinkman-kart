package controle;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Fornecedor;

public class FornecedorDAO {

	private static FornecedorDAO instancia;
	private static ArrayList<Fornecedor> listaFornecedores;

	public static FornecedorDAO getinstancia() {

		if (instancia == null) {
			instancia = new FornecedorDAO();
			listaFornecedores = new ArrayList<>();
		}
		return instancia;
	}

	public Boolean Inserir(Fornecedor f) {
		if(f!=null) {
			listaFornecedores.add(f);
			return true;
		}
		return false;
	}

	//public Boolean Alterar(Fornecedor f) {
		
	//}

	public Boolean Deletar(Fornecedor f) {
		if (f != null) {
			listaFornecedores.remove(f);
			return true;
		}
		return false;
	}

	public ArrayList<Fornecedor> Listar() {
		return listaFornecedores;
	}
}