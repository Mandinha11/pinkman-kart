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
import modelo.Cliente;

public class TelaCliente extends JFrame {

	
	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textCPF;
	private JTextField textTelefone;
	private JTable table;
	private ClienteDAO clienteDAO;
	private DefaultTableModel modelo;
	private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	private JComboBox<String> boxDia;
	private JComboBox<String> boxMes;
	private JComboBox<Integer> boxAno;
	

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
		 
	        
	    JButton BntCadastra = new JButton("Cadastrar");
	    BntCadastra.setForeground(new Color(255, 255, 255));
	    BntCadastra.setBackground(new Color(0, 0, 0));
		BntCadastra.setBounds(51, 218, 242, 57);
		BntCadastra.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		BntCadastra.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			    String nomeCompleto = textNomeCompleto.getText();
			    Long cpf = Long.valueOf(textCPF.getText());
			    			    
			    // Converter a data de nascimento de String para LocalDate
			    int dia = Integer.valueOf((String) boxDia.getSelectedItem());
			    int mes = Integer.valueOf((String) boxMes.getSelectedItem());
			    int ano = (Integer) boxAno.getSelectedItem();
			    Long telefone = Long.valueOf(textTelefone.getText());
			    
			    LocalDate dataNac = LocalDate.of(dia, mes,ano);
			    
			    Cliente cliente = new Cliente(nomeCompleto, cpf, dataNac, telefone);
			    clienteDAO = ClienteDAO.getinstancia();

			    
			    boolean info = clienteDAO.inserir(cliente);

			    if (info) {
			        atualizarTabela();
			        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			        limparCampos();
			    } else {
			        JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
			    }
			}
		})	;
		
		contentPane.setLayout(null);
		contentPane.add(BntCadastra);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
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
		panel.setBackground(new Color(47, 79, 79));
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
		panel_1.setBackground(new Color(47, 79, 79));

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
		panel_2.setBackground(new Color(47, 79, 79));
		contentPane.add(panel_2);
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento:");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 11, 191, 25);
		panel_2.add(lblNewLabel_2);

		boxDia = new JComboBox<>();
		boxDia.setBounds(198, 11, 62, 25);
		for (int i = 1; i <= 31; i++) {
		    boxDia.addItem(String.format("%02d", i));
		}
		panel_2.add(boxDia);

		JLabel lblNewLabel_5 = new JLabel("Mês");
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(270, 8, 47, 27);
		panel_2.add(lblNewLabel_5);

		boxMes = new JComboBox<>();
		boxMes.setBounds(309, 11, 59, 25);
		for (int i = 1; i <= 12; i++) {
		    boxMes.addItem(String.format("%02d", i));
		}
		panel_2.add(boxMes);

		JLabel lblNewLabel_6 = new JLabel("Ano");
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(378, 10, 47, 22);
		panel_2.add(lblNewLabel_6);

		boxAno = new JComboBox<>();
		boxAno.setBounds(415, 11, 81, 25);
		for (int i = 1923; i <= 2023; i++) {
		    boxAno.addItem(i);
		}
		panel_2.add(boxAno);
		JLabel lblDataNasc = new JLabel("Data De Nascimento:");
		lblNewLabel_2.setBounds(10, 11, 191, 25);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(1048, 107, 506, 45);
		panel_1_1.setLayout(null);
		panel_1_1.setToolTipText("");
		panel_1_1.setBackground(new Color(47, 79, 79));
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
		panel_3.setBounds(354, 223, 1461, 772);
		contentPane.add(panel_3);

		/**
		 * Tabela
		 */
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(new BorderLayout());
		panel_3.add(new JScrollPane(table), BorderLayout.CENTER);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome Completo", "CPF", "Data Nasc", "Telefone" });
		table.setModel(modelo);

		atualizarTabela();

		JButton btnListar = new JButton("Alterar");
		btnListar.setBackground(new Color(0, 0, 0));
		btnListar.setForeground(new Color(255, 255, 255));
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String nomeEmpresa = (String) table.getValueAt(selectedRow, 0);
            String cpf = (String) table.getValueAt(selectedRow, 1);
            String dataNasc = (String) table.getValueAt(selectedRow, 2);
            String telefone = (String) table.getValueAt(selectedRow, 3);

            System.out.println("Valores da linha selecionada:");
            System.out.println("Nome da Empresa: " + nomeEmpresa);
            System.out.println("CPF: " + cpf);
            System.out.println("Data de Nascimento: " + dataNasc);
            System.out.println("Telefone: " + telefone);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        }
    }
});
		btnListar.setBounds(51, 319, 242, 57);
		btnListar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		contentPane.add(btnListar);

		
		//Amanda
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBackground(new Color(0, 0, 0));
		btnExcluir.addActionListener(new ActionListener() {
            @Override
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

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaCliente.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_7.setBounds(0, 0, 1924, 1061);
		contentPane.add(lblNewLabel_7);

	}
	
	protected void limparCampos() {
		textNomeCompleto.setText("");
		textCPF.setText("");
		textTelefone.setText("");
		
	}

	public void atualizarTabela() {

		 	clienteDAO = ClienteDAO.getinstancia();
			ArrayList<Cliente> clientes = clienteDAO.listar();

	        modelo = new DefaultTableModel(new Object[][] {},
	                new String[] { "Nome Completo", "CPF", "Data Nasc", "Telefone" });
	        table.setModel(modelo);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        for (Cliente cliente : clientes) {
	            Object[] linha = { cliente.getNomeCompleto(), cliente.getCpf(), cliente.getDataNac().format(formatter),
	                    cliente.getTelefone() };
	            modelo.addRow(linha);
	        }
	}
}
