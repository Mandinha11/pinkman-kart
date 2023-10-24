package modelo;

import java.util.ArrayList;

public interface IFornecedorDAO {
	
	public ArrayList<Fornecedor> Listar();
	
	public boolean inserir(Fornecedor f);
	
	public boolean alterar(Fornecedor f);
	
	public boolean Deletar(Fornecedor f);

}
