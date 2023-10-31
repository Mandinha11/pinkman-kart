package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import controle.FornecedorDAO;
import modelo.Fornecedor;

public class FornecedorDAOTets {
	
	@Test
	public void testMetodoListarFornecedor() {
		FornecedorDAO f = new FornecedorDAO();
		ArrayList<Fornecedor> listarFornecedor = f.Listar();
		assertNotNull(listarFornecedor);
	}
	public void testMetodoInserirFornecedor() {
	Fornecedor f = new Fornecedor();
	
	f.setCep(891110446l);
	f.setCnpj(174564548789l);
	f.setNomeEmpresa("HenryJk");
	f.setTelefone(47965879963l);
	
	FornecedorDAO dao = new FornecedorDAO() ;
	assertEquals(true, dao.inserir(f));
	
	}
	
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
