package src.test.java;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import controle.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioDAOTest {

	@Test 
	public void testMedotoInserirFuncionario() {
		
		Funcionario f = new Funcionario();
		
		f.setCargo("Caixa");
		f.setCpf(2934546485l);
		f.setDataNac(LocalDate.of(2005, 11, 11));
		f.setNomeCompleto("Henry");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		boolean inseriuOk  = dao.inserir(f);
		assertEquals(true, inseriuOk);
		
	}
	
	
	
	
	
	
}
