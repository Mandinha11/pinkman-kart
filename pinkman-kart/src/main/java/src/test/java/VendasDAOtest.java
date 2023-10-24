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
		
		v.setidKarts(1l);
		v.setdataVendas (LocalDate.of(2000,12, 24));
		v.setValorDaVenda(4555555l);
		v.setFuncionarioCPF(12345678900l);
		
		VendasDAO dao = new VendasDAO(); 
		boolean inseriuOK = dao.inserir(v);
		assertEquals(true, inseriuOK);
		
	}

}
