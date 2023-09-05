package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;

import controle.ClienteDAO;
import controle.FornecedorDAO;
import modelo.Cliente;
import modelo.Fornecedor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textCPF;
	private JTextField textTelefone;
	private JTable table;
	private ClienteDAO clienteDAO;
	private DefaultTableModel modelo;
	private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	private static Cliente clienteSelecionado;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public TelaCliente() {

		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2216, 1104);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.setBounds(51, 218, 242, 57);
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Cliente cliente = new Cliente();

				String data = txtData.getText();
				if (data.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Data de Nascimento não preenchido!!");
					return;
				} else {
					data = data.replace("/", "");
					data = data.trim();

					String dia = data.substring(0, 1);
					String mes = data.substring(2, 3);
					String ano = data.substring(4, 7);

					cliente.setDataNac(LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia)));

				}

				String cpf = textCPF.getText();
				if (cpf.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "CPF não preenchido!!");
					return;
				} else {
					cpf = cpf.replace(".", "");
					cpf = cpf.replace(".", "");
					cpf = cpf.replace("-", "");

					cliente.setCpf(Long.valueOf(cpf));

				}

				String tel = textTelefone.getText();
				if (tel.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Telefone não preenchido!!");
					return;
				} else {
					tel = tel.replace("-", "");
					tel = tel.replace(" ", "");
					tel = tel.replace("(", "");
					tel = tel.replace(")", "");
					tel = tel.trim();

					cliente.setTelefone(Long.valueOf(tel));

				}

				if (textNomeCompleto.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Nome da Pessoa não preenchido!!");
					return;
				} else {
					cliente.setNomeCompleto(textNomeCompleto.getText());
				}

				ClienteDAO clienteDao = ClienteDAO.getinstancia();
				if (clienteDao.inserir(cliente) == true) {
					JOptionPane.showMessageDialog(btnCadastrar, "Cadastrado");
					atualizarTabela();
				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Não foi posivel Cadastrar");
				}

			}

		});
		contentPane.add(btnCadastrar);

		contentPane.setLayout(null);
		contentPane.add(btnCadastrar);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBackground(new Color(167, 10, 10));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(4, 9, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaSelecao ts = new TelaSelecao();
				ts.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ts.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBounds(380, 35, 506, 45);
		panel.setBackground(new Color(0, 85, 125));
		panel.setToolTipText("");
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 11, 176, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));

		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(177, 11, 319, 23);
		panel.add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1048, 35, 506, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBackground(new Color(0, 85, 125));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblCpf.setBackground(Color.BLACK);
		lblCpf.setBounds(29, 6, 110, 25);
		panel_1.add(lblCpf);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCPF = new JFormattedTextField(mascaraCPF);

		textCPF.setBounds(179, 9, 317, 25);
		panel_1.add(textCPF);
		textCPF.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(380, 107, 506, 45);
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBackground(new Color(0, 85, 125));
		contentPane.add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 11, 191, 25);
		panel_2.add(lblNewLabel_2);

		JLabel lblDataNasc = new JLabel("Data De Nascimento:");
		lblNewLabel_2.setBounds(10, 11, 191, 25);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		txtData = new JTextField();
		txtData.setBounds(176, 11, 320, 25);
		panel_2.add(txtData);
		txtData.setColumns(10);

		MaskFormatter mascaraDataNac = null;
		try {
			mascaraDataNac = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtData = new JFormattedTextField(mascaraDataNac);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(1048, 107, 506, 45);
		panel_1_1.setLayout(null);
		panel_1_1.setToolTipText("");
		panel_1_1.setBackground(new Color(0, 85, 125));
		contentPane.add(panel_1_1);

		JLabel lblNewLabel_3 = new JLabel("Numero de Telefone:");
		lblNewLabel_3.setBounds(10, 11, 156, 23);
		panel_1_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textTelefone = new JFormattedTextField(mascaraTel);

		textTelefone.setBounds(179, 11, 317, 23);
		panel_1_1.add(textTelefone);
		textTelefone.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(351, 278, 1461, 772);
		contentPane.add(panel_3);

		/**
		 * Tabela
		 */
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * Selecionou uma linha da tabela
				 */
				int selectedRow = table.getSelectedRow();

				String cpf = (String) table.getValueAt(selectedRow, 1);

				// fazer uma consulta no banco procurando um cliente por CPF ou no arraylist
				
//				clienteSelecionado = // cliente encontrado

//				textNomeCompleto.setText(clienteSelecionado.getNome...);
//				txtData.setText();
//				textTelefone.setText();
			}
		});
		panel_3.add(scrollPane, BorderLayout.NORTH);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome Completo", "CPF", "Data Nasc", "Telefone" });

		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPf", "Data Nac", "Telefone" }));

		atualizarTabela();

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(0, 0, 0));
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Pega os dados digitados nos campos
				// Atualiza no usuario selecionado no banco

				atualizarTabela();
				contentPane.add(btnAtualizar);
			}

		});

		btnAtualizar.setBounds(51, 319, 242, 57);
		btnAtualizar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				long cpf = (long) table.getValueAt(selectedRow, 1);

				ClienteDAO dao = ClienteDAO.getinstancia();

				Cliente c = new Cliente();
				c.setCpf(cpf);
				boolean retorno = dao.Deletar(c);

				if (retorno == true) {

					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null, "Linha excluída com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao excluir!");
				}

			}
		});

		btnExcluir.setBounds(120, 42, 89, 23);
		contentPane.add(btnExcluir);

		btnExcluir.setBounds(51, 424, 242, 57);
		btnExcluir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnExcluir);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(1600, 35, 141, 115);
		lblNewLabel_1.setIcon(new ImageIcon(TelaCliente.class.getResource("/imgs/Cliente2.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(TelaCliente.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1939, 1071);
		contentPane.add(lblNewLabel_4);

	}

	protected void limparCampos() {
		textNomeCompleto.setText("");
		textCPF.setText("");
		textTelefone.setText("");
		txtData.setText("");

	}

	public void atualizarTabela() {

		clienteDAO = ClienteDAO.getinstancia();
		ArrayList<Cliente> clientes = clienteDAO.listar();

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome Completo", "CPF", "Data Nasc", "Telefone" });

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (Cliente cliente : clientes) {
			Object[] linha = { cliente.getNomeCompleto(), cliente.getCpf(), cliente.getDataNac(),
					cliente.getTelefone() };
			modelo.addRow(linha);

		}
		table.setModel(modelo);
	}
}
