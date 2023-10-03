package controle;

import java.sql.Connection;
import java.sql.Date;
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
				Date dataentrada = rs.getDate("data_entrada");
				long preco = rs.getLong("preco");
				long CNPJ = rs.getLong("fornecedor_CNPJ");
				
				Karts k = new Karts();
				k.setId(idkarts);
				k.setCor(cor);
				k.setModelo(modelo);
				k.setMarca(marca);
				k.setAno(ano);
				k.setQuantidade(quantidade);
				k.setDataEntrada(dataentrada.toLocalDate());
				k.setPreco(preco);
				k.setCNPJ(CNPJ);
				
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
				
				
				ps.setLong(1, k.getId());
				ps.setString(2, k.getCor());
				ps.setString(3, k.getModelo());
				ps.setString(4, k.getMarca());
				ps.setLong(5, k.getAno());
				ps.setLong(6, k.getQuantidade());
				ps.setLong(8, k.getPreco());
				ps.setDate(7,Date.valueOf(k.getDataEntrada()));
				ps.setLong(9, k.getCNPJ());
				System.out.println(ps);
				System.out.println(ps.toString());
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

			ps.setString(1, k.getCor());

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
