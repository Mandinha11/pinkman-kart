package src.test.java;
import static org.junit.Assert.assertEquals;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.VendasDAO;
import modelo.Vendas;

public class VendasDAOtest {
	
	@Test
	
	public void testMetodoInserirVendas() {
		Vendas v = new Vendas();
		
		v.setdataVendas (LocalDate.of(2000,12, 24));
		v.setValorDaVenda(4555555f);
		v.setFuncionarioCPF(12345678900l);
		v.setidKarts(6);
		
		VendasDAO dao = new VendasDAO(); 
		
		assertEquals(true, dao.inserir(v));
		
	}

}
