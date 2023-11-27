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
	
	private JTextField textDataVenda;
	private JTextField textFieldCpf;
	private JTextField textFieldPreco;
	private JTextField textFieldIdKart;
	
    public EditarVendasDialog(Vendas vendas) {
        this.vendas = vendas;

        setTitle("Editar Venda");
        setSize(424, 506);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

		JLabel lblDataVenda = new JLabel("Data da venda:");
		lblDataVenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataVenda.setBounds(10, 133, 200, 40);
		panel.add(lblDataVenda);
		textDataVenda = new JTextField(vendas.getDataVendas().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		textDataVenda.setBackground(SystemColor.menu);
		textDataVenda.setBounds(208, 136, 190, 39);
		panel.add(textDataVenda);
			
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(10, 184, 200, 40);
		panel.add(lblCpf);
			textFieldCpf = new JTextField(vendas.getFuncionarioCPF().toString());
			textFieldCpf.setBackground(SystemColor.menu);
			textFieldCpf.setBounds(208, 187, 190, 39);
			panel.add(textFieldCpf);
		
		JLabel lblPreco = new JLabel("Valor total da venda:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreco.setBounds(10, 235, 200, 40);
		panel.add(lblPreco);
			textFieldPreco = new JTextField(vendas.getValorDaVenda().toString());
			textFieldPreco.setBackground(SystemColor.menu);
			textFieldPreco.setBounds(208, 238, 190, 39);
			panel.add(textFieldPreco);
		
		JLabel lblIdKart = new JLabel("Id Kart:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(10, 184, 200, 40);
		panel.add(lblCpf);
			textFieldIdKart = new JTextField(vendas.getIdKarts());
			textFieldIdKart.setBackground(SystemColor.menu);
			textFieldIdKart.setBounds(208, 187, 190, 39);
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
        buttonSalvar.setBounds(10, 393, 190, 39);
        panel.add(buttonSalvar);
        
        JButton bntSair = new JButton("Sair");
        bntSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	setVisible(false);
        		
        	}
        });
        bntSair.setForeground(Color.WHITE);
        bntSair.setBackground(Color.BLACK);
        bntSair.setBounds(224, 393, 190, 39);
        panel.add(bntSair);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(EditarVendasDialog.class.getResource("/imgs/fundoAzul.jpg")));
        lblNewLabel.setBounds(-329, 0, 753, 544);
        panel.add(lblNewLabel);
    }

    private void salvarAlteracoes() {
        
    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DataEntrada = LocalDate.parse(textDataVenda.getText(), formato);
        vendas.setDataVendas(DataEntrada);
    

        vendas.setFuncionarioCPF(Long.valueOf(textFieldCpf.getText()));
	    vendas.setValorDaVenda(Float.valueOf(textFieldPreco.getText()));
	    
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

