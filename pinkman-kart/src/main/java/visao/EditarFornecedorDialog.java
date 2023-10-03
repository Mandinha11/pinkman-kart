package visao;

import javax.swing.*;

import modelo.Cliente;
import modelo.Fornecedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarFornecedorDialog extends JDialog {
    private Fornecedor fornecedor;
    private boolean informacoesAlteradas = false;

    private JTextField textFieldNomeEmpresa;
    private JTextField textFieldCep;
    private JTextField textFieldTelefone;
   

    public EditarFornecedorDialog(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;

        setTitle("Editar Fornecedor");
        setSize(400, 200);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome empresa:"));
        textFieldNomeEmpresa = new JTextField(fornecedor.getNomeEmpresa());
        panel.add(textFieldNomeEmpresa);

        panel.add(new JLabel("Cep:"));
        textFieldCep = new JTextField(fornecedor.getCep().toString());
        panel.add(textFieldCep);
        
        
        panel.add(new JLabel("Telefone:"));
        textFieldTelefone = new JTextField(fornecedor.getTelefone().toString());
        panel.add(textFieldTelefone);
        
        
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

        add(panel);
    }

    private void salvarAlteracoes() {
        // Atualiza as informações do funcionário com os novos valores
        fornecedor.setNomeEmpresa(textFieldNomeEmpresa.getText());
        fornecedor.setTelefone(Long.valueOf(textFieldTelefone.getText()));
        fornecedor.setCep(Long.valueOf(textFieldCep.getText()));
 
        // Indica que as informações foram alteradas
        informacoesAlteradas = true;

        // Fecha a janela de diálogo
        dispose();
    }

    public boolean isInformacoesAlteradas() {
        return informacoesAlteradas;
    }

    public Fornecedor getFornecedorAtualizado() {
        return fornecedor;
    }
  

}

