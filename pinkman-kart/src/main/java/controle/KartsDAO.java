package controle;

import java.util.ArrayList;

import modelo.Karts;

public class KartsDAO {

	private static KartsDAO instancia;
	private static ArrayList<Karts> listaKarts;

	public static KartsDAO getinstancia() {

		if (instancia == null) {
			instancia = new KartsDAO();
			listaKarts = new ArrayList<>();
		}
		return instancia;
	}

	public Boolean Inserir(Karts k) {
		if (k != null) {
			listaKarts.add(k);
			return true;
		}
		return false;
	}

	public Boolean Alterar(Karts k) {
		return false;
	}

	public Boolean Deletar(Karts k) {
		return false;
	}

	public ArrayList<Karts> Listar() {
		return listaKarts;
	}
}
