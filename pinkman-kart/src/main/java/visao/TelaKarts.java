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

import com.google.protobuf.Empty;

import controle.ClienteDAO;
import controle.FornecedorDAO;
import controle.KartsDAO;
import modelo.Fornecedor;
import modelo.Karts;
import modelo.MonetarioDocument;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.UIManager;
//=======
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
//>>>>>>> Stashed changes;

public class TelaKarts extends JFrame {

	protected static final GraphicsConfiguration karts = null;
	private JPanel contentPane;
	private JTextField txtPreco;
	private JTextField txtPreco_1;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTable tabelaKarts;
	private JTextField txtCor;
	private JTextField txtQuantidade;
	private JTextField txtAno;
	private KartsDAO dao;
	private DefaultTableModel modelo;
	private JTable table;
	private JTextField txtDataEntrada;
	private JComboBox<Fornecedor> comboBox;

	/**
	 * Create the frame.
	 */
	public TelaKarts() {
		setTitle("Karts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2218, 1126);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(167, 10, 10));
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

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBounds(98, 556, 271, 41);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Karts karts = new Karts();

				KartsDAO kartsdao = KartsDAO.getinstancia();

				String preco = txtPreco_1.getText();
				preco = preco.replace("R$", "");
				System.out.println(preco);
				preco = preco.replace(".", "");
				System.out.println(preco);
				preco = preco.replace(".", "");
				System.out.println(preco);
				preco = preco.replace(",", "");
				System.out.println(preco);
				preco = preco.trim();

				System.out.println(preco);
				if (preco.trim().length() == 0) {
					new MensagemErro("Preço não preenchido !").setVisible(true);
					return;
				} else {

					karts.setpreco(Long.valueOf(preco));
				}

				if (txtMarca.getText().trim().length() == 0) {
					new MensagemErro("Marca não preenchido!").setVisible(true);
					return;
				} else {
					karts.setMarca(String.valueOf(txtMarca.getText()));
				}

				if (txtModelo.getText().trim().length() == 0) {
					new MensagemErro("Modelo não preenchido!").setVisible(true);
					return;
				} else {
					karts.setModelo(String.valueOf(txtModelo.getText()));
				}

				
				if (txtAno.getText().trim().length() == 0) {
					new MensagemErro("Ano não preenchido!").setVisible(true);
					return;
				} else {
					karts.setano(Long.valueOf(txtAno.getText()));
				}
				Fornecedor fornecedor = (Fornecedor) comboBox.getSelectedItem();


					karts.setCNPJ(Long.valueOf(fornecedor.getCnpj()));
				

				String DataEntrada = txtDataEntrada.getText();
				if (DataEntrada.trim().length() == 0) {
					 new MensagemErro("Data não preenchida !").setVisible(true);
					return;

				} else {
					DataEntrada = DataEntrada.replace("/", "");
					DataEntrada = DataEntrada.trim();

					if (DataEntrada.trim().isEmpty()) {

						 new MensagemErro("Data não preenchida !").setVisible(true);
						return;

					} else {
						DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy"); // Define o formato da
						// data
						LocalDate dataEntradaformatada = LocalDate.parse(DataEntrada, formato);
						karts.setDataEntrada(dataEntradaformatada);
					}
				}

				String textQuantidade = txtQuantidade.getText();
				if (txtQuantidade.getText().trim().length() == 0) {
					 new MensagemErro("Quantidade não foi Preenchida!").setVisible(true);
					return;
				} else {
					karts.setquantidade(Long.valueOf(textQuantidade));
				}
				String Cor = txtCor.getText();
				if (txtCor.getText().trim().length() == 0) {
					 new MensagemErro("A Cor não foi Preenchida!").setVisible(true);
				} else {
					karts.setCor(String.valueOf(Cor));
				}

				KartsDAO kartDao = KartsDAO.getinstancia();

				if (kartDao.Inserir(karts) == true) {
					new MensagemAcerto("Cadastrado !").setVisible(true);
					atualizarTabela();
				} else {
					new MensagemErro("Não foi possivel cadastrar !").setVisible(true);
				}

			}

		});
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnCadastrar);

	

		txtPreco = new JTextField();
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("R$ #.###.###,##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		txtAno = new JTextField();
		MaskFormatter formatter1 = null;
		try {
			formatter1 = new MaskFormatter("####");
		} catch (ParseException e3) {
			e3.printStackTrace();
		}

		txtDataEntrada = new JTextField();
		MaskFormatter formatter2 = null;
		try {
			formatter2 = new MaskFormatter("##/##/####");
		} catch (ParseException e4) {
			e4.printStackTrace();
		}
		

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				Integer idkarts = (Integer) table.getValueAt(selectedRow, 0);

				KartsDAO dao = KartsDAO.getinstancia();

				Karts k = new Karts();
				k.setId(idkarts);
				boolean retorno = dao.Deletar(k);
				if (retorno == true) {
					// Remove a linha selecionada
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					tableModel.removeRow(selectedRow);
					new MensagemAcerto("Excluido com sucesso !").setVisible(true);
				} else {
					new MensagemErro("Não foi possivel excluir!").setVisible(true);
				}
			}
		});
		btnExcluir.setBounds(394, 556, 271, 41);
		btnExcluir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnExcluir);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(211, 211, 211));
		panel_4.setBounds(996, 54, 884, 939);
		contentPane.add(panel_4);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 85, 125));
		panel_1_1.setBounds(563, 322, 423, 61);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		lblDataEntrada.setBounds(10, 11, 96, 39);
		panel_1_1.add(lblDataEntrada);
		lblDataEntrada.setForeground(new Color(255, 255, 255));
		lblDataEntrada.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		MaskFormatter mascaraDataEntrada = null;
		try {
			mascaraDataEntrada = new MaskFormatter("##/##/####");
		} catch (ParseException e4) {
			e4.printStackTrace();
		}
		txtDataEntrada = new JFormattedTextField(mascaraDataEntrada);
		

		txtDataEntrada.setColumns(10);
		txtDataEntrada.setBounds(158, 17, 255, 32);
		panel_1_1.add(txtDataEntrada);
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter11= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataatual = now.format(formatter11);
		txtDataEntrada.setText(dataatual);
		
		JLabel lblNewLabel_7_3 = new JLabel("");
		lblNewLabel_7_3.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_3.setBounds(0, 0, 423, 61);
		panel_1_1.add(lblNewLabel_7_3);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(0, 85, 125));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(98, 232, 423, 61);
		contentPane.add(panel_1_1_1);

		txtMarca = new JTextField();
		txtMarca.setBounds(154, 20, 259, 30);
		panel_1_1_1.add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblMarcaKarts = new JLabel("Marca:");
		lblMarcaKarts.setBounds(10, 17, 67, 30);
		panel_1_1_1.add(lblMarcaKarts);
		lblMarcaKarts.setForeground(new Color(255, 255, 255));
		lblMarcaKarts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 423, 61);
		panel_1_1_1.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(new Color(0, 85, 125));
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(563, 413, 423, 61);
		contentPane.add(panel_1_1_2);
		
		MaskFormatter mascaraCNPJ1 = null;
		try {
			mascaraCNPJ1 = new MaskFormatter("##.###.###/000#-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	

		JLabel lblNewLabel = new JLabel("Fornecedor CNPJ:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 21, 137, 22);
		panel_1_1_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		comboBox = new JComboBox<Fornecedor>();
		comboBox.setBounds(180, 24, 233, 22);
		
		
		FornecedorDAO fDAO = new FornecedorDAO();
		ArrayList<Fornecedor> lstaf = fDAO.Listar();
		
		for (Fornecedor fornecedor : lstaf) {
			comboBox.addItem(fornecedor);
		}
		panel_1_1_2.add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(0, 0, 423, 61);
		panel_1_1_2.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 85, 125));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(98, 142, 423, 61);
		contentPane.add(panel_1_2);

		JLabel lblBuscarKarts = new JLabel("Cor:");
		lblBuscarKarts.setBounds(10, 11, 67, 30);
		panel_1_2.add(lblBuscarKarts);
		lblBuscarKarts.setForeground(new Color(255, 255, 255));
		lblBuscarKarts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(153, 19, 260, 30);
		panel_1_2.add(txtCor);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setBounds(0, 0, 423, 61);
		panel_1_2.add(lblNewLabel_7_1);
		lblNewLabel_7_1.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(0, 85, 125));
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(98, 322, 423, 61);
		contentPane.add(panel_1_3);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 14, 104, 30);
		panel_1_3.add(lblQuantidade);
		lblQuantidade.setForeground(new Color(255, 255, 255));
		lblQuantidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(153, 17, 260, 30);
		panel_1_3.add(txtQuantidade);
		
		JLabel lblNewLabel_7_2 = new JLabel("");
		lblNewLabel_7_2.setBounds(0, 0, 423, 61);
		panel_1_3.add(lblNewLabel_7_2);
		lblNewLabel_7_2.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);

		// JPanel panel_4 = new JPanel();
		panel_4.setBounds(996, 54, 857, 939);
		panel_4.setBackground(new Color(211, 211, 211));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 879, 1003);
		panel_4.add(scrollPane);

		table = new JTable();

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID_kart", "cor", "Modelo", "Marca", "Ano",
				"Quantidade", "Data_Entrada", "Preço", "fornecedor_CNPJ" });
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID_kart", "cor", "Modelo", "Marca",
				"Ano", "Quantidade", "Data_Entrada", "Preço", "fornecedor_CNPJ" }));

		atualizarTabela();

		table.getColumnModel().getColumn(6).setPreferredWidth(77);
		table.getColumnModel().getColumn(8).setPreferredWidth(96);
		scrollPane.setViewportView(table);

		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(new Color(0, 85, 125));
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(563, 142, 423, 61);
		contentPane.add(panel_1_4);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 20, 67, 30);
		panel_1_4.add(lblModelo);
		lblModelo.setForeground(new Color(255, 255, 255));
		lblModelo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		txtModelo = new JTextField();
		txtModelo.setBounds(153, 20, 260, 30);
		panel_1_4.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("");
		lblNewLabel_7_2_1.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_2_1.setBounds(0, 0, 423, 61);
		panel_1_4.add(lblNewLabel_7_2_1);

		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(new Color(0, 85, 125));
		panel_1_5.setLayout(null);
		panel_1_5.setBounds(563, 232, 423, 61);
		contentPane.add(panel_1_5);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 17, 59, 30);
		panel_1_5.add(lblAno);
		lblAno.setForeground(new Color(255, 255, 255));
		lblAno.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		MaskFormatter mascaraAno = null;
		try {
			mascaraAno = new MaskFormatter("####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtAno = new JFormattedTextField(mascaraAno);

		txtAno.setColumns(10);
		txtAno.setBounds(153, 17, 260, 30);
		panel_1_5.add(txtAno);
		
		JLabel lblNewLabel_7_2_2 = new JLabel("");
		lblNewLabel_7_2_2.setBounds(0, 0, 423, 61);
		panel_1_5.add(lblNewLabel_7_2_2);
		lblNewLabel_7_2_2.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_2_2.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1_6 = new JPanel();
		panel_1_6.setForeground(new Color(255, 255, 255));
		panel_1_6.setBackground(new Color(0, 85, 125));
		panel_1_6.setLayout(null);
		panel_1_6.setBounds(98, 413, 423, 61);
		contentPane.add(panel_1_6);
		
		MaskFormatter formatter111 = null;
		try {
			formatter111 = new MaskFormatter("R$ ###.###.###,##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		 txtPreco_1 = new JTextField(8); 
		 txtPreco_1.setDocument(new MonetarioDocument());
		 
		
		txtPreco_1.setBounds(152, 20, 261, 30);
		panel_1_6.add(txtPreco_1);
		txtPreco_1.setColumns(10);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(10, 17, 67, 30);
		panel_1_6.add(lblPreco);
		lblPreco.setForeground(new Color(255, 255, 255));
		lblPreco.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		
		JLabel lblNewLabel_7_4 = new JLabel("");
		lblNewLabel_7_4.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_7_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_4.setBounds(0, 0, 423, 61);
		panel_1_6.add(lblNewLabel_7_4);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se uma linha foi selecionada na tabela
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um funcionário na tabela para atualizar.");
					return;
				}
				// Obtém os valores da linha selecionada
				Integer id = (Integer) table.getValueAt(selectedRow, 0);
				String Cor = (String) table.getValueAt(selectedRow, 1);
				String modelo = (String) table.getValueAt(selectedRow, 2);
				String marca = (String) table.getValueAt(selectedRow, 3);
				long ano = (long) table.getValueAt(selectedRow, 4);
				long quantidade = (long) table.getValueAt(selectedRow, 5);
				String dataEntrada = (String) table.getValueAt(selectedRow, 6);
				long preco = (long) table.getValueAt(selectedRow, 7);
				// Converte a data de Entrada para o formato correto
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate DataEntrada = LocalDate.parse(dataEntrada, formato);
				Fornecedor f = (Fornecedor) comboBox.getSelectedItem();
				
				// Preenche o objeto Karts com os valores da linha selecionada
				Karts karts = new Karts();
				karts.setCor(Cor);
				karts.setModelo(modelo);
				karts.setMarca(marca);
				karts.setano(ano);
				karts.setquantidade(quantidade);
				karts.setDataEntrada(DataEntrada);
				karts.setpreco(preco);
				karts.setId(id);
				karts.setCNPJ(f.getCnpj());
				
				EditarKartsDialog dialog = new EditarKartsDialog(karts);
				dialog.setVisible(true);
				
				if (dialog.isInformacoesAlteradas()) {
					karts = dialog.getkartsAtualizado();
					
					KartsDAO dao = KartsDAO.getinstancia();
					boolean retorno = dao.Alterar(karts);
					
					if (retorno) {
						new MensagemAcerto("Karts atualizado com sucesso!").setVisible(true);
						// Atualiza a tabela após a alteração
						
						atualizarTabela();
					}else {
						new MensagemErro("Erro ao atualizar o Karts. !").setVisible(true);

					}
				}
			 }
			//}
			});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnAlterar.setBackground(Color.BLACK);
		btnAlterar.setBounds(692, 556, 271, 41);
		contentPane.add(btnAlterar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/kart1.2.png")));
		lblNewLabel_1.setBounds(50, 822, 300, 171);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Kart");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 50));
		lblNewLabel_3.setBounds(259, 865, 176, 77);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaKarts.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_2.setBounds(-11, 0, 1946, 1061);
		contentPane.add(lblNewLabel_2);
	}

	private void atualizarTabela() {

		dao = KartsDAO.getinstancia();
		ArrayList<Karts> karts = dao.listar();

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID_kart", "cor", "Modelo", "Marca", "Ano",
				"Quantidade", "Data_Entrada", "Preço", "fornecedor_CNPJ" });

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (Karts Karts : karts) {

			Object[] linha = { Karts.getId(), Karts.getCor(), Karts.getModelo(), Karts.getMarca(), Karts.getano(),
					Karts.getquantidade(), Karts.getDataEntrada().format(formato), Karts.getpreco(), Karts.CNPJ() };
			

			modelo.addRow(linha);

		}
		table.setModel(modelo);
		
	}


}