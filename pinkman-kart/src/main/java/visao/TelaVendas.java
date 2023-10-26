package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.VendasDAO;
import modelo.Vendas;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTextField txtidKart;
	private JTextField txtValorDaVenda;
	private JTextField txtFuncionarioCPF;
	private VendasDAO dao;
	private DefaultTableModel modelo;
	private JTextField txtDataDaVenda;
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
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Valor_total", "Data_da_Venda", "Funcionario_CPF", "ID_kart" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(table);

		JButton btnCadastra = new JButton("Cadastrar");
		btnCadastra.setForeground(new Color(255, 255, 255));
		btnCadastra.setBackground(new Color(0, 0, 0));
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Vendas vendas = new Vendas();

				String v = txtValorDaVenda.getText();
				if (v.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Preço não preenchido!!");
					return;
				} else {
					v = v.replace(".", "");

					vendas.setValorDaVenda(Float.valueOf(v));
				}

				String id = txtidKart.getText();
				if (id.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID_Kart não preenchido!!");
					return;
				} else {
					vendas.setidKarts(Integer.valueOf(id));
				}
				String cpf = txtFuncionarioCPF.getText();
				if (cpf.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "CPF não preenchido!!");
					return;
				} else {
					cpf = cpf.replace(".", "");
					cpf = cpf.replace(".", "");
					cpf = cpf.replace("-", "");

					vendas.setFuncionarioCPF(Long.valueOf(cpf));

				}
				
				String DataDaVenda = txtDataDaVenda.getText();
				if(DataDaVenda.trim().length()== 0) {
					JOptionPane.showMessageDialog(null,"Data Não foi preenchida!");
					return;
				}else {
					DataDaVenda = DataDaVenda.replace("/", "");
					DataDaVenda = DataDaVenda.replace("/", "");

					
				}

				VendasDAO VendasDao = VendasDAO.getinstancia();
				if (VendasDao.inserir(vendas) == true) {
					JOptionPane.showMessageDialog(null, "Venda Cadastrada com sucesso");
					atualizarTabela();
				} else {
					JOptionPane.showMessageDialog(btnCadastra, "Erro ao Cadastrar a venda");
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
		panel_1.setBounds(281, 104, 483, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblData = new JLabel("Data da Venda:");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setBounds(10, 16, 119, 24);
		panel_1.add(lblData);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtDataDaVenda = new JFormattedTextField((AbstractFormatter) null);
		txtDataDaVenda = new JFormattedTextField(mascaraData);
		txtDataDaVenda.setColumns(10);
		txtDataDaVenda.setBounds(151, 16, 304, 28);
		panel_1.add(txtDataDaVenda);
		for (int i = 1923; i <= 2023; i++) {

		}

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 85, 125));
		panel_1_1.setBounds(822, 31, 483, 55);
		contentPane.add(panel_1_1);

		txtidKart = new JTextField();
		txtidKart.setColumns(10);
		txtidKart.setBounds(153, 16, 304, 28);
		panel_1_1.add(txtidKart);

		JLabel lblKartVendido = new JLabel("Id Kart:");
		lblKartVendido.setForeground(new Color(255, 255, 255));
		lblKartVendido.setBounds(10, 16, 102, 24);
		panel_1_1.add(lblKartVendido);
		lblKartVendido.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(0, 85, 125));
		panel_1_2_1.setBounds(281, 31, 483, 55);
		contentPane.add(panel_1_2_1);
		/*
		 
		 */
		MaskFormatter mascaraVenda = null;
		try {
			mascaraVenda = new MaskFormatter("###.#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtValorDaVenda = new JFormattedTextField(mascaraVenda);

		txtValorDaVenda.setColumns(10);
		txtValorDaVenda.setBounds(153, 16, 304, 28);
		panel_1_2_1.add(txtValorDaVenda);

		JLabel lblNewLabel = new JLabel("Valor Da Venda:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 16, 121, 24);
		panel_1_2_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBackground(new Color(0, 85, 125));
		panel_1_2_2.setBounds(822, 104, 483, 55);
		contentPane.add(panel_1_2_2);
		/*
		 * MaskFormatter mascaraCPF = null; try { mascaraCPF = new
		 * MaskFormatter("###.###.###-##"); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 * 
		 * textCPF = new JFormattedTextField(mascaraCPF);
		 */
		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtFuncionarioCPF = new JFormattedTextField(mascaraCPF);
		txtFuncionarioCPF.setColumns(10);
		txtFuncionarioCPF.setBounds(155, 16, 304, 28);
		panel_1_2_2.add(txtFuncionarioCPF);

		JLabel lblMatriculaFuncionario = new JLabel("Funcionario CPF:");
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

				Long kart = (Long) table.getValueAt(selectedRow, 1);

				VendasDAO dao = VendasDAO.getinstancia();

				Vendas v = new Vendas();
				v.setValorDaVenda(456f);
				boolean retorno = dao.Deletar(v);

				if (retorno == true) {
					// Remove a linha selecionada
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null, "Linha Excluída com Sucesso!");
				} else {
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
		ArrayList<Vendas> Vendas = dao.listar();

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "karts_id_kart", "data_venda", "valor_total", "funcionarios_cpf" });

		for (Vendas vendas : Vendas) {
			Object[] linha = { vendas.getidkarts(), vendas.getdataVendas(), vendas.getValorDaVenda(),
					vendas.getFuncionarioCPF() };
			modelo.addRow(linha);
		}
		table.setModel(modelo);
	}

}
