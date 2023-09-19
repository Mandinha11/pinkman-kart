package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Funcionario;

public class FuncionarioDAO {

	private static FuncionarioDAO instancia;

	public ArrayList<Funcionario> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM funcionarios";
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				
				Long cpf = rs.getLong("cpf");
				String nomeCompleto = rs.getString("nome_completo");
				String cargo = rs.getString("cargo");
				Date dataNac = rs.getDate("data_nascimento");
				
				LocalDate dataNascConvertida = dataNac.toLocalDate();
				
				Funcionario f = new Funcionario();
				
				f.setCpf(cpf);
				f.setNomeCompleto(nomeCompleto);
				f.setCargo(cargo);
				f.setDataNac(dataNascConvertida);

				funcionarios.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return funcionarios;

	}

	public static FuncionarioDAO getinstancia() {

		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;
	}

	public boolean inserir(Funcionario f) {

		Conexao con = Conexao.getInstancia();
		Connection conn = con.conectar();

		String query = "INSERT INTO funcionarios (cpf, nome_completo, data_nascimento, cargo) VALUES (?, ?, ?, ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, f.getCpf());
			ps.setString(2, f.getNomeCompleto());
			ps.setString(3, f.getCargo());
			ps.setDate(4, Date.valueOf(f.getDataNac()));
		
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;

	}

	public boolean alterar(Funcionario f) {

		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE funcionarios SET cargo = ?, cpf = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, f.getCargo());
			ps.setLong(2, f.getCpf());
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.fecharConexao();
		}

		return false;
	}

	public boolean deletar(Funcionario f) {

		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "DELETE FROM funcionarios WHERE cpf = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, f.getCpf());
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
