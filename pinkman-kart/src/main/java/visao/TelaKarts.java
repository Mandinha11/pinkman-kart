package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;


import controle.KartsDAO;

import modelo.Karts;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.UIManager;
//=======
import javax.swing.JFormattedTextField;
//>>>>>>> Stashed changes;

public class TelaKarts extends JFrame {

	private JPanel contentPane;
	private JTextField txtPreco;
	private JTextField txtPreco_1;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTable table;
	private JTextField txtId;
	private JTextField txtFornecedor;
	private JTextField txtCNPJ;
	private JTable tabelaKarts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaKarts frame = new TelaKarts();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaKarts() {
		setTitle("Karts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2218, 1126);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 11, 126, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaSelecao ts = new TelaSelecao();
				ts.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ts.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);
		
	
		    
		

		JScrollPane scrollPane = new JScrollPane(tabelaKarts);
		scrollPane.setViewportView(tabelaKarts);
		scrollPane.setBounds(996, 54, 857, 939);
		contentPane.add(scrollPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(54, 612, 390, 41);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Karts karts = new Karts();
				
				
				KartsDAO kartsdao = KartsDAO.getinstancia();
				
				
			
				
				 if (txtPreco.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Preço não preenchido!!");
					 return;
				 }
				 else {
				karts.setpreco(Long.valueOf(txtPreco.getText()));
				 }
			
				 if (txtMarca.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Marca não preenchido!!");
					 return;
				 }
				 else {
				karts.setmarca(String.valueOf(txtMarca.getText()));
				 }
				 
				 if (txtModelo.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Modelo não preenchido!!");
					 return;
				 }
				 else {
				karts.setmodelo(String.valueOf(txtModelo.getText()));
				 }
				
				 
				 if (txtId.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Id Kart não preenchido!!");
					 return;
				 }
				 else {
				karts.setId(Long.valueOf(txtId.getText()));
				 }
				 
				 if (txtFornecedor.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "CNPJ do Fornecedor não preenchido!!");
					 return;
				 }
				 else {
				karts.setforneCNPJ(Long.valueOf(txtFornecedor.getText()));
				 }
				 
				 
				 
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnCadastrar);
		
		MaskFormatter mascaraCNPJ = null;
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/000#-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtFornecedor = new JFormattedTextField(mascaraCNPJ);
		
		txtPreco = new JTextField();
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("R$ #.###.###,##");
		}catch(ParseException e2) {
			e2.printStackTrace();
		}
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
	                if (selectedRow != -1) {
	                    // Remove a linha selecionada
	                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	                    tableModel.removeRow(selectedRow);
	                    JOptionPane.showMessageDialog(null, "Linha excluída com sucesso!");
	                }
			}
		});
		btnExcluir.setBounds(524, 612, 386, 41);
		btnExcluir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnExcluir);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(211, 211, 211));
		panel_4.setBounds(996, 54, 857, 939);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 10, 837, 919);
		panel_4.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(368, 161, 1, 1);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(98, 113, 423, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(153, 20, 260, 30);
		panel_1.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblIdKart = new JLabel("ID Kart:");
		lblIdKart.setBounds(10, 17, 104, 30);
		panel_1.add(lblIdKart);
		lblIdKart.setForeground(Color.BLACK);
		lblIdKart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(98, 195, 423, 61);
		contentPane.add(panel_1_1);
		
		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		lblDataEntrada.setBounds(10, 20, 104, 30);
		panel_1_1.add(lblDataEntrada);
		lblDataEntrada.setForeground(Color.BLACK);
		lblDataEntrada.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JComboBox<String> boxDia = new JComboBox<>();
		boxDia.setBounds(111, 27, 80, 22);
		panel_1_1.add(boxDia);
		boxDia.addItem("01");
		boxDia.addItem("02");
		boxDia.addItem("03");
		boxDia.addItem("04");
		boxDia.addItem("05");
		boxDia.addItem("06");
		boxDia.addItem("07");
		boxDia.addItem("08");
		boxDia.addItem("09");
		boxDia.addItem("10");
		boxDia.addItem("11");
		boxDia.addItem("12");
		boxDia.addItem("13");
		boxDia.addItem("14");
		boxDia.addItem("15");
		boxDia.addItem("16");
		boxDia.addItem("17");
		boxDia.addItem("18");
		boxDia.addItem("19");
		boxDia.addItem("20");
		boxDia.addItem("21");
		boxDia.addItem("22");
		boxDia.addItem("23");
		boxDia.addItem("24");
		boxDia.addItem("25");
		boxDia.addItem("26");
		boxDia.addItem("27");
		boxDia.addItem("28");
		boxDia.addItem("29");
		boxDia.addItem("30");
		boxDia.addItem("31");
		
		JComboBox<String> boxMes = new JComboBox<>();
		boxMes.setBounds(201, 27, 82, 22);
		panel_1_1.add(boxMes);
		boxMes.addItem("01");
		boxMes.addItem("02");
		boxMes.addItem("03");
		boxMes.addItem("04");
		boxMes.addItem("05");
		boxMes.addItem("06");
		boxMes.addItem("07");
		boxMes.addItem("08");
		boxMes.addItem("09");
		boxMes.addItem("10");
		boxMes.addItem("11");
		boxMes.addItem("12");
		
		JComboBox<Integer> boxANO = new JComboBox<>();
		boxANO.setBounds(293, 27, 82, 22);
		panel_1_1.add(boxANO);
		
		for(int i =1923; i<=2023; i++) {
			boxANO.addItem(i);
			}
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(98, 279, 423, 61);
		contentPane.add(panel_1_1_1);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(154, 20, 259, 30);
		panel_1_1_1.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblMarcaKarts = new JLabel("Marca:");
		lblMarcaKarts.setBounds(10, 17, 67, 30);
		panel_1_1_1.add(lblMarcaKarts);
		lblMarcaKarts.setForeground(new Color(0, 0, 0));
		lblMarcaKarts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(new Color(211, 211, 211));
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(98, 367, 423, 61);
		contentPane.add(panel_1_1_2);
		
		MaskFormatter mascaraCNPJ1 = null;
		try {
			mascaraCNPJ1 = new MaskFormatter("##.###.###/000#-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCNPJ = new JFormattedTextField(mascaraCNPJ1);
		
		txtCNPJ.setBounds(142, 20, 260, 30);
		panel_1_1_2.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Fornecedor CNPJ:");
		lblNewLabel.setBounds(10, 21, 137, 22);
		panel_1_1_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(211, 211, 211));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(553, 113, 423, 61);
		contentPane.add(panel_1_2);
		
		JLabel lblBuscarKarts = new JLabel("Cor:");
		lblBuscarKarts.setBounds(10, 11, 67, 30);
		panel_1_2.add(lblBuscarKarts);
		lblBuscarKarts.setForeground(new Color(0, 0, 0));
		lblBuscarKarts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JComboBox<String> boxCor = new JComboBox<>();
		boxCor.setBounds(151, 16, 262, 26);
		panel_1_2.add(boxCor);
		boxCor.addItem("Selecionar Cor");
		boxCor.addItem("Amarelo");
		boxCor.addItem("Vermelho");
		boxCor.addItem("Azul");
		boxCor.addItem("Verde");
		boxCor.addItem("Rosa");
		boxCor.addItem("Roxo");
		boxCor.addItem("Preto");
		boxCor.addItem("Branco");
		boxCor.addItem("Cinza");
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(211, 211, 211));
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(553, 195, 423, 61);
		contentPane.add(panel_1_3);
		
		
		JComboBox<String> boxQuantidade = new JComboBox<>();
		boxQuantidade.setBounds(151, 21, 262, 29);
		panel_1_3.add(boxQuantidade);
		boxQuantidade.addItem("Selecinar Quantidade");
		boxQuantidade.addItem("1");
		boxQuantidade.addItem("2");
		boxQuantidade.addItem("3");
		boxQuantidade.addItem("4");
		boxQuantidade.addItem("5");
		boxQuantidade.addItem("6");
		boxQuantidade.addItem("7");
		boxQuantidade.addItem("8");
		boxQuantidade.addItem("9");
		boxQuantidade.addItem("10");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 17, 104, 30);
		panel_1_3.add(lblQuantidade);
		lblQuantidade.setForeground(new Color(0, 0, 0));
		lblQuantidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 550, 903, 131);
		panel_3.setBackground(new Color(0, 128, 128));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		//JPanel panel_4 = new JPanel();
		panel_4.setBounds(996, 54, 857, 939);
		panel_4.setBackground(new Color(211, 211, 211));
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(new Color(211, 211, 211));
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(553, 279, 423, 61);
		contentPane.add(panel_1_4);

		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 20, 67, 30);
		panel_1_4.add(lblModelo);
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		txtModelo = new JTextField();
		txtModelo.setBounds(153, 23, 260, 30);
		panel_1_4.add(txtModelo);
		txtModelo.setColumns(10);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(new Color(211, 211, 211));
		panel_1_5.setLayout(null);
		panel_1_5.setBounds(553, 367, 423, 61);
		contentPane.add(panel_1_5);
		
		JComboBox<Integer> boxAno = new JComboBox<>();
		boxAno.setBounds(153, 20, 260, 30);
		panel_1_5.add(boxAno);
		for(int i =1923; i<=2023; i++) {
			boxAno.addItem(i);
			}
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 17, 59, 30);
		panel_1_5.add(lblAno);
		lblAno.setForeground(new Color(0, 0, 0));
		lblAno.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBackground(new Color(211, 211, 211));
		panel_1_6.setLayout(null);
		panel_1_6.setBounds(307, 473, 423, 61);
		contentPane.add(panel_1_6);
		txtPreco_1 = new JFormattedTextField(formatter);
		txtPreco_1.setBounds(152, 20, 261, 30);
		panel_1_6.add(txtPreco_1);
		txtPreco_1.setColumns(10);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setBounds(10, 17, 67, 30);
		panel_1_6.add(lblPreo);
		lblPreo.setForeground(new Color(0, 0, 0));
		lblPreo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");

		lblNewLabel_2.setBounds(343, 733, 301, 217);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1924, 1061);
		contentPane.add(lblNewLabel_1);
	}
}
