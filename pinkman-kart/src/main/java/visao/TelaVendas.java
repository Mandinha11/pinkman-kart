package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.ClienteDAO;
import controle.KartsDAO;
import controle.VendasDAO;
import modelo.Cliente;
import modelo.Karts;
import modelo.Vendas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTextField txtKart;
	private JTextField txtCliente;
	private JTextField txtPreco;
	private JTextField txtMatricula;
	private VendasDAO dao;
	private DefaultTableModel modelo;
	private JTextField txtData;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
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
	public TelaVendas() {
		setTitle("Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2015, 1092);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(281, 187, 1588, 807);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1587, 0, -1585, 807);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(1586, 0, -1579, 807);
		panel.add(table);
		
		JButton btnCadastra = new JButton("Cadastrar");
		btnCadastra.setForeground(new Color(255, 255, 255));
		btnCadastra.setBackground(new Color(0, 0, 0));
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vendas vendas = new Vendas();
				
				
				VendasDAO vendasDao = VendasDAO.getinstancia();
				
				
					String text = txtCliente.getText();
				 if (txtCliente.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "CNPJ do cliente não preenchido!!");
					 return;
			        }
				 else {
					 	text = text.replace(".","");
					 	text = text.replace(".","");
					 	text = text.replace("-","");
					 	text = text.trim();
					 	
					 vendas.setcliente(txtCliente.getText());
				 }
				
				
				 
				 
				 if (txtPreco.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Preço não preenchido!!");
					 return;
				 }
				 else {
				vendas.setpreco(Long.valueOf(txtPreco.getText()));
				 }
				
				
				 if (txtKart.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Kart não preenchido!!");
					 return;
			        }
				 else {
					 vendas.setkarts(txtKart.getText());
				 }
				 
				 if (txtMatricula.getText().trim().length() == 0) {
					 JOptionPane.showMessageDialog(null, "Matricula do Funcionario não preenchido!!");
					 return;
				 }
				 else {
				vendas.setmatricula(Long.valueOf(txtMatricula.getText()));
				 }
				VendasDAO VendasDao = VendasDAO.getinstancia();
				if(VendasDao.Inserir(vendas)== true) {
					JOptionPane.showMessageDialog(null,"Venda Cadastrada com sucesso");
					atualizarTabela();
				}else {
					JOptionPane.showMessageDialog(null,"Erro ao Cadastrar a venda");
				}
				 
			}

			
		});
		btnCadastra.setBounds(36, 187, 187, 49);
		contentPane.add(btnCadastra);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBackground(new Color(167, 10, 10));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TelaSelecao ts = new TelaSelecao();
				ts.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ts.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 11, 121, 28);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 85, 125));
		panel_1.setBounds(281, 31, 483, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setBounds(10, 16, 48, 24);
		panel_1.add(lblData);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(151, 16, 304, 28);
		panel_1.add(txtData);
		for(int i =1923; i<=2023; i++) {
		
		}
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 85, 125));
		panel_1_1.setBounds(281, 104, 483, 55);
		contentPane.add(panel_1_1);
		
		txtKart = new JTextField();
		txtKart.setColumns(10);
		txtKart.setBounds(153, 16, 304, 28);
		panel_1_1.add(txtKart);
		
		JLabel lblKartVendido = new JLabel("Id Kart:");
		lblKartVendido.setForeground(new Color(255, 255, 255));
		lblKartVendido.setBounds(10, 16, 102, 24);
		panel_1_1.add(lblKartVendido);
		lblKartVendido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(0, 85, 125));
		panel_1_2.setBounds(850, 31, 483, 55);
		contentPane.add(panel_1_2);
		
		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtCliente = new JFormattedTextField(mascaraCPF);
		
		
		txtCliente.setColumns(10);
		txtCliente.setBounds(153, 16, 304, 28);
		panel_1_2.add(txtCliente);
		
		JLabel lblComprador = new JLabel("Cliente CPF:");
		lblComprador.setForeground(new Color(255, 255, 255));
		lblComprador.setBounds(10, 18, 133, 20);
		panel_1_2.add(lblComprador);
		lblComprador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(0, 85, 125));
		panel_1_2_1.setBounds(850, 104, 483, 55);
		contentPane.add(panel_1_2_1);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(153, 16, 304, 28);
		panel_1_2_1.add(txtPreco);
		
		JLabel lblNewLabel = new JLabel("Valor Da Venda:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 16, 121, 24);
		panel_1_2_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBackground(new Color(0, 85, 125));
		panel_1_2_2.setBounds(1362, 31, 507, 55);
		contentPane.add(panel_1_2_2);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(193, 16, 304, 28);
		panel_1_2_2.add(txtMatricula);
		
		JLabel lblMatriculaFuncionario = new JLabel("Matricula Funcionario:");
		lblMatriculaFuncionario.setForeground(new Color(255, 255, 255));
		lblMatriculaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatriculaFuncionario.setBounds(10, 18, 156, 20);
		panel_1_2_2.add(lblMatriculaFuncionario);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(0, 0, 0));
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBounds(36, 274, 187, 49);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
				 
				 String kart = (String) table.getValueAt(selectedRow, 1);
				 
				 	VendasDAO dao = VendasDAO.getinstancia();
				 	
				 	Vendas v = new Vendas();
				 	v.setkarts(kart);
				 	boolean retorno = dao.Deletar(v);
				 
	                if (retorno == true) {
	                    // Remove a linha selecionada
	                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	                    tableModel.removeRow(selectedRow);
	                    JOptionPane.showMessageDialog(null, "Linha Excluída com Sucesso!");
	                }else {
	                	JOptionPane.showMessageDialog(null, "Erro na Exclução da Linha");
	                }
			}
		});
		btnExcluir.setBounds(36, 363, 187, 49);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/CarrinhoDeCompras.png")));
		lblNewLabel_1.setBounds(42, 814, 181, 180);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_5.setBounds(-13, 0, 1948, 1053);
		contentPane.add(lblNewLabel_5);

	}
	private void atualizarTabela() {
				// TODO Auto-generated method stub
				dao = VendasDAO.getinstancia();
				ArrayList <Vendas> Vendas = dao.listar();
				
				modelo = new DefaultTableModel(new Object[][] {},
					new String[] {"cliente", "preço","kart","matricula"});
				
				for(Vendas vendas : Vendas ) {
					Object[] linha = {vendas.getcliente(), vendas.getdata(), vendas.getkarts(), vendas.getmatricula()};
					modelo.addRow(linha);
				}
				table.setModel(modelo);
			}
}
