package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import controle.ClienteDAO;
import modelo.Cliente;
@TestMethodOrder(OrderAnnotation.class)

public class ClienteDAOTest {

	// annotation
	@Test
	@Order(1)
	public void testMetodoListarCliente() {
		ClienteDAO cl =new ClienteDAO();
		ArrayList<Cliente> ListarClin = cl.listar();
		assertNotNull(ListarClin);
		
	}
	
	
	@Test
	@Order(2)
	public void testMetodoInserirCliente() {
		Cliente c = new Cliente();

		c.setNomeCompleto("Amanda");
		c.setCpf(24204602356l);
		c.setDataNac(LocalDate.of(2005, 11, 11));
		c.setTelefone(4698687793l);

		ClienteDAO dao = new ClienteDAO();
		
		assertEquals(true, dao.inserir(c));
		
	
	}
	@Test
	@Order(3)
	
		public void testMetodoAlterarCliente() {
			
			Cliente c = new Cliente();
			
			c.setNomeCompleto("Ana");
			c.setCpf(24204602356l);
			c.setDataNac(LocalDate.of(2008, 11, 11));
			c.setTelefone(7798687793l);
			
			ClienteDAO dao = new ClienteDAO();
			
			assertEquals(true, dao.alterar(c));

		}
		
	@Test
	@Order(4)
	public void testMetodoDeletarCliente() {
		Cliente c = new Cliente();

		c.setNomeCompleto("Amanda");
		c.setCpf(24204602356l);
		c.setDataNac(LocalDate.of(2005, 11, 11));
		c.setTelefone(4698687793l);

		ClienteDAO dao = new ClienteDAO();
		
		assertEquals(true, dao.deletar(c));

	}
	
}
