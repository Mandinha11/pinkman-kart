package controle;
import modelo.Cliente;


import java.sql.Connection;
import java.util.ArrayList;


public class ClienteDAO {

	private static ClienteDAO instancia;
	private static ArrayList<Cliente> listaCliente;

	public static ClienteDAO getinstancia() {

		if (instancia == null) {
			instancia = new ClienteDAO();
			listaCliente = new ArrayList<>();
		}
		return instancia;
	}

	public Boolean Inserir(Cliente c) {
		if (c != null) {
			listaCliente.add(c);
			return true;
			
			Conexao c = conexao.getInstancia();
			
			Connection con = c.conectar();
			
			String query = "INSERT INTO";
			
		}
		return false;
	}

	public Boolean Alterar(Cliente c) {
		for (Cliente cliente : listaCliente) {
			if (c.getCpf() == cliente.getCpf()) {
				cliente.setNomeEmpressa(c.getNomeEmpresa());
				cliente.setTelefone(c.getTelefone());
				return true;
			}
		}
		return false;
	}

	public Boolean Deletar(Cliente c) {
		if (c != null) {
			listaCliente.remove(c);
			return true;
		}
		return false;
	}
	
	public ArrayList<Cliente> Listar() {
		return listaCliente;
	}
	public static ArrayList<Cliente> listarCliente() {
		return listaCliente;
	}
}
