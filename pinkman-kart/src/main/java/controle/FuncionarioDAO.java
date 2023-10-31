package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Funcionario;
import modelo.IFuncionarioDAO;

public class FuncionarioDAO implements IFuncionarioDAO {

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

		if(f != null) {
			
			Conexao con = Conexao.getInstancia();
			Connection conn = con.conectar();

			String query = "INSERT INTO funcionarios (cpf, nome_completo, data_nascimento, cargo) VALUES (?, ?, ?, ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, f.getCpf());
			ps.setString(2, f.getNomeCompleto());
			ps.setDate(3, Date.valueOf(f.getDataNac()));
			ps.setString(4, f.getCargo());
			
		
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
	
	public boolean alterar(Funcionario f) {
	    Conexao con = Conexao.getInstancia();
	    Connection conn = con.conectar();

	    String query = "UPDATE funcionarios SET nome_completo = ?, data_nascimento = ?, cargo = ? WHERE cpf = ?";

	    try {
	        PreparedStatement ps = conn.prepareStatement(query);

	        ps.setString(1, f.getNomeCompleto());
	        ps.setDate(2, Date.valueOf(f.getDataNac()));
	        ps.setString(3, f.getCargo());
	        ps.setLong(4, f.getCpf());

	        int rowsUpdated = ps.executeUpdate();

	        return rowsUpdated > 0;
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

	public ArrayList<Funcionario> consultarTodosFuncionario() {
		Conexao con = Conexao.getInstancia();
		Connection conn = con.conectar();
		
		int valida = 0;
		ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select funcionarios.* from funcionario \r\n");
					

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Funcionario f= new Funcionario();
				
				f.setCpf(rs.getLong("cpf"));
				f.setNomeCompleto(rs.getString("nome_completo"));
				f.setCargo(rs.getString("cargo"));
				f.setDataNac(rs.getDate("data_nascimento").toLocalDate());
				
				listaFuncionario.add(f);
			}
			return listaFuncionario;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;

	}
	public Funcionario consultaFuncionairoCPF(Long cpf) {
		Conexao con = Conexao.getInstancia();
		Connection conn = con.conectar();

		Funcionario funcionarioSelect = new Funcionario();
		int valida = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("select funcionario.* from funcionarios\r\n"
					+ "where cpf = ?; ");
			ps.setLong(1, cpf);
	

			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {

				funcionarioSelect.setCpf(rs.getLong("cpf"));
				funcionarioSelect.setNomeCompleto(rs.getString("nome_completo"));
				funcionarioSelect.setDataNac(rs.getDate("data_nascimento").toLocalDate());
				
				funcionarioSelect.setCargo(rs.getString("cargo"));

			}
			return funcionarioSelect;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return funcionarioSelect;

	}
}
