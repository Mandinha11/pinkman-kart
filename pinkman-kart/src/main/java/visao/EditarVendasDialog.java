package visao;

import javax.swing.*;

import modelo.Cliente;
import modelo.Karts;
import modelo.Vendas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarVendasDialog extends JDialog {
	private Vendas vendas;
	private boolean informacoesAlteradas = false;
	private JTextField textFieldCpf;
	private JTextField textFieldPreco;
	private JTextField textFieldIdKart;
	private JTextField textFieldIdVenda;
    public EditarVendasDialog(Vendas vendas) {
        this.vendas = vendas;

        setTitle("Editar Venda");
        setSize(424, 506);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
		
		
		JLabel lblIdKart = new JLabel("Id Kart:");
		lblIdKart.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdKart.setBounds(10, 130, 200, 40);
		panel.add(lblIdKart);
		lblIdKart.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdKart.setBounds(10, 112, 200, 40);
		
		
		JLabel lblPreco = new JLabel("Valor total da venda:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreco.setBounds(10, 181, 200, 40);
		panel.add(lblPreco);
			textFieldPreco = new JTextField(vendas.getValorDaVenda().toString());
			textFieldPreco.setBackground(SystemColor.menu);
			textFieldPreco.setBounds(208, 184, 190, 39);
			panel.add(textFieldPreco);
			
			textFieldIdKart = new JTextField(vendas.getIdKarts());
			textFieldIdKart.setBackground(SystemColor.menu);
			textFieldIdKart.setBounds(208, 115, 190, 39);
			panel.add(textFieldIdKart);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
        JButton buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				 salvarAlteracoes();
			}
		});
       panel.add(buttonSalvar);
       getContentPane().add(panel);
        buttonSalvar.setForeground(Color.WHITE);
        buttonSalvar.setBackground(Color.BLACK);
        buttonSalvar.setBounds(10, 456, 190, 39);
        panel.add(buttonSalvar);
        
        JButton bntSair = new JButton("Sair");
        bntSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	setVisible(false);
        		
        	}
        });
        bntSair.setForeground(Color.WHITE);
        bntSair.setBackground(Color.BLACK);
        bntSair.setBounds(224, 456, 190, 39);
        panel.add(bntSair);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(EditarVendasDialog.class.getResource("/imgs/fundoAzul.jpg")));
        lblNewLabel.setBounds(-329, 0, 784, 545);
        panel.add(lblNewLabel);
    }

    private void salvarAlteracoes() {
        
    
        vendas.setIdKarts(Integer.parseInt(textFieldIdKart.getText()));
	    vendas.setValorDaVenda(Float.parseFloat(textFieldPreco.getText()));
	    
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

