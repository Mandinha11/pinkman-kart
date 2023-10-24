package modelo;

import java.util.ArrayList;

public interface IVendasDAO {
	
	public ArrayList <Vendas> listar ();
	
	public boolean inserir(Vendas v);
	
	public boolean alterar(Vendas v);
	
	public boolean Deletar(Vendas v);
	
	

}
