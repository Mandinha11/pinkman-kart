package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
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

				Funcionario f = new Funcionario();
				String cargo = rs.getString("cargo");
				Date dataNac = rs.getDate("data_nascimento");
				long cpf = rs.getLong("cpf");
				String nomeCompleto = rs.getString("nome_completo");
				Long matricula = rs.getLong("matricula");

				f.setMatricula(matricula);
				f.setCargo(cargo);
				f.setNomeCompleto(nomeCompleto);
				f.setCpf(cpf);

				LocalDate dataNascConvertida = dataNac.toLocalDate();
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

		String query = "INSERT INTO funcionarios (matricula, cpf, nome_completo, data_nascimento, cargo, senha) VALUES (? ,?, ?, ?, ?, ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, f.getMatricula());
			ps.setLong(2, f.getCpf());
			ps.setString(3, f.getNomeCompleto());
			ps.setDate(4, Date.valueOf(f.getDataNac()));
			ps.setString(5, f.getCargo());
			ps.setString(6, f.getSenha());
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

		String query = "UPDATE funcionarios SET cargo = ?, matricula = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, f.getCargo());
			ps.setLong(2, f.getMatricula());
			ps.executeUpdate();

			;

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

		String query = "DELETE FROM funcionarios WHERE matricula = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, f.getMatricula());

			ps.executeUpdate();

			con.fecharConexao();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.fecharConexao();
		}

		return false;
	}

}
