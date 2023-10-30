package src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controle.Conexao;
import controle.LoginDao;

class LoginDaoTest {

    @Test
    public void testMetodoAutenticarLogin() throws SQLException {
        
        LoginDao dao = new LoginDao();

      
        String login = "Funcionario 1"; 
        Long senha = 12345678900L; 
       
        boolean autenticado = dao.autenticarLogin(login, senha);

      
        assertTrue(autenticado);
    }
}
