package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Karts;

public class KartsDAO {

	private static KartsDAO instancia;
	

	public static KartsDAO getinstancia() {

		if (instancia == null) {
			instancia = new KartsDAO();
			
		}
		return instancia;
	}

	public Boolean Inserir(Karts k) {
		if (k != null) {
			
			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO karts (id_kart, cor, modelo, marca, ano, quantidade, data_entrada, preco, fornecedor_cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, k.getmodelo());
				ps.setString(2, k.getmarca());
				ps.setLong(3, k.getpreco());
				ps.setLong(4, k.getano());
				ps.setLong(5, k.getquantidade());
				ps.setString(6, k.getcor());
				ps.setLong(7, k.getdataEntrada());
				ps.setLong(8, k.getId());
				ps.setString(9, k.getmotor());
				ps.setLong(10, k.getforneCNPJ());
				
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

	public Boolean Alterar(Karts k) {
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE karts SET cor = ?, id_kart In (?)";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, k.getcor());

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}
		
		return false;
	}

	public Boolean Deletar(Karts k) {
		
		Conexao con = Conexao.getInstancia();
		
		Connection conn = con.conectar();

		String query = "DELETE FROM kart WHERE id_kart = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, k.getId());
			

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}

		
		return false;
	}

	public ArrayList<Karts> Listar() {
		return null;
	}
}
