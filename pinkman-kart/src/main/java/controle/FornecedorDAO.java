package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Fornecedor;

public class FornecedorDAO {

	private static FornecedorDAO instancia;
	private static ArrayList<Fornecedor> listaFornecedores;

		public ArrayList<Fornecedor> listar() {

			Conexao c = Conexao.getInstancia();

			Connection con = c.conectar();

			ArrayList<Fornecedor> fornecedores = new ArrayList();

			String query = "SELECT * FROM fornecedor";

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
			}finally {
				c.fecharConexao();
			}


			return fornecedores;

		}
		
		public static FornecedorDAO getinstancia() {
		if (instancia == null) {
			instancia = new FornecedorDAO();
			listaFornecedores = new ArrayList<>();
		}
		return instancia;
	}

	public boolean inserir(Fornecedor f) {
		if(f!=null) {
			listaFornecedores.add(f);
			
			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO fornecedor (cnpj, nome_empresa, cep, telefone) VALUES (??, ??, ??, ??)";  
			
			try {

				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setLong(1, f.getCnpj());
				ps.setString(2, f.getNomeEmpresa());
				ps.setLong(3, f.getCep());
				ps.setLong(4, f.getTelefone());
				
				ps.executeUpdate();
				
				con.fecharConexao();
			
			return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			
		}
		return false;
	}

	public Boolean Alterar(Fornecedor f) {
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE fornecedor SET nome_empresa = ?, cnpj = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, f.getNomeEmpresa());
			ps.setLong(2, f.getTelefone());

			ps.executeUpdate();

			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}finally {
			con.fecharConexao();
		}
		
		
		return false;
		
	}

	public Boolean Deletar(Fornecedor f) {
Conexao con = Conexao.getInstancia();
		
		Connection conn = con.conectar();

		String query = "DELETE FROM cliente WHERE id_cliente = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, f.getCnpj());
			

			ps.executeUpdate();

			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}finally {
			con.fecharConexao();
		}
		return false;
	}


}