package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Karts;

public class KartsDAO {
		

	public ArrayList <Karts> listar (){
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		
		ArrayList<Karts> Karts = new ArrayList<>();
		String query = "SELECT * FROM karts";
			try {
				PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				long idkarts = rs.getLong("id_kart");
				String cor = rs.getString("cor");
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				long ano = rs.getLong("ano");
				long quantidade = rs.getLong("quantidade");
				long dataentrada = rs.getLong("data_entrada");
				long preco = rs.getLong("preco");
				long fornecedorcnpj = rs.getInt("fornecedor_cnpj");
				
				Karts k = new Karts();
				k.setId(idkarts);
				k.setcor(cor);
				k.setmodelo(modelo);
				k.setmarca(marca);
				k.setano(ano);
				k.setquantidade(quantidade);
				k.setdataEntrada(dataentrada);
				k.setpreco(preco);
				k.setforneCNPJ(fornecedorcnpj);
				
				Karts.add(k);
				
					}
			
				}catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				c.fecharConexao();
			}
				
				return Karts;
	
		
	}
	
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
				
				ps.setLong(8, k.getId());
				ps.setString(6, k.getcor());
				ps.setString(1, k.getmodelo());
				ps.setString(2, k.getmarca());
				ps.setLong(4, k.getano());
				ps.setLong(5, k.getquantidade());
				ps.setLong(7, k.getdataEntrada());
				ps.setLong(3, k.getpreco());
				ps.setLong(10, k.getforneCNPJ());
				
				ps.executeUpdate();
				
			
			return true;
		}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
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

			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}finally {
			con.fecharConexao();
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

			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}finally {
			con.fecharConexao();
		}

		
		return false;
	}

	
	

	
}
