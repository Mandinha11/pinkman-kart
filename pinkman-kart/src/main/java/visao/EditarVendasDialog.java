package visao;

import javax.swing.*;

import modelo.Funcionario;
import modelo.Vendas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EditarVendasDialog extends JDialog {
    private Vendas vendas;
    private boolean informacoesAlteradas = false;

    
    private JTextField textFieldValorVenda;
    private JTextField textFieldDataVenda;

    public EditarVendasDialog(Vendas vendas) {
        this.vendas = vendas;

        setTitle("Editar Vendas");
        setSize(400, 200);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Valor da Venda: :");
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(0, 0, 200, 50);
        panel.add(label);
        textFieldValorVenda = new JTextField(String.valueOf(vendas.getValorDaVenda()));
        textFieldValorVenda.setBackground(SystemColor.control);
        textFieldValorVenda.setBounds(200, 11, 190, 39);
        panel.add(textFieldValorVenda);

      
        JLabel label_2 = new JLabel("Data da Venda:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label_2.setBounds(0, 100, 200, 50);
        panel.add(label_2);
        textFieldDataVenda = new JTextField(
            vendas.getDataVendas().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        textFieldDataVenda.setBackground(SystemColor.control);
        textFieldDataVenda.setBounds(200, 111, 190, 39);
        panel.add(textFieldDataVenda);
        
        setLocationRelativeTo(null);
		setUndecorated(true);

        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.setBackground(SystemColor.desktop);
        buttonSalvar.setForeground(SystemColor.textHighlightText);
        buttonSalvar.setBounds(10, 150, 177, 39);
        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        panel.add(buttonSalvar);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(EditarVendasDialog.class.getResource("/imgs/alt.jpg")));
        lblNewLabel.setBounds(-52, 0, 452, 200);
        panel.add(lblNewLabel);
    }

    private void salvarAlteracoes() {
      
    	vendas.setValorDaVenda(Float.valueOf(textFieldValorVenda.getText()));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVendas = LocalDate.parse(textFieldDataVenda.getText(), formato);
        //vendas.setDataVendas(dataVendas);
        this.vendas.setDataVendas(dataVendas);
        informacoesAlteradas = true;


        dispose();
    }

    public boolean isInformacoesAlteradas() {
        return informacoesAlteradas;
    }

    public Vendas getVendasAtualizado() {
        return vendas;
    }
}
