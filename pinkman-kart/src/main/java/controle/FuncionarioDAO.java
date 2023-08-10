package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Funcionario;

public class FuncionarioDAO {
	
	private static FuncionarioDAO instancia;

	public static FuncionarioDAO getinstancia() {

		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;
	}
	
	public boolean inserir(Funcionario f) {
		if (f != null) {

			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO funcionarios (matricula, cpf, nome_completo, data_nascimento, cargo, senha) VALUES (? ,?, ?, ?, ?, ?)";

			try {

				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, f.getMatricula());
				ps.setLong(2, f.getCpf());
				ps.setString(3, f.getNomeCompleto());
				ps.setLong(4, f.getDataNac());
				ps.setString(5, f.getCargo());
				

				ps.executeUpdate();

				con.fecharConexao();

				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;

	}

	public boolean alterar(Funcionario f) {
		
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE funcionarios SET cargo = ?, matricula = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, f.getCargo());

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}

		return false;
	}

	public boolean deletar(Funcionario f) {
		
		Conexao con = Conexao.getInstancia();
		
		Connection conn = con.conectar();

		String query = "DELETE FROM funcionarios WHERE matricula = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, f.getMatricula());
			

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}

		return false;
	}


}


