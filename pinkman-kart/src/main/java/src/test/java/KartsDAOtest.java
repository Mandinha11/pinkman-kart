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
		k.setAno(null);
		k.setCNPJ(null);
		k.setCor(null);
		k.setDataEntrada(null);
		k.setMarca(null);
		k.setModelo(null);
		k.setPreco(null);
		k.setQuantidade(null);
		k.setId(null);
		
		
		KartsDAO dao = new KartsDAO();
		Boolean inseriuOk = dao.Inserir(k);
		assertEquals(true, inseriuOk);
	}
	
	
}
