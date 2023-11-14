package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import controle.VendasDAO;
import modelo.Vendas;

public class VendasDAOtest {

	@Test
	@Order(1)
	public void testMetodoListarCliente() {
		VendasDAO v =new VendasDAO();
		ArrayList<Vendas> ListarVen = v.listar();
		assertNotNull(ListarVen);
		
	}
	
	
	@Test
	@Order(2)
	public void testMetodoInserirVendas() {
		Vendas v = new Vendas();

		v.setDataVendas(LocalDate.of(2023, 9, 27));
		v.setFuncionarioCPF(12345678900l);
		v.setIdKarts(1);
		v.setValorDaVenda(5000f);

		VendasDAO dao = new VendasDAO();

		assertEquals(true, dao.inserir(v));
	}

	@Test
	@Order(3)
	public void testMedotoAlterarVendas() {

		Vendas v = new Vendas();

		v.setDataVendas(LocalDate.of(2023, 9, 27));

		VendasDAO dao = new VendasDAO();

		assertEquals(true, dao.alterar(v));

	}

	@Test
	@Order(4)
	public void testMedotoDeletarVendas() {

		Vendas v = new Vendas();
		v.setIdKarts(1);
		VendasDAO dao = new VendasDAO();

		assertEquals(true, dao.Deletar(v));

	}

}
