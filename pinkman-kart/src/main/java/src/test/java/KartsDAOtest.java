package src.test.java;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import controle.KartsDAO;
import modelo.Karts;
@TestMethodOrder(OrderAnnotation.class)
public class KartsDAOtest {
	
	// annotation
	@Test
	@Order(1)
	
	public void testMetodoInserirKarts() {
		Karts k = new Karts();
		k.setano(2000l);
		k.setCNPJ(89012340000567l);
		k.setCor("preto");
		k.setDataEntrada(LocalDate.of(2000,12,22));
		k.setMarca("Marca H");
		k.setModelo("Modelo Y");
		k.setpreco(500000l);
		k.setquantidade(2l);
		k.setId(8l);
		
		
		KartsDAO dao = new KartsDAO();
		boolean InserirOk = dao.Inserir(k);
		assertEquals(true, InserirOk);
	}
	
	@Test
	@Order(2)
	public void testMetodoDeletarKarts() {
		Karts k = new Karts();
		k.setId(8l);
		
		KartsDAO dao = new KartsDAO();
		boolean DeletarOk = dao.Deletar(k);
		assertEquals(true, DeletarOk);
}
	
}
