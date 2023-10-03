package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controle.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioDAOTest {

	@Test 
	public void testMedotoInserirFuncionario() {
		
		Funcionario f = new Funcionario();
		
		f.setCargo(null);
		f.setCpf(null);
		f.setDataNac(null);
		f.setNomeCompleto("Henry");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		Boolean inseriuOk  = dao.inserir(f);
		assertEquals(true, inseriuOk);
		
	}
	
	
	
	
	
	
}
