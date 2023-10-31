package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import controle.FornecedorDAO;
import modelo.Fornecedor;

public class FornecedorDAOTets {
	
	@Test
	@Order(1)
	public void testMetodoListarFornecedor() {
		FornecedorDAO f = new FornecedorDAO();
		ArrayList<Fornecedor> listarFornecedor = f.Listar();
		assertNotNull(listarFornecedor);
	}
	
	@Test
	@Order(2)
	public void testMetodoInserirFornecedor() {
	Fornecedor f = new Fornecedor();
	
	f.setCep(891110446l);
	f.setCnpj(174564548789l);
	f.setNomeEmpresa("HenryJk");
	f.setTelefone(47965879963l);
	
	FornecedorDAO dao = new FornecedorDAO() ;
	assertEquals(true, dao.inserir(f));
	
	}
	@Test
	@Order(3)
	public void testMetodoAlterarFornecedor() {
		
		Fornecedor f = new Fornecedor();
		
		f.setCep(891110446l);
		f.setTelefone(47965879963l);
		f.setNomeEmpresa("Amanda");
		
		FornecedorDAO dao = new FornecedorDAO();
		assertEquals(true, dao.alterar(f));
		
		}
	@Test
	@Order(4)
	public void testMetodoDeletarFornecedor() {
		Fornecedor f = new Fornecedor();
		f.setCep(891110446l);
		f.setCnpj(174564548789l);
		f.setTelefone(47965879963l);
		f.setNomeEmpresa("Amanda");
		
		FornecedorDAO dao = new FornecedorDAO() ;
		
		assertEquals(true, dao.Deletar(f));
		
		}

}
