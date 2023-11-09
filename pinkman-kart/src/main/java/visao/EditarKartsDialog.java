package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Karts;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EditarKartsDialog extends JFrame {
	private Karts karts;
	private boolean informacoesAlteradas = false;
	private JPanel contentPane;
	private JTextField textFieldCor;
	private JTextField textFieldDataEntrada;
	private JTextField textFieldQuantidade;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldAno;
	private JTextField textFieldPreco;
	
	// public EditarKartsDialog(Karts karts) {
	        //this.karts = karts;
	 //}
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarKartsDialog frame = new EditarKartsDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
		});
	}
	 
	/**
	 * Create the frame.
	 */
	public EditarKartsDialog( ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCor.setBounds(10, 11, 200, 40);
		panel.add(lblCor);
		
		JLabel lblDataentrada = new JLabel("DataEntrada:");
		lblDataentrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataentrada.setBounds(10, 62, 200, 40);
		panel.add(lblDataentrada);
		
		JLabel lblquantidade = new JLabel("Quantidade:");
		lblquantidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblquantidade.setBounds(10, 113, 200, 40);
		panel.add(lblquantidade);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarca.setBounds(10, 164, 200, 40);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(10, 215, 200, 40);
		panel.add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAno.setBounds(10, 266, 200, 40);
		panel.add(lblAno);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreo.setBounds(10, 317, 200, 40);
		panel.add(lblPreo);
		
		textFieldCor = new JTextField((String) null);
		textFieldCor.setBackground(SystemColor.menu);
		textFieldCor.setBounds(220, 11, 190, 39);
		panel.add(textFieldCor);
		
		textFieldDataEntrada = new JTextField((String) null);
		textFieldDataEntrada.setBackground(SystemColor.menu);
		textFieldDataEntrada.setBounds(220, 62, 190, 39);
		panel.add(textFieldDataEntrada);
		
		textFieldQuantidade = new JTextField((String) null);
		textFieldQuantidade.setBackground(SystemColor.menu);
		textFieldQuantidade.setBounds(220, 113, 190, 39);
		panel.add(textFieldQuantidade);
		
		textFieldMarca = new JTextField((String) null);
		textFieldMarca.setBackground(SystemColor.menu);
		textFieldMarca.setBounds(220, 164, 190, 39);
		panel.add(textFieldMarca);
		
		textFieldModelo = new JTextField((String) null);
		textFieldModelo.setBackground(SystemColor.menu);
		textFieldModelo.setBounds(220, 215, 190, 39);
		panel.add(textFieldModelo);
		
		textFieldAno = new JTextField((String) null);
		textFieldAno.setBackground(SystemColor.menu);
		textFieldAno.setBounds(220, 266, 190, 39);
		panel.add(textFieldAno);
		
		textFieldPreco = new JTextField((String) null);
		textFieldPreco.setBackground(SystemColor.menu);
		textFieldPreco.setBounds(220, 317, 190, 39);
		panel.add(textFieldPreco);
	
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 salvarAlteracoes();
			}
		
		});
        
        
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setBackground(Color.BLACK);
		buttonSalvar.setBounds(116, 388, 190, 39);
		panel.add(buttonSalvar);
		getContentPane().add(panel);
	
	 
	}
	private void salvarAlteracoes() {
		
		 karts.setCor(textFieldCor.getText());
		
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	     LocalDate DataEntrada = LocalDate.parse(textFieldDataEntrada.getText(), formato);
	     karts.setDataEntrada(DataEntrada);
	     karts.setquantidade(Long.valueOf(textFieldQuantidade.getText()));
	     karts.setMarca(textFieldMarca.getText());
	     karts.setModelo(textFieldModelo.getText());
	     karts.setano(Long.valueOf(textFieldAno.getText()));
	     karts.setpreco(Long.valueOf(textFieldPreco.getText()));
	     
	     informacoesAlteradas = true;
	     
	     dispose();
	      
	}
	public boolean isInformacoesAlteradas() {
        return informacoesAlteradas;
    }
	public Karts getKartsAtualizado() {
        return karts;
    }
}
