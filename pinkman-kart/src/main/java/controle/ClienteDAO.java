package controle;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDAO {

	private static ClienteDAO instancia;

	public static ClienteDAO getinstancia() {

		if (instancia == null) {
			instancia = new ClienteDAO();
		}
		return instancia;
	}

	public Boolean inserir(Cliente c) {
		if (c != null) {

			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO";

		}
		return false;
	}

	public Boolean alterar(Cliente c) {

		return false;
	}

	public Boolean deletar(Cliente c) {

		return false;
	}

	public ArrayList<Cliente> listar() {
		return null;
	}

}
