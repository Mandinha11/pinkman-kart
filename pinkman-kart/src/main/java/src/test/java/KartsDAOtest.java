package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controle.KartsDAO;
import modelo.Karts;

public class KartsDAOtest {
	
	// annotation
	@Test
	
	public void testMetodoInserirKarts() {
		Karts k = new Karts();
		k.setano(null);
		k.setCNPJ(null);
		k.setcor(null);
		k.setdataEntrada(null);
		k.setmarca(null);
		k.setmodelo(null);
		k.setpreco(null);
		k.setquantidade(null);
		k.setId(null);
		
		
		KartsDAO dao = new KartsDAO();
		Boolean inseriuOk = dao.Inserir(k);
		assertEquals(true, inseriuOk);
	}
	
}
