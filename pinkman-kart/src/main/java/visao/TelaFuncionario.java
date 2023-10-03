package visao;

import java.util.Date;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

import controle.FornecedorDAO;
import controle.FuncionarioDAO;
import modelo.Fornecedor;
import modelo.Funcionario;
import java.awt.Component;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textNomeCompleto;
	private JTable tableFunc;
	private JTable table;
	private JTable table_1;
	private JComboBox<String> boxCargo;
	private JComboBox<String> boxMes;
	private JComboBox<String> boxDia;
	private JComboBox<String> boxAno;
	private FuncionarioDAO dao;
	private DefaultTableModel modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		panel.setBounds(464, 22, 516, 48);
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

		textCPF.setBounds(149, 11, 339, 26);
		panel.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(105, 7, 34, 28);
		panel.add(lblNewLabel);

		JPanel PnDataDeNascimento = new JPanel();
		PnDataDeNascimento.setBounds(464, 127, 516, 48);
		PnDataDeNascimento.setBackground(new Color(0, 85, 125));
		PnDataDeNascimento.setLayout(null);
		contentPane.add(PnDataDeNascimento);

		JLabel lblNewLabel_2 = new JLabel("Data De Nascimento:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(23, 11, 160, 26);
		PnDataDeNascimento.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Dia");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(193, 14, 31, 26);
		PnDataDeNascimento.add(lblNewLabel_3);

		boxDia = new JComboBox<>();
		boxDia.setBounds(234, 14, 47, 26);
		PnDataDeNascimento.add(boxDia);
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

		JLabel lblNewLabel_4 = new JLabel("Mês");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(291, 14, 27, 26);
		PnDataDeNascimento.add(lblNewLabel_4);

		boxMes = new JComboBox<>();
		boxMes.setBounds(328, 14, 47, 26);
		PnDataDeNascimento.add(boxMes);

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
		
		JLabel lblNewLabel_5 = new JLabel("Ano");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(385, 13, 27, 28);
		PnDataDeNascimento.add(lblNewLabel_5);

		JComboBox<Integer> boxAno = new JComboBox<>();
		boxAno.setBounds(422, 14, 68, 26);
		PnDataDeNascimento.add(boxAno);
		for (int i = 1923; i <= 2023; i++) {
			boxAno.addItem(i);
		}

		JPanel PnCargo = new JPanel();
		PnCargo.setBounds(1095, 127, 518, 48);
		PnCargo.setBackground(new Color(0, 85, 125));
		PnCargo.setLayout(null);
		contentPane.add(PnCargo);

		JLabel lblNewLabel_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(90, 10, 51, 28);
		PnCargo.add(lblNewLabel_1_1);

		boxCargo = new JComboBox<>();
		boxCargo.setBounds(151, 10, 338, 28);
		PnCargo.add(boxCargo);
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

				Funcionario Funcionario = new Funcionario();

				String text = textCPF.getText();
				if (text.trim().length() == 0) {
					new MensagemErro("CPF não preenchido !").setVisible(true);
					return;
				} else {
					text = text.replace(".", "");
					text = text.replace(".", "");
					text = text.replace("-", "");
					Funcionario.setCpf(Long.valueOf(text));
				}
				String txt = textNomeCompleto.getText();
				if (txt.trim().length() == 0) {
					new MensagemErro("Nome não preenchido !").setVisible(true);
					return;
				} else {
					Funcionario.setNomeCompleto(String.valueOf(txt));
				}
				String dia = (String) boxDia.getSelectedItem();
				String mes = (String) boxMes.getSelectedItem();
				String ano = (String) boxAno.getSelectedItem();

				if (dia == null || mes == null || ano == null) {
				    
					new MensagemErro("Data não preenchido !").setVisible(true);
					return;
				}

				String dataString = dia + mes + ano; 

				try {
				    
				    SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");

				    java.util.Date dataNascimento = sdf.parse(dataString);

				    
				    Funcionario.setDataNac(dataNascimento);
				} catch (ParseException e1) {
				    e1.printStackTrace();
				    new MensagemErro("Data de Nascimento não preenchido !").setVisible(true);
				    return; 
				}

				FuncionarioDAO dao = FuncionarioDAO.getinstancia();

				if (dao.inserir(Funcionario) == true) {
					JOptionPane.showMessageDialog(null, "Boa");
					atualizarTabela();
				} else {
					new MensagemErro("Não foi possivel cadastrar !").setVisible(true);
				}
			}
		});
		btnCadastratar.setBounds(66, 223, 276, 53);
		btnCadastratar.setForeground(new Color(255, 255, 255));
		btnCadastratar.setBackground(new Color(47, 79, 79));
		btnCadastratar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnCadastratar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFuncionarios();
			}
		});
		btnListar.setBounds(66, 314, 276, 53);
		btnListar.setForeground(new Color(255, 255, 255));
		btnListar.setBackground(new Color(47, 79, 79));
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnListar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(66, 407, 276, 53);
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(47, 79, 79));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				long matricula = (long) table.getValueAt(selectedRow, 1);

				FuncionarioDAO dao = FuncionarioDAO.getinstancia();

				Funcionario f = new Funcionario();
				f.setMatricula(matricula);
				boolean retorno = dao.deletar(f);

				if (retorno == true) {
					// Remove a linha selecionada
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null, "Linha excluída com sucesso!");

				} else {
					JOptionPane.showMessageDialog(null, "Erro ao excluir!");
				}

			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnExcluir);

		JPanel PnNomeCompleto = new JPanel();
		PnNomeCompleto.setBounds(1095, 22, 518, 48);
		PnNomeCompleto.setBackground(new Color(0, 85, 125));
		PnNomeCompleto.setLayout(null);
		contentPane.add(PnNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setColumns(10);
		textNomeCompleto.setBounds(149, 11, 339, 26);
		PnNomeCompleto.add(textNomeCompleto);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setForeground(new Color(255, 255, 255));
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNomeCompleto.setBounds(10, 7, 129, 28);
		PnNomeCompleto.add(lblNomeCompleto);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1654, 57, 165, 132);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/Funcionario2.png")));
		contentPane.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(464, 223, 1408, 756);
		
		
		table_1 = new JTable();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, "cell 0 4 6 8,grow");
		panel_1.add(table_1);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "CPF", "Nome", "Cargo", "Data" });
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "CPF", "Nome", "Cargo", "Data"
			}
		));

		atualizarTabela();

		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		 
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		panel_1.add(scrollPane_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_6.setBounds(-159, 0, 1924, 1061);
		contentPane.add(lblNewLabel_6);

	}

	
	private void listarFuncionarios() {
	    FuncionarioDAO funcionarioDAO = FuncionarioDAO.getinstancia();
	    ArrayList<Funcionario> funcionarios = funcionarioDAO.listar();
	    
	    
	    DefaultTableModel tableModel = (DefaultTableModel) tableFunc.getModel();
	    tableModel.setRowCount(0); 
	    
	    for (Funcionario funcionario : funcionarios) {
	        Object[] rowData = { funcionario.getMatricula(), funcionario.getNomeCompleto(), funcionario.getCpf(), funcionario.getDataNac(), funcionario.getCargo() };
	        tableModel.addRow(rowData);
	    }
	}
	public void atualizarTabela() {

		/*
		 * String nome = txtNome.getText(); String cpf = txtCPF.getText(); Pessoa p =
		 * new Pessoa(); p.setNome(nome); p.setCpf(cpf); listaPessoas.add(p);
		 * atualizarJTable(); limparCampos();
		 */
		dao = FuncionarioDAO.getinstancia();
		ArrayList<Funcionario> funcionarios = dao.listar();

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "CPF", "Nome", "Cargo", "Data" });

		for (Funcionario funcionario : funcionarios) {
			Object[] linha = { funcionario.getCpf(), funcionario.getNomeCompleto(),funcionario.getCargo(),
					funcionario.getDataNac() };
			modelo.addRow(linha);
		}

		table.setModel(modelo);
	}
}
