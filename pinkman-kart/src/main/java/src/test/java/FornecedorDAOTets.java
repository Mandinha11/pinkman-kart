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
	assertEquals(true, dao.inserir(f));
	
	}
	//Arrumar esse
	public void testMetodoAlterarFornecedor() {
		
		Fornecedor f = new Fornecedor();

		FornecedorDAO dao = new FornecedorDAO() ;
		
		assertEquals(true, dao.alterar(f));
		
		}
	
	public void testMetodoDeltarFornecedor() {
		Fornecedor f = new Fornecedor();
		
		f.setCep(891110446l);
		f.setCnpj(174564548789l);
		f.setNomeEmpresa("AmandaAL");
		f.setTelefone(47965879963l);
		
		FornecedorDAO dao = new FornecedorDAO() ;
		
		assertEquals(true, dao.Deletar(f));
		
		}

}
