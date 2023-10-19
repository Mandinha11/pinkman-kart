package src.test.java;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.KartsDAO;
import modelo.Karts;

public class KartsDAOtest {
	
	// annotation
	@Test
	
	public void testMetodoInserirKarts() {
		Karts k = new Karts();
		//k.setano(2000l);
		//k.setCNPJ(12345678901234l);
		//k.setcor("preto");
		//k.setdataEntrada(LocalDate.of(2000,12,22));
		//k.setmarca("Ferrari");
		//k.setmodelo("modeloA");
		//k.setpreco(500000l);
		//k.setquantidade(2l);
		k.setId(7l);
		
		
		KartsDAO dao = new KartsDAO();
		boolean DeletarOk = dao.Deletar(k);
		assertEquals(true, DeletarOk);
	}
	
}
