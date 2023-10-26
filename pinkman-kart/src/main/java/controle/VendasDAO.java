package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import modelo.IVendasDAO;
import modelo.Karts;
import modelo.Vendas;



public class VendasDAO implements IVendasDAO{
	
	private static VendasDAO instancia;
	
	private static LocalDate fromDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public ArrayList <Vendas> listar (){
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		
		String query = "SELECT * FROM vendas";
		ArrayList<Vendas> vendas = new ArrayList();
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Vendas v = new Vendas();
			
			Integer idKart = rs.getInt("idKart");
			Float ValorDaVenda = rs.getFloat("preco");
			Date dataVendas = rs.getDate("data");
			long funcionarioCPF = rs.getLong("fornecedorCPF");
			
			
			v.setidKarts (idKart);
			v.setValorDaVenda (ValorDaVenda);
			v.setFuncionarioCPF(funcionarioCPF);
			
			LocalDate dataVendaConvertida = dataVendas.toLocalDate();
			v.setdataVendas(dataVendaConvertida);

			
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
	
	


	public static VendasDAO getinstancia() {

		if (instancia == null) {
			instancia = new VendasDAO();
			
		}
		return instancia;
	}

	public boolean inserir(Vendas v) {
		if(v!=null) {
			
			Conexao con = Conexao.getInstancia();

			Connection conn = con.conectar();

			String query = "NSERT INTO vendas (valor_total, data_venda, funcionarios_cpf, karts_id_kart) VALUES ( ? ,? ,? ,?)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				

				
				ps.setInt(1, v.getidkarts());
				ps.setDate(2,Date.valueOf(v.getdataVendas()));
				ps.setFloat(3, v.getValorDaVenda());
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

	public boolean alterar(Vendas v) {
		
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

			ps.setFloat(1, v.getValorDaVenda());
			

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



