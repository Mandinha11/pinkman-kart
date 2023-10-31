package src.test.java;
import static org.junit.Assert.assertEquals;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.FuncionarioDAO;
import controle.VendasDAO;
import modelo.Funcionario;
import modelo.Vendas;

public class VendasDAOtest {
	
	@Test
	
	public void testMetodoInserirVendas() {
		Vendas v = new Vendas();
		
		v.setdataVendas(LocalDate.of(2023,9,27));
		v.setFuncionarioCPF(12345678900l);
		v.setidKarts(1);
		v.setValorDaVenda(5000f);
	
		VendasDAO dao = new VendasDAO();
		
		assertEquals(true, dao.inserir(v));
	}
	
	public void testMedotoAlterarVendas() {
		
		Vendas v = new Vendas();
		
		v.setdataVendas(LocalDate.of(2023,9,27));
		
	
		VendasDAO dao = new VendasDAO();
		
		
		assertEquals(true, dao.alterar(v));
		
	}
	public void testMedotoDeletarVendas() {
		
		Vendas v = new Vendas();
		
		v.setdataVendas(LocalDate.of(2023,9,27));
		v.setFuncionarioCPF(12345678900l);
		v.setidKarts(1);
		v.setValorDaVenda(5000f);
	
		VendasDAO dao = new VendasDAO();
		
		assertEquals(true, dao.Deletar(v));
		
	}

}
