package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import modelo.Karts;
import modelo.Vendas;



public class VendasDAO {
	
	public ArrayList <Vendas> listar (){
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		
		ArrayList<Vendas> vendas = new ArrayList();
		String query = "SELECT * FROM vendas";
		try {
			PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
		
			Long idKart = rs.getLong("idKart");
			Long clienteCPF = rs.getLong("cliente");
			long ValorDaVenda = rs.getLong("preco");
			Date dataVendas = rs.getDate("data");
			
			Vendas v = new Vendas();
			
			v.setidKarts (idKart);
			v.setclienteCPF(clienteCPF);
			v.setValorDaVenda (ValorDaVenda);
			v.setdataVendas(dataVendas.toLocalDate());
		
			
			vendas.add(v);
		 		}
			}
			
		catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			c.fecharConexao();
		}
			
			return vendas;
		
	}

	
	private static VendasDAO instancia;
	

	public static VendasDAO getinstancia() {

		if (instancia == null) {
			instancia = new VendasDAO();
			
		}
		return instancia;
	}

	public boolean Inserir(Vendas v) {
		if(v!=null) {
			
			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "INSERT INTO vendas (karts_id_kart,data_da_venda, valor_total, Cliente_CPF, FuncionarioCPF ) VALUES(?, ?, ?, ?, ?,)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setLong(1, v.getidkarts());
				ps.setDate(2,Date.valueOf(v.getdataVendas()));
				ps.setLong(3, v.getValorDaVenda());
				ps.setLong(5, v.getclienteCPF());
				ps.setLong(4, v.getFuncionarioCPF());
				
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

	public boolean Alterar(Vendas v) {
		
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE vendas SET data_vendas = ?,";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setDate(1,Date.valueOf(v.getdataVendas()));

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

	public boolean Deletar(Vendas v) {
		
Conexao con = Conexao.getInstancia();
		
		Connection conn = con.conectar();

		String query = "DELETE FROM vendas WHERE valor_total = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, v.getValorDaVenda());
			

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



