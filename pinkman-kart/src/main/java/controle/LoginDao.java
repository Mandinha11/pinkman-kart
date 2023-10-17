package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Funcionario;

public class LoginDao implements InterfaceLogin{

	private Conexao con;

	@Override
	public Funcionario consultarLogin(Funcionario usuario) {

		try {

			con = Conexao.getInstancia();
			Connection c = con.conectar();
			PreparedStatement ps = c.prepareStatement("select * from funcionarios where nome_completo = ? and cpf = ?");
			ps.setString(1, usuario.getNomeCompleto());
			ps.setLong(2, usuario.getCpf());

			ResultSet rs = ps.executeQuery();
			Funcionario usuarioConectado = new Funcionario();
			while (rs.next()) {
				
				String login = rs.getString("nome_completo");
				Long senha = rs.getLong("cpf");
				
				usuarioConectado.setNomeCompleto(login);
				usuarioConectado.setCpf(senha);
				

				return usuarioConectado;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return null;
	}

	@Override
	public Funcionario consultaFuncionario(Funcionario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
