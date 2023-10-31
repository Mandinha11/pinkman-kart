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
        panel.setLayout(null);

        JLabel label = new JLabel("Nome:");
        label.setBounds(0, 0, 200, 50);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);
        textFieldNome = new JTextField(cliente.getNomeCompleto());
        textFieldNome.setBackground(SystemColor.control);
        textFieldNome.setBounds(200, 11, 190, 39);
        panel.add(textFieldNome);

        JLabel label_1 = new JLabel("Telefone:");
        label_1.setBounds(0, 50, 200, 50);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label_1);
        textFieldTelefone = new JTextField(cliente.getTelefone().toString());
        textFieldTelefone.setBackground(SystemColor.control);
        textFieldTelefone.setBounds(200, 61, 190, 38);
        panel.add(textFieldTelefone);

        JLabel label_2 = new JLabel("Data de Nascimento:");
        label_2.setBounds(0, 100, 200, 50);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label_2);
        textFieldDataNascimento = new JTextField(
            cliente.getDataNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        textFieldDataNascimento.setBackground(SystemColor.control);
        textFieldDataNascimento.setBounds(200, 108, 190, 38);
        panel.add(textFieldDataNascimento);
        
        setLocationRelativeTo(null);
		setUndecorated(true);
		
        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.setForeground(Color.WHITE);
        buttonSalvar.setBackground(Color.BLACK);
        buttonSalvar.setBounds(10, 150, 190, 39);
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        panel.add(buttonSalvar);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(EditarClienteDialog.class.getResource("/imgs/alt.jpg")));
        lblNewLabel.setBounds(-89, -12, 489, 212);
        panel.add(lblNewLabel);
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

