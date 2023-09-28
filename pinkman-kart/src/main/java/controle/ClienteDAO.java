package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Funcionario;

public class ClienteDAO {

	private static ClienteDAO instancia;

	private static LocalDate fromDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public ArrayList<Cliente> listar() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "SELECT * FROM clientes";
		ArrayList<Cliente> clientes = new ArrayList();

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Cliente cl = new Cliente();
				
				int id_cliente = rs.getInt("id_cliente");
				long telefone = rs.getLong("Telefone");
				Date dataNac = rs.getDate("data_nascimento");
				long cpf = rs.getLong("cpf");
				String nomeCompleto = rs.getString("nome_completo");

				
				
			//	cl.setId_cliente(id_cliente);
				cl.setTelefone(telefone);
				cl.setNomeCompleto(nomeCompleto);
				cl.setCpf(cpf);

				LocalDate dataNascConvertida = dataNac.toLocalDate();
				cl.setDataNac(dataNascConvertida);

				clientes.add(cl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			String query = "INSERT INTO clientes (nome_completo, data_nascimento, cpf, telefone) VALUES ( ?, ?, ?, ?)";

			try {

				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, c.getNomeCompleto());
				ps.setDate(2, Date.valueOf(c.getDataNac()));
				ps.setLong(3, c.getCpf());
				ps.setLong(4, c.getTelefone());

				ps.executeUpdate();

				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}

		}

		return false;

	}

	public Boolean Alterar(Cliente c) {
		
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE clientes SET cpf = ?, nome_completo = ?, telefone = ?, data_nascimento = ? WHERE id_cliente = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
				
			ps.setLong(4, c.getCpf());
			ps.setString(1, c.getNomeCompleto());
		    ps.setLong(2, c.getTelefone());
			ps.setDate(3, Date.valueOf(c.getDataNac()));
			
			int rowsUpdated = ps.executeUpdate();
		      
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }

	    return false;
	}

	public Boolean Deletar(Cliente c) {

		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "DELETE FROM clientes WHERE cpf = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, c.getCpf());
			ps.executeUpdate();
			
			return true;
			

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.fecharConexao();
		}
		return false;
	}

}
