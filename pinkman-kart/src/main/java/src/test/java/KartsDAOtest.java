package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

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

		k.setCNPJ(78901230004561l);

		k.setCNPJ(34567890001239l);

		k.setCor("preto");
		k.setDataEntrada(LocalDate.of(2000,12,22));
		k.setMarca("Marca H");
		k.setModelo("Modelo Y");
		k.setpreco(500000l);
		k.setquantidade(2l);
		k.setId(8);
		
		
		KartsDAO dao = new KartsDAO();
		boolean InserirOk = dao.Inserir(k);
		assertEquals(true, InserirOk);
	}
	
	@Test
	@Order(2)
	public void testMetodoDeletarKarts() {
		Karts k = new Karts();
		k.setId(8);
		
		KartsDAO dao = new KartsDAO();
		boolean DeletarOk = dao.Deletar(k);
		assertEquals(true, DeletarOk);
}
	
	@Test 
	@Order(3)
	
	public void testMetodoAlterarKarts() {
		Karts k = new Karts();
		
		k.setCor("Branco");
		k.setDataEntrada(LocalDate.of(2005, 11, 11));
		k.setquantidade(2l);
		k.setMarca("Marca Z");
		k.setModelo("Modelo A");
		k.setano(2000l);
		k.setpreco(20000000l);
		
		KartsDAO dao = new KartsDAO();
		boolean AlterarOK = dao.Alterar(k);
		assertEquals(true, AlterarOK);
		
	}
	@Test
	@Order(4)
	
	
	public void testMetodoListarKarts() {
		KartsDAO kr = new KartsDAO();
		ArrayList<Karts> ListarKart = kr.listar();
		assertNotNull(ListarKart);
		
	}
	
}
