package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

	public boolean inserir(Cliente c) {
		if (c != null) {

			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO clientes (id_cliente, nome_completo, data_nascimento, cpf, telefone) VALUES (??,??,??,??,??)";
			
			try {

				PreparedStatement ps = conn.prepareStatement(query);

				ps.setLong(1, c.getIdCliente());
				ps.setString(2, c.getNomeCompleto());
				ps.setLong(3, c.getDataNac());
				ps.setLong(4, c.getCpf());
				ps.setLong(5, c.getTelefone());

				ps.executeUpdate();

				con.fecharConexao();

				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;

	}

	public Boolean alterar(Cliente c) {
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE cliente SET nome_completo = ?, telefone = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, c.getNomeCompleto());
			ps.setLong(2, c.getTelefone());

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}
		return false;
	}

	public Boolean deletar(Cliente c) {

		Conexao con = Conexao.getInstancia();
		
		Connection conn = con.conectar();

		String query = "DELETE FROM cliente WHERE id_cliente = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, c.getIdCliente());
			

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}
		return false;
	}

	public ArrayList<Cliente> listar() {
		return null;
	}

}
