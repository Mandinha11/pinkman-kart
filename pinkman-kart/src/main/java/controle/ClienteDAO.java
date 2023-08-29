package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDAO {
	
	private static ClienteDAO instancia;
	public ArrayList<Cliente> listar() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		
		String query = "SELECT * FROM clientes";
		ArrayList<Cliente> clientes = new ArrayList();
		
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				long telefone = rs.getLong("Telefone");
				long dataNac = rs.getLong("data_de_nascimento");
				long cpf = rs.getLong("cpf");
				String nomeCompleto = rs.getString("nome_completo");
				
				Cliente cl = new Cliente();
				
				cl.setTelefone(telefone);
				cl.setNomeCompleto(nomeCompleto);
				cl.setCpf(cpf);
				cl.setDataNac(dataNac);

				clientes.add(cl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.fecharConexao();
		}


		return clientes;

	}

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
			String query = "INSERT INTO clientes (id_cliente, nome_completo, data_nascimento, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
			
			try {

				PreparedStatement ps = conn.prepareStatement(query);

				
				ps.setString(2, c.getNomeCompleto());
				ps.setLong(3, c.getDataNac());
				ps.setLong(4, c.getCpf());
				ps.setLong(5, c.getTelefone());

				ps.executeUpdate();


				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}

		}

		return false;

	}

	public Boolean Alterar(Cliente c) {
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE cliente SET nome_completo = ?, telefone = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, c.getNomeCompleto());
			ps.setLong(2, c.getTelefone());

			ps.executeUpdate();


			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			con.fecharConexao();
		}
		return false;
	}

	public Boolean Deletar(Cliente c) {

		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "DELETE FROM cliente WHERE cpf = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, c.getCpf());
			ps.executeUpdate();

			con.fecharConexao();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			con.fecharConexao();
		}
		return false;
	}

}
