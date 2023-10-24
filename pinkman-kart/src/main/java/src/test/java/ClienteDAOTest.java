package src.test.java;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.ClienteDAO;
import modelo.Cliente;

public class ClienteDAOTest {

	// annotation
	@Test
	public void testMetodoInserirCliente() {
		Cliente c = new Cliente();

		c.setNomeCompleto("Amanda");
		c.setCpf(24904602356l);
		c.setDataNac(LocalDate.of(2005, 11, 11));
		c.setTelefone(4698687793l);

		ClienteDAO dao = new ClienteDAO();
		
		assertEquals(true, dao.inserir(c));
		

	}
	//Arrumar esse
		public void testMetodoAlterarCliente() {
			
			Cliente c = new Cliente();
			
			c.setNomeCompleto("Ana");
			c.setDataNac(LocalDate.of(2008, 11, 11));
			c.setTelefone(7798687793l);
			
			ClienteDAO dao = new ClienteDAO();
			
			assertEquals(true, dao.alterar(c));

		}
		
		
	public void testMetodoDeletarCliente() {
		Cliente c = new Cliente();

		c.setNomeCompleto("Amanda");
		c.setCpf(23904602356l);
		c.setDataNac(LocalDate.of(2005, 11, 11));
		c.setTelefone(4698687793l);

		ClienteDAO dao = new ClienteDAO();
		
		assertEquals(true, dao.deletar(c));

	}
	
}
