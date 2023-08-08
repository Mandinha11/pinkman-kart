package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.ClienteDAO;
import controle.FornecedorDAO;
import modelo.Cliente;
import modelo.Fornecedor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class TelaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCNPJ;
	private JTextField txtTelefone;
	private JTextField txtNomeEmpresa;
	private JTextField txtCEP;
	private JTable table;
	private FornecedorDAO dao;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
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

	/* CONSTRUTOR */
	public TelaFornecedor() {
		dao = FornecedorDAO.getinstancia();
		setTitle("Fornecedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1162);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 12, 127, 28);
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

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnCadastrar.setBounds(1687, 293, 210, 42);
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Fornecedor fornecedor = new Fornecedor();

				FornecedorDAO fornecedorDao = FornecedorDAO.getinstancia();

				if (txtCEP.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "CEP não preenchido!!");
					return;
				} else {
					fornecedor.setTelefone(Long.valueOf(txtCEP.getText()));

				}
				if (txtTelefone.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Telefone não preenchido!!");
					return;
				} else {
					fornecedor.setTelefone(Long.valueOf(txtTelefone.getText()));

				}

				if (txtCNPJ.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "CNPJ não preenchido!!");
					return;
				} else {
					fornecedor.setTelefone(Long.valueOf(txtCNPJ.getText()));

				}

				if (txtNomeEmpresa.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Nome da Empresa não preenchido!!");
					return;
				} else {
					fornecedor.setNomeEmpresa(txtNomeEmpresa.getText());
				}

				if (dao.Inserir(fornecedor) == true) {
					JOptionPane.showMessageDialog(btnCadastrar, "Boa");
					atualizarTabela();
				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Deu não");
				}

			}

		});
		contentPane.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnAtualizar.setBounds(1687, 135, 210, 42);
		btnAtualizar.setBackground(new Color(255, 255, 255));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		contentPane.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
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
		btnExcluir.setBounds(1689, 213, 208, 42);
		btnExcluir.setBackground(new Color(255, 255, 255));
		contentPane.add(btnExcluir);

		JPanel panel = new JPanel();
		panel.setBounds(25, 135, 1616, 855);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(513, 12, 513, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setBounds(156, 11, 335, 28);
		panel_1.add(txtNomeEmpresa);
		txtNomeEmpresa.setColumns(10);

		JLabel lblNomeEmpresa = new JLabel("Nome da empresa:");
		lblNomeEmpresa.setBounds(5, 11, 141, 28);
		panel_1.add(lblNomeEmpresa);
		lblNomeEmpresa.setForeground(new Color(0, 0, 0));
		lblNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1.setBounds(513, 78, 513, 46);
		contentPane.add(panel_1_1);

		MaskFormatter mascaraCNPJ = null;
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/000#-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtCNPJ.setBounds(157, 11, 335, 28);
		panel_1_1.add(txtCNPJ);
		txtCNPJ.setColumns(10);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 7, 43, 31);
		panel_1_1.add(lblCnpj);
		lblCnpj.setForeground(new Color(0, 0, 0));
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1_1.setBounds(1092, 12, 513, 46);
		contentPane.add(panel_1_1_1);

		MaskFormatter mascaraCEP = null;
		try {
			mascaraCEP = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCEP = new JFormattedTextField(mascaraCEP);
		txtCEP.setBounds(148, 11, 335, 28);
		panel_1_1_1.add(txtCEP);
		txtCEP.setColumns(10);

		JLabel lblCpf = new JLabel("CEP:");
		lblCpf.setBounds(10, 11, 71, 28);
		panel_1_1_1.add(lblCpf);
		lblCpf.setForeground(new Color(0, 0, 0));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1_1_1.setBounds(1090, 78, 513, 46);
		contentPane.add(panel_1_1_1_1);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtTelefone = new JFormattedTextField(mascaraTel);
		txtTelefone.setBounds(148, 11, 335, 27);
		panel_1_1_1_1.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 6, 70, 31);
		panel_1_1_1_1.add(lblTelefone);
		lblTelefone.setForeground(new Color(0, 0, 0));
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 17));

		table = new JTable();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 0 4 6 8,grow");
		panel.add(table);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome da Empresa", "CNPJ", "CPF", "Telefone" });
		table.setModel(modelo);

		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFornecedor.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel.setBounds(0, 0, 1924, 1061);
		contentPane.add(lblNewLabel);

		atualizarTabela();
	}

	public void atualizarTabela() {

		dao = FornecedorDAO.getinstancia();
		ArrayList<Fornecedor> fornecedores = dao.Listar();

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome da Empresa", "CNPJ", "CPF", "Telefone" });
		table.setModel(modelo);

		for (Fornecedor fornecedor : fornecedores) {
			Object[] linha = { fornecedor.getNomeEmpresa(), fornecedor.getCnpj(), fornecedor.getCep(),
					fornecedor.getTelefone() };
			modelo.addRow(linha);
		}

		table.setModel(modelo);
	}

}
