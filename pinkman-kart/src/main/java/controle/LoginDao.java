package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.ILoginDAO;

public class LoginDao implements ILoginDAO {
	// Método para autenticar o login
	public boolean autenticarLogin(String login, Long senha) {

		Conexao con = Conexao.getInstancia();

		try {
			Connection conn = con.conectar();
			PreparedStatement st = conn
					.prepareStatement("SELECT nome_completo, cpf FROM funcionarios WHERE nome_completo=? AND cpf=?");
			st.setString(1, login); // Defina o nome do funcionário
			st.setLong(2, senha); // Defina o CPF como senha
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				// Usuário autenticado
				return true;
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}
}
