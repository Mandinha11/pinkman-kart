package modelo;

import java.util.ArrayList;

public interface IKartDAO {

	public ArrayList<Karts> listar();

	public boolean Inserir(Karts k);

	public boolean Alterar(Karts k);

	public boolean Deletar(Karts k);

}
