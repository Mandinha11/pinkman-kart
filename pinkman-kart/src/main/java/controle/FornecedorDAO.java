package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Fornecedor;
import modelo.IFornecedorDAO;

public class FornecedorDAO implements IFornecedorDAO{

	private static FornecedorDAO instancia;

	public ArrayList<Fornecedor> Listar() {
		Conexao c = Conexao.getInstancia();
		

		Connection con = c.conectar();

		String query = "SELECT * FROM fornecedor";

		ArrayList<Fornecedor> fornecedores = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				long telefone = rs.getLong("telefone");
				long cep = rs.getLong("cep");
				long cnpj = rs.getLong("cnpj");
				String nomeEmpresa = rs.getString("nome_empresa");

				Fornecedor f = new Fornecedor();
				f.setCep(cep);
				f.setNomeEmpresa(nomeEmpresa);
				f.setTelefone(telefone);
				f.setCnpj(cnpj);
				fornecedores.add(f);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return fornecedores;

	}

	public static FornecedorDAO getinstancia() {
		if (instancia == null) {
			instancia = new FornecedorDAO();
		}
		return instancia;
	}

	public boolean inserir(Fornecedor f) {

		Conexao con = Conexao.getInstancia();
		Connection conn = con.conectar();

		String query = "INSERT INTO fornecedor (cnpj, nome_empresa, cep, telefone) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, f.getCnpj());
			ps.setString(2, f.getNomeEmpresa());
			ps.setLong(3, f.getCep());
			ps.setLong(4, f.getTelefone());
			
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

	public boolean alterar(Fornecedor f) {
		
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE fornecedor SET nome_empresa = ?, telefone = ?, cep = ? WHERE cnpj = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
				
			
			ps.setString(1, f.getNomeEmpresa());
		    ps.setLong(2, f.getTelefone());
			ps.setLong(3, f.getCep());
			ps.setLong(4, f.getCnpj());
			
			int rowsUpdated = ps.executeUpdate();
		      
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }

	    return false;
	}

	public boolean Deletar(Fornecedor f) {
		
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "DELETE FROM fornecedor WHERE cnpj = ?";

		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setLong(1, f.getCnpj());
			
			int rows = ps.executeUpdate();
			
			return rows==1;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.fecharConexao();
		}
		return false;
	}

}