package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDAO {

	public ArrayList<Cliente> listar() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Cliente> clientes = new ArrayList();

		String query = "SELECT * FROM cliente";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Long IdCliente = rs.getLong("Id_Cliente");
				long telefone = rs.getLong("telefone");
				long dataNac = rs.getLong("data_de_nascimento");
				long cpf = rs.getLong("cpf");
				String nomeCompleto = rs.getString("nome_completo");
				
				Cliente cl = new Cliente();
				
				cl.setIdCliente(IdCliente);
				cl.setNomeCompleto(nomeCompleto);
				cl.setTelefone(telefone);
				cl.setCpf(cpf);
				
				LocalDate dataNascimento = LocalDate.ofEpochDay(dataNac);
				
				cl.setDataNac(dataNascimento);

				clientes.add(cl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.fecharConexao();
		}


		return clientes;

	}

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
			String query = "INSERT INTO clientes (id_cliente, nome_completo, data_nascimento, cpf, telefone) VALUES (?,?,?,?)";
			
			try {

				PreparedStatement ps = conn.prepareStatement(query);

				java.sql.Date dataNascimento = java.sql.Date.valueOf(c.getDataNac());
				ps.setString(2, c.getNomeCompleto());
				ps.setDate(3, dataNascimento);
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

	public Boolean alterar(Cliente c) {
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

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			con.fecharConexao();
		}
		return false;
	}

}
