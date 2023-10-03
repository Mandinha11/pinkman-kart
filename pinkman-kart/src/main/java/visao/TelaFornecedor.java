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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.ClienteDAO;
import controle.FornecedorDAO;
import modelo.Cliente;
import modelo.Fornecedor;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCNPJ;
	private JTextField txtTelefone;
	private JTextField txtNomeEmpresa;
	private JTextField txtCEP;
	private JTable table_1;
	private FornecedorDAO fornecedorDAO;
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
		setTitle("Fornecedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1162);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(167, 10, 10));
		btnVoltar.setForeground(new Color(255, 255, 255));
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
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnCadastrar.setBounds(1687, 293, 210, 42);
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Fornecedor fornecedor = new Fornecedor();

				String text = txtCEP.getText();
				
				if (text.trim().length() == 0) {
					new MensagemErro("CEP não preenchido !").setVisible(true);
					return;
				} else {
					text = text.replace("-", "");
					text = text.trim();
					
					fornecedor.setCep(Long.valueOf(text));

				}
				String tel = txtTelefone.getText();
				if (tel.trim().length() == 0) {
					new MensagemErro("Telefone não preenchido !").setVisible(true);
					return;
				} else {
					tel = tel.replace("-", "");
					tel = tel.replace(" ", "");
					tel = tel.replace("(", "");
					tel = tel.replace(")", "");
					tel = tel.trim();

					fornecedor.setTelefone(Long.valueOf(tel));

				}

				String cnpj = txtCNPJ.getText();
				if (cnpj.trim().length() == 0) {
					new MensagemErro("CNPJ não preenchido !").setVisible(true);
					return;
				} else {
					cnpj = cnpj.replace("/", "");
					cnpj = cnpj.replace(".", "");
					cnpj = cnpj.replace("-", "");
					cnpj = cnpj.trim();

					fornecedor.setCnpj(Long.valueOf(cnpj));

				}

				if (txtNomeEmpresa.getText().trim().length() == 0) {
					new MensagemErro("Empresa não preenchido !").setVisible(true);
					return;
				} else {
					fornecedor.setNomeEmpresa(txtNomeEmpresa.getText());
				}

				FornecedorDAO fornecedorDao = FornecedorDAO.getinstancia();
				if (fornecedorDao.inserir(fornecedor) == true) {
					new MensagemAcerto("Cadastrado !").setVisible(true);
					atualizarTabela();
				} else {
					new MensagemErro("Não foi possivel cadastrar !").setVisible(true);
				}

			}

		});
		contentPane.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnAtualizar.setBounds(1687, 135, 210, 42);
		btnAtualizar.setBackground(new Color(0, 0, 0));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se uma linha foi selecionada na tabela
		        int selectedRow = table_1.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Selecione um fornecedor na tabela para atualizar.");
		            return;
		        }

		        // Obtém os valores da linha selecionada
		        
		        String nome_empresa = (String) table_1.getValueAt(selectedRow, 0);
		        Long cep = (long) table_1.getValueAt(selectedRow, 1);
		        Long cnpj = (long) table_1.getValueAt(selectedRow, 2);
		        Long telefone = (long) table_1.getValueAt(selectedRow, 3);
		        
		        // Preenche o objeto Cliente com os valores da linha selecionada
		        Fornecedor fornecedor = new Fornecedor();
		       
		        fornecedor.setNomeEmpresa(nome_empresa);
		        fornecedor.setCep(cep);
		        fornecedor.setCnpj(cnpj);
		        fornecedor.setTelefone(telefone);
		        
		        EditarFornecedorDialog dialog = new EditarFornecedorDialog(fornecedor);
		        dialog.setVisible(true);

		        
		        if (dialog.isInformacoesAlteradas()) {
		         
		            fornecedor = dialog.getFornecedorAtualizado();
		           
		            FornecedorDAO dao = FornecedorDAO.getinstancia();
		            boolean retorno = dao.alterar(fornecedor);

		            if (retorno) {
		            	new MensagemAcerto("Fornecedor atualizado com sucesso!").setVisible(true);
		              
		                // Atualiza a tabela após a alteração
		                atualizarTabela();
		            } else {
		            	new MensagemErro("Erro ao atualizar o Fornecedor. !").setVisible(true);
		            
		            }
		        }
		    }

		});
		contentPane.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();

				long cnpj = (long) table_1.getValueAt(selectedRow, 3);

				FornecedorDAO dao = FornecedorDAO.getinstancia();

				Fornecedor f = new Fornecedor();
				f.setCnpj(cnpj);
				boolean retorno = dao.Deletar(f);

				if (retorno == true) {
					// Remove a linha selecionada
					DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
					tableModel.removeRow(selectedRow);
					new MensagemAcerto("Excluido com sucesso !").setVisible(true);

				} else {
					new MensagemErro("Não foi possivel excluir!").setVisible(true);
				}

			}
		});
		btnExcluir.setBounds(1689, 213, 208, 42);
		btnExcluir.setBackground(new Color(0, 0, 0));
		contentPane.add(btnExcluir);

		JPanel panel = new JPanel();
		panel.setBounds(25, 135, 1616, 855);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 85, 125));
		panel_1.setBounds(513, 12, 513, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setBounds(156, 11, 335, 28);
		panel_1.add(txtNomeEmpresa);
		txtNomeEmpresa.setColumns(10);

		JLabel lblNomeEmpresa = new JLabel("Nome da empresa:");
		lblNomeEmpresa.setBackground(new Color(255, 255, 255));
		lblNomeEmpresa.setBounds(5, 11, 141, 28);
		panel_1.add(lblNomeEmpresa);
		lblNomeEmpresa.setForeground(new Color(255, 255, 255));
		lblNomeEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 85, 125));
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
		lblCnpj.setForeground(new Color(255, 255, 255));
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(0, 85, 125));
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
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(0, 85, 125));
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
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 17));

		table_1 = new JTable();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 0 4 6 8,grow");
		panel.add(table_1);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome da Empresa", "CNPJ", "CEP", "Telefone" });
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "Nome da empresa","CNPJ", "CEP","Telefone"
			}
		));

		atualizarTabela();

		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
				
				String tblnome_empresa = tblModel.getValueAt(table_1.getSelectedRow(),0).toString();
				String tblcep = tblModel.getValueAt(table_1.getSelectedRow(),1).toString();
				String tbltelefone = tblModel.getValueAt(table_1.getSelectedRow(),2).toString();
				String tblcnpj = tblModel.getValueAt(table_1.getSelectedRow(),3).toString();
				txtNomeEmpresa.setText(tblnome_empresa);
				txtTelefone.setText(tbltelefone);
				txtCEP.setText(tblcep);
				txtCNPJ.setText(tblcnpj);
				
				
			}
		});
		panel.add(scrollPane_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFornecedor.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel.setBounds(0, 0, 1924, 1061);
		contentPane.add(lblNewLabel);

	}

	protected void limparCampos() {
		txtNomeEmpresa.setText("");
		txtCNPJ.setText("");
		txtCEP.setText("");
		txtTelefone.setText("");

	}

	public void atualizarTabela() {

		fornecedorDAO = FornecedorDAO.getinstancia();
		ArrayList<Fornecedor> fornecedor = fornecedorDAO.Listar();

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] {"Nome Empresa", "CEP", "CNPJ", "Telefone" });


		for (Fornecedor f : fornecedor) {
			Object[] linha = {f.getNomeEmpresa(), f.getCep(), f.getCnpj(),
					f.getTelefone()};
			modelo.addRow(linha);

		}
		table_1.setModel(modelo);
	}
}
