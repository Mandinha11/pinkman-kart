package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controle.ClienteDAO;
import modelo.Cliente;

public class ClienteDAOTest {

	// annotation
	@Test
	public void testMetodoInserirCliente() {
		Cliente c = new Cliente();

		c.setNomeCompleto("Amanda");
		c.setCpf(null);
		c.setDataNac(null);
		c.setNomeEmpressa(null);
		c.setTelefone(null);

		ClienteDAO dao = new ClienteDAO();

		// Integer idClienteInserido = dao.inserir(c);
		boolean inseriuOk = dao.inserir(null);
		assertEquals(false, inseriuOk);

	}

}
