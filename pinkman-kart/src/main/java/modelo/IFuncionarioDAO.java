package modelo;

import java.util.ArrayList;

public interface IFuncionarioDAO {

	public ArrayList<Funcionario> listar();

	public boolean inserir(Funcionario f);

	public boolean alterar(Funcionario f);

	public boolean deletar(Funcionario f);

	public ArrayList<Funcionario> consultarTodosFuncionario();

	public Funcionario consultaFuncionairoCPF(Long cpf);

}
