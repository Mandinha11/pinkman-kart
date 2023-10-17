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

import modelo.Karts;
import modelo.Vendas;



public class VendasDAO {
	
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
			
			long idKart = rs.getLong("idKart");
			long clienteCPF = rs.getLong("cliente");
			long ValorDaVenda = rs.getLong("preco");
			Date dataVendas = rs.getDate("data");
			
<<<<<<< HEAD
			Vendas v = new Vendas();
			v.setIdVendas (idVendas);
			v.setkarts (kart);
			v.setcliente (cliente);
			v.setpreco (preco);
			v.setdata(data);
			
=======
			
			
			
			v.setidKarts (idKart);
			v.setclienteCPF(clienteCPF);
			v.setValorDaVenda (ValorDaVenda);
			
			LocalDate dataVendaConvertida = dataVendas.toLocalDate();
			v.setdataVendas(dataVendaConvertida);
>>>>>>> TelaKarts-Vendas
			
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

<<<<<<< HEAD
			String query = "INSERT INTO vendas (id_vendas, data_venda, clientes_id_cliente, valor_total, quantidade, karts_id_kart) VALUES( ?, ?, ?, ?, ?, ?)";
=======
			String query = "INSERT INTO vendas (karts_id_kart,data_da_venda, valor_total, Cliente_CPF, FuncionarioCPF ) VALUES(?, ?, ?, ?, ?,)";
>>>>>>> TelaKarts-Vendas
			
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				
<<<<<<< HEAD
				ps.setString(1, v.getkarts());
				ps.setLong(2, v.getdata());
				ps.setLong(3, v.getpreco());
				ps.setString(5, v.getcliente());
=======
				
				ps.setLong(1, v.getidkarts());
				ps.setDate(2,Date.valueOf(v.getdataVendas()));
				ps.setLong(3, v.getValorDaVenda());
				ps.setLong(5, v.getclienteCPF());
				ps.setLong(4, v.getFuncionarioCPF());
>>>>>>> TelaKarts-Vendas
				
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



