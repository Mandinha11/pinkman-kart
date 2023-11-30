package visao;

import javax.swing.*;

import modelo.Cliente;
import modelo.Karts;
import modelo.MonetarioDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarKartsDialog extends JDialog {
	private Karts karts;
	private boolean informacoesAlteradas = false;
	
	private JTextField textFieldCor;
	private JTextField textFieldDataEntrada;
	private JTextField textFieldquantidade;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldAno;
	private JTextField textFieldPreco;
	
    public EditarKartsDialog(Karts karts) {
        this.karts = karts;

        setTitle("Editar Karts");
        setSize(424, 506);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCor.setBounds(10, 11, 200, 40);
		panel.add(lblCor);
			textFieldCor = new JTextField(karts.getCor());
			textFieldCor.setBackground(SystemColor.menu);
			textFieldCor.setBounds(208, 14, 190, 39);
			panel.add(textFieldCor);
			
		
		JLabel lblDataentrada = new JLabel("DataEntrada:");
		lblDataentrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataentrada.setBounds(10, 62, 200, 40);
		panel.add(lblDataentrada);
		textFieldDataEntrada = new JTextField(
					karts.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			        );
			textFieldDataEntrada.setBackground(SystemColor.menu);
			textFieldDataEntrada.setBounds(208, 65, 190, 39);
			panel.add(textFieldDataEntrada);
			
		
		JLabel lblquantidade = new JLabel("Quantidade:");
		lblquantidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblquantidade.setBounds(10, 113, 200, 40);
		panel.add(lblquantidade);
			textFieldquantidade = new JTextField(karts.getquantidade().toString());
			textFieldquantidade.setBackground(SystemColor.menu);
			textFieldquantidade.setBounds(208, 113, 190, 39);
			panel.add(textFieldquantidade);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarca.setBounds(10, 164, 200, 40);
		panel.add(lblMarca);
			textFieldMarca = new JTextField(karts.getMarca());
			textFieldMarca.setBackground(SystemColor.menu);
			textFieldMarca.setBounds(208, 167, 190, 39);
			panel.add(textFieldMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(10, 215, 200, 40);
		panel.add(lblModelo);
			textFieldModelo = new JTextField(karts.getModelo());
			textFieldModelo.setBackground(SystemColor.menu);
			textFieldModelo.setBounds(208, 218, 190, 39);
			panel.add(textFieldModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 266, 200, 40);
		panel.add(lblAno);
			textFieldAno = new JTextField(karts.getano().toString());
			textFieldAno.setBackground(SystemColor.menu);
			textFieldAno.setBounds(208, 269, 190, 39);
			panel.add(textFieldAno);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreco.setBounds(10, 317, 200, 40);
		panel.add(lblPreco);
		/*
		 textFieldPreco = new JTextField(8); 
		 JTextFieldDinheiro .setDocument(new MonetarioDocument());
		 */
		
		textFieldPreco = new JTextField(karts.getpreco().toString()); 
		//textFieldPreco.setDocument(new MonetarioDocument());
		textFieldPreco.setBackground(SystemColor.menu);
		textFieldPreco.setBounds(208, 317, 190, 39);
		panel.add(textFieldPreco);
		
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
        bntSair.setBounds(208, 393, 190, 39);
        panel.add(bntSair);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setIcon(new ImageIcon(EditarKartsDialog.class.getResource("/imgs/fundoAzul.jpg")));
        lblNewLabel.setBounds(-23, 0, 437, 506);
        panel.add(lblNewLabel);
    }

    private void salvarAlteracoes() {
        
        String preco = textFieldPreco.getText();
		preco = preco.replace(".", "");
				
		preco = preco.replace(",", "");
         
    
    	// Atualiza as informações do funcionário com os novos valores
        karts.setCor(textFieldCor.getText());
     // Converte a data de nascimento para o formato correto
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DataEntrada = LocalDate.parse(textFieldDataEntrada.getText(), formato);
        karts.setDataEntrada(DataEntrada);

        karts.setquantidade(Long.valueOf(textFieldquantidade.getText()));
	    karts.setMarca(textFieldMarca.getText());
	    karts.setModelo(textFieldModelo.getText());
	    karts.setano(Long.valueOf(textFieldAno.getText()));
	    karts.setpreco(Long.valueOf(preco));
	     
        
      

        // Indica que as informações foram alteradas
        informacoesAlteradas = true;

        // Fecha a janela de diálogo
        dispose();
    }

    public boolean isInformacoesAlteradas() {
        return informacoesAlteradas;
    }

    public Karts getkartsAtualizado() {
        return karts;
    }
}

