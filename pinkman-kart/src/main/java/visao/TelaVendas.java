package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import modelo.Cliente;
import modelo.Vendas;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JTextField txtidKart;
	private JTextField txtValorDaVenda;
	private JTextField txtFuncionarioCPF;

	private VendasDAO dao;
	private JTextField txtDataDaVenda;
	private JTable table;
	private DefaultTableModel modelo;
	private ArrayList<Vendas> listar = new ArrayList<Vendas>();

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
					// Substituindo virgula pelo ponto, o separador do java é o ponto
					v = v.replace(",", ".");
					
					vendas.setValorDaVenda(Float.valueOf(v));
				}

				String id = txtidKart.getText();
				if (id.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID_Kart não preenchido!!");
					return;
				} else {
					vendas.setIdKarts(Integer.valueOf(id));
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
				if (DataDaVenda.trim().length() == 0) {
					new MensagemErro("Data não preenchida !").setVisible(true);
					return;
				} else {

					DataDaVenda = DataDaVenda.trim();
					DataDaVenda = DataDaVenda.replace("/", "");
					if (DataDaVenda.trim().isEmpty()) {
						new MensagemErro("Data não preenchida !").setVisible(true);
						return;

					} else {
						DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy"); // Define o formato da
						// data
						LocalDate data = LocalDate.parse(DataDaVenda, formato);
						vendas.setDataVendas(data);

					}

				}

				VendasDAO VendasDao = VendasDAO.getinstancia();
				if (VendasDao.inserir(vendas) == true) {
					new MensagemAcerto("Cadastrado !").setVisible(true);
					atualizarTabela();
				} else {
					new MensagemErro("Não foi possivel cadastrar !").setVisible(true);
				}

			}

		});
		btnCadastra.setBounds(36, 224, 187, 49);
		contentPane.add(btnCadastra);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(167, 10, 10));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaSelecao ts = new TelaSelecao();
				ts.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ts.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 121, 28);
		contentPane.add(btnVoltar);

		JPanel panel_dataVenda = new JPanel();
		panel_dataVenda.setBackground(new Color(0, 85, 125));
		panel_dataVenda.setBounds(281, 127, 483, 55);
		contentPane.add(panel_dataVenda);
		panel_dataVenda.setLayout(null);

		JLabel LabelDataVnda = new JLabel("Data da Venda:");
		LabelDataVnda.setForeground(new Color(255, 255, 255));
		LabelDataVnda.setBounds(10, 16, 119, 24);
		panel_dataVenda.add(LabelDataVnda);
		LabelDataVnda.setFont(new Font("Tahoma", Font.PLAIN, 16));

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//txtDataDaVenda = new JFormattedTextField((AbstractFormatter) null);
		txtDataDaVenda = new JFormattedTextField(mascaraData);
		txtDataDaVenda.setColumns(10);
		txtDataDaVenda.setBounds(151, 16, 304, 28);
		panel_dataVenda.add(txtDataDaVenda);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(0, 0, 483, 55);
		panel_dataVenda.add(lblNewLabel_1_1);

		JPanel panel_idKart = new JPanel();
		panel_idKart.setLayout(null);
		panel_idKart.setBackground(new Color(0, 85, 125));
		panel_idKart.setBounds(822, 31, 483, 55);
		contentPane.add(panel_idKart);

		txtidKart = new JTextField();
		txtidKart.setColumns(10);
		txtidKart.setBounds(153, 16, 304, 28);
		panel_idKart.add(txtidKart);

		JLabel LabelIdKart = new JLabel("Id Kart:");
		LabelIdKart.setForeground(new Color(255, 255, 255));
		LabelIdKart.setBounds(10, 16, 102, 24);
		panel_idKart.add(LabelIdKart);
		LabelIdKart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(0, 0, 483, 55);
		panel_idKart.add(lblNewLabel_1_2);

		JPanel panel_vendas = new JPanel();
		panel_vendas.setLayout(null);
		panel_vendas.setBackground(new Color(0, 85, 125));
		panel_vendas.setBounds(281, 31, 483, 55);
		contentPane.add(panel_vendas);
		/*
		 
		 */
		MaskFormatter mascaraVenda = null;
		try {
			mascaraVenda = new MaskFormatter("#.###.###,##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtValorDaVenda = new JFormattedTextField(mascaraVenda);

		txtValorDaVenda.setColumns(10);
		txtValorDaVenda.setBounds(153, 16, 304, 28);
		panel_vendas.add(txtValorDaVenda);

		JLabel LabelValorVenda = new JLabel("Valor Da Venda:");
		LabelValorVenda.setForeground(new Color(255, 255, 255));
		LabelValorVenda.setBackground(new Color(255, 255, 255));
		LabelValorVenda.setBounds(10, 16, 121, 24);
		panel_vendas.add(LabelValorVenda);
		LabelValorVenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 483, 55);
		panel_vendas.add(lblNewLabel_1);

		JPanel panel_funcionario = new JPanel();
		panel_funcionario.setLayout(null);
		panel_funcionario.setBackground(new Color(0, 85, 125));
		panel_funcionario.setBounds(822, 127, 483, 55);
		contentPane.add(panel_funcionario);
		
		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtFuncionarioCPF = new JFormattedTextField(mascaraCPF);
		txtFuncionarioCPF.setColumns(10);
		txtFuncionarioCPF.setBounds(155, 16, 304, 28);
		panel_funcionario.add(txtFuncionarioCPF);

		JLabel LabelFuncionarioCPF = new JLabel("Funcionario CPF:");
		LabelFuncionarioCPF.setForeground(new Color(255, 255, 255));
		LabelFuncionarioCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelFuncionarioCPF.setBounds(10, 18, 156, 20);
		panel_funcionario.add(LabelFuncionarioCPF);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(0, 0, 483, 55);
		panel_funcionario.add(lblNewLabel_1_1_1);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(0, 0, 0));
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBounds(36, 310, 187, 49);
		contentPane.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				int idVenda = (Integer) table.getValueAt(selectedRow, 0);

				VendasDAO dao = VendasDAO.getinstancia();

				Vendas v = new Vendas();
				v.setIdVenda(idVenda);
				boolean retorno = dao.Deletar(v);

				if (retorno == true) {
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.removeRow(selectedRow);
					new MensagemAcerto("Excluido com sucesso !").setVisible(true);
				} else {
					new MensagemErro("Não foi possivel excluir!").setVisible(true);
				}

			}
		});
		btnExcluir.setBounds(36, 401, 187, 49);
		contentPane.add(btnExcluir);

		JLabel ImagemCarrinho = new JLabel("");
		ImagemCarrinho.setHorizontalAlignment(SwingConstants.CENTER);
		ImagemCarrinho.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/CarrinhoDeCompras.png")));
		ImagemCarrinho.setBounds(42, 814, 181, 180);
		contentPane.add(ImagemCarrinho);

		/**
		 * Tabela
		 */
		JPanel panelTabela = new JPanel();
		panelTabela.setBounds(340, 278, 1488, 447);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		panelTabela.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(table);
		panelTabela.add(scrollPane, BorderLayout.NORTH);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] {  "id_kart", "Data_da_Venda", "Valor_Da_Venda", "Funcionarios_CPF" });
		table.setModel(modelo);
		contentPane.add(panelTabela);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaVendas.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel.setBounds(10, -10, 1924, 1063);
		contentPane.add(lblNewLabel);

		atualizarTabela();

	}

	private void atualizarTabela() {

		dao = VendasDAO.getinstancia();
		ArrayList<Vendas> Vendas = dao.listar();
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "id_kart", "Data_da_Venda", "Valor_Da_Venda", "Funcionarios_CPF" });

		for (Vendas vendas : Vendas) {
			Object[] linha = { vendas.getIdKarts(), vendas.getDataVendas(), vendas.getValorDaVenda(),
					vendas.getFuncionarioCPF() };
			modelo.addRow(linha);
		}

		table.setModel(modelo);

	}
}
