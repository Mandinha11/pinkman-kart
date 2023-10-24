package modelo;

import java.util.ArrayList;

public interface IClienteDAO {
	
	public ArrayList<Cliente> listar();
	
	public boolean inserir(Cliente c);
	
	public boolean alterar(Cliente c);

	public boolean deletar(Cliente c);
}
