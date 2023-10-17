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
		c.setCpf(16904602356l);
		c.setDataNac(LocalDate.of(2005, 11, 11));
		c.setNomeEmpressa("Julia");
		c.setTelefone(4798687793l);

		ClienteDAO dao = new ClienteDAO();
		
		assertEquals(true, dao.inserir(c));

	}

}
