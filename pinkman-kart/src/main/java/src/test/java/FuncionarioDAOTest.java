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
		
		f.setCargo("Funcionario");
		f.setCpf(2934546485l);
		f.setDataNac(LocalDate.of(2005, 11, 11));
		f.setNomeCompleto("Nala");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		assertEquals(false, dao.inserir(f));
		
	}

		public void testMedotoAlterarFuncionario() {
			
			Funcionario f = new Funcionario();
			
			f.setCargo("Caixa");
			f.setDataNac(LocalDate.of(2005, 11, 11));
			f.setNomeCompleto("Diega");
			
			FuncionarioDAO dao = new FuncionarioDAO();
			
			assertEquals(true, dao.alterar(f));
			
		}
		
	public void testMedotoDeltarFuncionario() {
			
			Funcionario f = new Funcionario();
			
			f.setCargo("Caixa");
			f.setCpf(2934546485l);
			f.setDataNac(LocalDate.of(2005, 11, 11));
			f.setNomeCompleto("Henry");
			
			FuncionarioDAO dao = new FuncionarioDAO();
			
			assertEquals(true, dao.deletar(f));
			
		}

	
	
	
	
}
