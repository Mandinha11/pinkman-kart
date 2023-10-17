package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.FornecedorDAO;
import modelo.Fornecedor;

public class FornecedorDAOTets {
	
	@Test
	
	public void testMetodoInserirFornecedor() {
	Fornecedor f = new Fornecedor();
	
	f.setCep(891110446l);
	f.setCnpj(174564548789l);
	f.setNomeEmpresa("AmandaAL");
	f.setTelefone(47965879963l);
	
	FornecedorDAO dao = new FornecedorDAO() ;
	boolean InseriuOk = dao.inserir(f);
	assertEquals(true, InseriuOk);
	
	}
	//Arrumar esse
	public void testMetodoAlterarFornecedor() {
		
		Fornecedor f = new Fornecedor();

		FornecedorDAO dao = new FornecedorDAO() ;
		boolean InseriuOk = dao.inserir(f);
		assertEquals(true, InseriuOk);
		
		}
	
	public void testMetodoDeltarFornecedor() {
		Fornecedor f = new Fornecedor();
		
		f.setCep(891110446l);
		f.setCnpj(174564548789l);
		f.setNomeEmpresa("AmandaAL");
		f.setTelefone(47965879963l);
		
		FornecedorDAO dao = new FornecedorDAO() ;
		boolean InseriuOk = dao.Deletar(f);
		assertEquals(true, InseriuOk);
		
		}

}
