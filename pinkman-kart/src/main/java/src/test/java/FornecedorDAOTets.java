package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.FornecedorDAO;
import modelo.Fornecedor;

public class FornecedorDAOTets {
	
	@Test
	
	public void testMetodoInserir() {
	Fornecedor f = new Fornecedor();
	
	f.setCep(null);
	f.setCnpj(null);
	f.setNomeEmpresa(null);
	f.setTelefone(null);
	
	FornecedorDAO dao = new FornecedorDAO() ;
	Boolean InseriuOk = dao.inserir(f);
	assertEquals(true, InseriuOk);
	
	}

}
