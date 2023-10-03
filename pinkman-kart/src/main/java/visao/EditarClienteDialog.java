package visao;

import javax.swing.*;

import modelo.Cliente;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarClienteDialog extends JDialog {
    private Cliente cliente;
    private boolean informacoesAlteradas = false;

    private JTextField textFieldNome;
    private JTextField textFieldTelefone;
    private JTextField textFieldDataNascimento;

    public EditarClienteDialog(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Editar Cliente");
        setSize(400, 200);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        panel.setLayout(new GridLayout(4, 2));

        JLabel label = new JLabel("Nome:");
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);
        textFieldNome = new JTextField(cliente.getNomeCompleto());
        panel.add(textFieldNome);

        JLabel label_1 = new JLabel("Telefone:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label_1);
        textFieldTelefone = new JTextField(cliente.getTelefone().toString());
        panel.add(textFieldTelefone);

        JLabel label_2 = new JLabel("Data de Nascimento:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label_2);
        textFieldDataNascimento = new JTextField(
            cliente.getDataNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        panel.add(textFieldDataNascimento);
        
        setLocationRelativeTo(null);
		setUndecorated(true);
		
        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        panel.add(buttonSalvar);

        getContentPane().add(panel);
    }

    private void salvarAlteracoes() {
        // Atualiza as informações do funcionário com os novos valores
        cliente.setNomeCompleto(textFieldNome.getText());
        cliente.setTelefone(Long.valueOf(textFieldTelefone.getText()));

        // Converte a data de nascimento para o formato correto
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(textFieldDataNascimento.getText(), formato);
        cliente.setDataNac(dataNascimento);

        // Indica que as informações foram alteradas
        informacoesAlteradas = true;

        // Fecha a janela de diálogo
        dispose();
    }

    public boolean isInformacoesAlteradas() {
        return informacoesAlteradas;
    }

    public Cliente getClienteAtualizado() {
        return cliente;
    }
  

}

