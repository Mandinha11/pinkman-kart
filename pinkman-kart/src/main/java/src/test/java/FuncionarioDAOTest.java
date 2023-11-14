package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import controle.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Order(1)
	public void testMetodoListarFuncionario() {
		FuncionarioDAO f =new FuncionarioDAO();
		ArrayList<Funcionario> ListarFunc = f.listar();
		assertNotNull(ListarFunc);
		
	}

	
	@Test 
	@Order(2)
	public void testMedotoInserirFuncionario() {
		
		Funcionario f = new Funcionario();
		
		f.setCargo("Funcionario");
		f.setCpf(2934546485l);
		f.setDataNac(LocalDate.of(2005, 11, 11));
		f.setNomeCompleto("Nala");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		assertEquals(true, dao.inserir(f));
		
	}
	@Test
	@Order(3)
		public void testMedotoAlterarFuncionario() {
			
			Funcionario f = new Funcionario();
			
			f.setCargo("Caixa");
			f.setDataNac(LocalDate.of(2005, 11, 11));
			f.setNomeCompleto("Diega");
			
			FuncionarioDAO dao = new FuncionarioDAO();
			
			assertEquals(true, dao.alterar(f));
			
		}
	@Test
	@Order(4)
		public void testMedotoDeltarFuncionario() {
			
			Funcionario f = new Funcionario();
			
			f.setCargo("Caixa");
			f.setCpf(2934546485l);
			f.setDataNac(LocalDate.of(2005, 11, 11));
			f.setNomeCompleto("Diega");
			
			FuncionarioDAO dao = new FuncionarioDAO();
			
			assertEquals(true, dao.deletar(f));
			
		}

	
	
	
	
}
