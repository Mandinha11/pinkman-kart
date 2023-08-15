package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Funcionario;

public class FuncionarioDAO {
	
	private static FuncionarioDAO instancia;
	
	public ArrayList<Funcionario> listar() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Funcionario> funcionarios = new ArrayList();

		String query = "SELECT * FROM funcionario";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				
				String cargo = rs.getString("cargo");
				long dataNac = rs.getLong("data_de_nascimento");
				long cpf = rs.getLong("cpf");
				String nomeCompleto = rs.getString("nome_completo");
				String matricula = rs.getString("matricula");

				Funcionario f = new Funcionario();
				
				
				f.setNomeCompleto(nomeCompleto);
				f.setCpf(cpf);
				f.setDataNac(dataNac);

				funcionarios.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();

		return funcionarios;

	}
	
	

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


