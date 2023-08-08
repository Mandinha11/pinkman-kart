package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Vendas;



public class VendasDAO {

	
	private static VendasDAO instancia;
	

	public static VendasDAO getinstancia() {

		if (instancia == null) {
			instancia = new VendasDAO();
			
		}
		return instancia;
	}

	public Boolean Inserir(Vendas v) {
		if(v!=null) {
			
			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO vendas (id_vendas, data_venda, funcionarios_matricula, clientes_id_cliente, valor_total, quantidade, karts_id_kart) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, v.getkarts());
				ps.setLong(2, v.getdata());
				ps.setLong(3, v.getpreco());
				ps.setLong(4, v.getmatricula());
				ps.setString(5, v.getcliente());
				
				ps.executeUpdate();
				
				con.fecharConexao();
			
		
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		}
			return false;
			
	}

	public Boolean Alterar(Vendas v) {
		return false;
	}

	public Boolean Deletar(Vendas v) {
		return false;
	}

	public ArrayList<Vendas> Listar() {
		return null;
	}
}



