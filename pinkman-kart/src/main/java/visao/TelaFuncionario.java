package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import controle.FuncionarioDAO;
import modelo.Funcionario;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textNomeCompleto;
	private JTable tableFunc;
	private JTable table_1;
	private JComboBox<String> boxCargo;
	private FuncionarioDAO dao;
	private DefaultTableModel modelo;
	private JTextField textDataNac;

	/**
	 * CONSTRUTOR
	 */
	public TelaFuncionario() {

		setTitle("Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2093, 1226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(23, 11, 112, 28);
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(167, 10, 10));
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

		JPanel panel = new JPanel();
		panel.setBounds(464, 22, 516, 58);
		panel.setBackground(new Color(0, 85, 125));
		contentPane.add(panel);
		panel.setLayout(null);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textCPF = new JFormattedTextField(mascaraCPF);

		textCPF.setBounds(147, 15, 317, 26);
		panel.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(103, 11, 34, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(0, 0, 516, 58);
		panel.add(lblNewLabel_1_2);

		JPanel PnDataDeNascimento = new JPanel();
		PnDataDeNascimento.setBounds(464, 127, 516, 58);
		PnDataDeNascimento.setBackground(new Color(0, 85, 125));
		PnDataDeNascimento.setLayout(null);
		contentPane.add(PnDataDeNascimento);

		JLabel lblNewLabel_2 = new JLabel("Data De Nascimento:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(24, 14, 166, 26);
		PnDataDeNascimento.add(lblNewLabel_2);
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textDataNac = new JFormattedTextField((AbstractFormatter) null);
		textDataNac = new JFormattedTextField(mascaraData);
		textDataNac.setColumns(10);
		textDataNac.setBounds(207, 17, 299, 26);
		PnDataDeNascimento.add(textDataNac);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(0, 0, 516, 58);
		PnDataDeNascimento.add(lblNewLabel_1_3);

		JPanel PnCargo = new JPanel();
		PnCargo.setBounds(1095, 127, 518, 58);
		PnCargo.setBackground(new Color(0, 85, 125));
		PnCargo.setLayout(null);
		contentPane.add(PnCargo);

		JLabel lblNewLabel_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(90, 10, 51, 28);
		PnCargo.add(lblNewLabel_1_1);

		boxCargo = new JComboBox<>();
		boxCargo.setBounds(151, 13, 338, 28);
		PnCargo.add(boxCargo);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setBounds(0, 0, 518, 58);
		PnCargo.add(lblNewLabel_1_5);
		boxCargo.addItem("Selecionar Cargo");
		boxCargo.addItem("Vendedor");
		boxCargo.addItem("Recepcionista");
		boxCargo.addItem("Caixa");
		boxCargo.addItem("Funcionario");

		tableFunc = new JTable();

		JScrollPane scrollPane = new JScrollPane(tableFunc);
		scrollPane.setViewportView(tableFunc);
		scrollPane.setBounds(396, 260, 1448, 732);

		JButton btnCadastratar = new JButton("Cadastrar");
		btnCadastratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario funcionario = new Funcionario();

				String text = textCPF.getText();
				if (text.trim().length() == 0) {
					new MensagemErro("CPF não preenchido !").setVisible(true);
					return;
				} else {
					text = text.replace(".", "");
					text = text.replace(".", "");
					text = text.replace("-", "");
					text = text.trim();

					funcionario.setCpf(Long.valueOf(text));
				}
				String txt = textNomeCompleto.getText();
				if (txt.trim().length() == 0) {
					new MensagemErro("Nome não preenchido !").setVisible(true);
					return;
				} else {
					funcionario.setNomeCompleto(String.valueOf(txt));
				}

				String data = textDataNac.getText();
				if (data.trim().length() == 0) {
					new MensagemErro("Data não preenchido !").setVisible(true);
					return;
				} else {
					data = data.replace("/", "");
					data = data.replace("/", "");
					data = data.trim();

					if (data.trim().isEmpty()) {
						new MensagemErro("Data não preenchido !").setVisible(true);
						return;

					} else {

						DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy"); // Define o formato da data
						LocalDate dataNasc = LocalDate.parse(data, formato);
						funcionario.setDataNac(dataNasc);
					}
				}

				String cargo = (String) boxCargo.getSelectedItem();
				if (cargo.trim().length() == 0) {
					new MensagemErro("Cargo não preenchido !").setVisible(true);
					return;
				} else {
					funcionario.setCargo(cargo);
				}

				FuncionarioDAO dao = FuncionarioDAO.getinstancia();

				if (dao.inserir(funcionario) == true) {
					new MensagemAcerto("Cadastrado !").setVisible(true);
					atualizarTabela();
				} else {
					new MensagemErro("Não foi possivel cadastrar !").setVisible(true);
				}
			}
		});
		btnCadastratar.setBounds(66, 230, 276, 53);
		btnCadastratar.setForeground(new Color(255, 255, 255));
		btnCadastratar.setBackground(new Color(0, 0, 0));
		btnCadastratar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnCadastratar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se uma linha foi selecionada na tabela
				int selectedRow = table_1.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um funcionário na tabela para atualizar.");
					return;
				}

				// Obtém os valores da linha selecionada
				long cpf = (long) table_1.getValueAt(selectedRow, 0);
				String nome = (String) table_1.getValueAt(selectedRow, 1);
				String cargo = (String) table_1.getValueAt(selectedRow, 2);
				String dataNascimento = (String) table_1.getValueAt(selectedRow, 3);

				// Converte a data de nascimento para o formato correto
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataNasc = LocalDate.parse(dataNascimento, formato);

				// Preenche o objeto Funcionario com os valores da linha selecionada
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(cpf);
				funcionario.setNomeCompleto(nome);
				funcionario.setCargo(cargo);
				funcionario.setDataNac(dataNasc);

				// Abre uma janela de diálogo para editar as informações
				EditarFuncionarioDialog dialog = new EditarFuncionarioDialog(funcionario);
				dialog.setVisible(true);

				// Verifica se as informações foram alteradas no diálogo
				if (dialog.isInformacoesAlteradas()) {
					// Atualiza os valores do funcionário com as alterações
					funcionario = dialog.getFuncionarioAtualizado();

					// Chama o método alterar do FuncionarioDAO para atualizar o funcionário
					FuncionarioDAO dao = FuncionarioDAO.getinstancia();
					boolean retorno = dao.alterar(funcionario);

					if (retorno) {
						new MensagemAcerto("Funcionario atualizado com sucesso!").setVisible(true);
						// Atualiza a tabela após a alteração
						atualizarTabela();
					} else {
						new MensagemErro("Erro ao atualizar o funcionario. !").setVisible(true);
					}
				}
			}
		});
		btnAtualizar.setBounds(66, 314, 276, 53);
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBackground(new Color(0, 0, 0));
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(66, 407, 276, 53);
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();

				long cpf = (long) table_1.getValueAt(selectedRow, 0);

				FuncionarioDAO dao = FuncionarioDAO.getinstancia();

				Funcionario f = new Funcionario();
				f.setCpf(cpf);
				boolean retorno = dao.deletar(f);

				if (retorno == true) {
					// Remove a linha selecionado
					DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
					tableModel.removeRow(selectedRow);
					new MensagemAcerto("Excluido com sucesso !").setVisible(true);

				} else {
					new MensagemErro("Não foi possivel excluir!").setVisible(true);
				}

			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnExcluir);

		JPanel PnNomeCompleto = new JPanel();
		PnNomeCompleto.setBounds(1095, 22, 518, 58);
		PnNomeCompleto.setBackground(new Color(0, 85, 125));
		PnNomeCompleto.setLayout(null);
		contentPane.add(PnNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setColumns(10);
		textNomeCompleto.setBounds(152, 11, 339, 36);
		PnNomeCompleto.add(textNomeCompleto);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNomeCompleto.setBounds(10, 12, 129, 28);
		PnNomeCompleto.add(lblNomeCompleto);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_1_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(0, 0, 518, 58);
		PnNomeCompleto.add(lblNewLabel_1_4);

		JPanel panel_1 = new JPanel();

		panel_1.setBounds(464, 223, 1151, 466);

		table_1 = new JTable();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, "cell 0 4 6 8,grow");
		panel_1.add(table_1);

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Cargo", "Data" });
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Cargo", "Data" }));

		atualizarTabela();

		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		panel_1.add(scrollPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/Funcionario2.png")));
		lblNewLabel_3.setBounds(-44, 803, 352, 247);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Funcionario");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 50));
		lblNewLabel_1.setBounds(277, 910, 326, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_4.setBounds(0, -49, 1948, 1110);
		contentPane.add(lblNewLabel_4);

	}

	public void atualizarTabela() {

		dao = FuncionarioDAO.getinstancia();
		ArrayList<Funcionario> funcionarios = dao.listar();

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Cargo", "Data" });

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Funcionario funcionario : funcionarios) {
			Object[] linha = { funcionario.getCpf(), funcionario.getNomeCompleto(), funcionario.getCargo(),
					funcionario.getDataNac().format(formato) };
			modelo.addRow(linha);
		}

		table_1.setModel(modelo);
	}
}
