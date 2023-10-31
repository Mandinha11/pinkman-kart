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
        panel.setLayout(null);

        JLabel label = new JLabel("Nome:");
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(0, 0, 200, 50);
        panel.add(label);
        textFieldNome = new JTextField(funcionario.getNomeCompleto());
        textFieldNome.setBackground(SystemColor.control);
        textFieldNome.setBounds(200, 11, 190, 39);
        panel.add(textFieldNome);

        JLabel label_1 = new JLabel("Cargo:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label_1.setBounds(0, 50, 200, 50);
        panel.add(label_1);
        textFieldCargo = new JTextField(funcionario.getCargo());
        textFieldCargo.setBackground(SystemColor.control);
        textFieldCargo.setBounds(200, 61, 190, 39);
        panel.add(textFieldCargo);

        JLabel label_2 = new JLabel("Data de Nascimento:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label_2.setBounds(0, 100, 200, 50);
        panel.add(label_2);
        textFieldDataNascimento = new JTextField(
            funcionario.getDataNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        textFieldDataNascimento.setBackground(SystemColor.control);
        textFieldDataNascimento.setBounds(200, 111, 190, 39);
        panel.add(textFieldDataNascimento);
        
        setLocationRelativeTo(null);
		setUndecorated(true);

        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.setBackground(SystemColor.desktop);
        buttonSalvar.setForeground(SystemColor.textHighlightText);
        buttonSalvar.setBounds(10, 150, 177, 39);
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        panel.add(buttonSalvar);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(EditarFuncionarioDialog.class.getResource("/imgs/alt.jpg")));
        lblNewLabel.setBounds(-52, 0, 452, 200);
        panel.add(lblNewLabel);
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
