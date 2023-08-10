package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
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

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}
		return false;
	}

	public ArrayList<Fornecedor> Listar() {
		return listaFornecedores;
	}
}