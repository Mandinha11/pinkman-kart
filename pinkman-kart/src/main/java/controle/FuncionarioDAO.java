package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

			String query = "INSERT INTO clientes (id_cliente, nome_completo, data_nascimento, cpf, telefone) VALUES (??,??,??,??,??)";

			try {

				PreparedStatement ps = conn.prepareStatement(query);

				ps.setLong(4, f.getCpf());
				ps.setString(2, f.getNomeCompleto());
				ps.setLong(3, f.getDataNac());
				ps.setString(2, f.getCargo());
				

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

		return false;
	}

	public boolean deletar(Funcionario f) {

		return false;
	}


}


