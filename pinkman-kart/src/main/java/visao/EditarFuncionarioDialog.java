package visao;

import javax.swing.*;

import modelo.Funcionario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarFuncionarioDialog extends JDialog {
    private Funcionario funcionario;
    private boolean informacoesAlteradas = false;

    private JTextField textFieldNome;
    private JTextField textFieldCargo;
    private JTextField textFieldDataNascimento;

    public EditarFuncionarioDialog(Funcionario funcionario) {
        this.funcionario = funcionario;

        setTitle("Editar Funcionário");
        setSize(400, 200);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:"));
        textFieldNome = new JTextField(funcionario.getNomeCompleto());
        panel.add(textFieldNome);

        panel.add(new JLabel("Cargo:"));
        textFieldCargo = new JTextField(funcionario.getCargo());
        panel.add(textFieldCargo);

        panel.add(new JLabel("Data de Nascimento:"));
        textFieldDataNascimento = new JTextField(
            funcionario.getDataNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        panel.add(textFieldDataNascimento);

        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        panel.add(buttonSalvar);

        add(panel);
    }

    private void salvarAlteracoes() {
        // Atualiza as informações do funcionário com os novos valores
        funcionario.setNomeCompleto(textFieldNome.getText());
        funcionario.setCargo(textFieldCargo.getText());

        // Converte a data de nascimento para o formato correto
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(textFieldDataNascimento.getText(), formato);
        funcionario.setDataNac(dataNascimento);

        // Indica que as informações foram alteradas
        informacoesAlteradas = true;

        // Fecha a janela de diálogo
        dispose();
    }

    public boolean isInformacoesAlteradas() {
        return informacoesAlteradas;
    }

    public Funcionario getFuncionarioAtualizado() {
        return funcionario;
    }
}
