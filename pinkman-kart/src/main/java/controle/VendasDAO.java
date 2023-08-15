package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			
		
			long idVendas = rs.getLong("idVendas");
			String kart = rs.getString("kart");
			String cliente = rs.getString("cliente");
			long preco = rs.getLong("preco");
			long data = rs.getLong("data");
			long matricula = rs.getLong("matricula");
			
			
			Vendas v = new Vendas();
			v.setIdVendas (idVendas);
			v.setkarts (kart);
			v.setcliente (cliente);
			v.setpreco (preco);
			v.setdata(data);
			v.setmatricula(matricula);
			
			vendas.add(v);
		 		}
			}
			
		catch (SQLException e) {
			e.printStackTrace();
			
		}
			c.fecharConexao();
			
			return vendas;
		
	}

	
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
		
		Conexao con = Conexao.getInstancia();

		Connection conn = con.conectar();

		String query = "UPDATE vendas SET data_vendas = ?, id_vendas = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, v.getdata());

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}

		
		return false;
	}

	public Boolean Deletar(Vendas v) {
		
Conexao con = Conexao.getInstancia();
		
		Connection conn = con.conectar();

		String query = "DELETE FROM vendas WHERE id_vendas = ?";
		
		try {

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, v.getIdVendas());
			

			ps.executeUpdate();

			con.fecharConexao();
			
			return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}
		
		return false;
	}

}



