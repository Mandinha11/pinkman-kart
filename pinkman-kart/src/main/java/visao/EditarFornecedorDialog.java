package visao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import modelo.Cliente;
import modelo.Fornecedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarFornecedorDialog extends JDialog {
	private Fornecedor fornecedor;
	private boolean informacoesAlteradas = false;

	private JTextField textFieldNomeEmpresa;
	private JTextField textFieldCep;
	private JTextField textFieldTelefone;

	public EditarFornecedorDialog(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;

		setTitle("Editar Fornecedor");
		setSize(400, 200);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel label = new JLabel("Nome empresa:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(0, 0, 200, 50);
		panel.add(label);
		textFieldNomeEmpresa = new JTextField(fornecedor.getNomeEmpresa());
		textFieldNomeEmpresa.setBackground(SystemColor.control);
		textFieldNomeEmpresa.setBounds(200, 11, 190, 39);
		panel.add(textFieldNomeEmpresa);

		JLabel label_1 = new JLabel("Cep:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(0, 50, 200, 50);
		panel.add(label_1);
		/*
		 * MaskFormatter mascaraCEP = null; try { mascaraCEP = new
		 * MaskFormatter("#####-###"); } catch (ParseException e) { e.printStackTrace();
		 * }
		 * 
		 * txtCEP = new JFormattedTextField(mascaraCEP);
		 */
		
		MaskFormatter mascaraCEP = null;
		try {
			mascaraCEP = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// fornecedor.getCep().toString()
		String i = fornecedor.getTelefone().toString();
		textFieldCep = new JFormattedTextField(mascaraCEP);
		textFieldCep.setBackground(SystemColor.control);
		textFieldCep.setBounds(200, 62, 190, 38);
		textFieldCep.setText(i);

		panel.add(textFieldCep);
		
		JLabel label_2 = new JLabel("Telefone:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(0, 100, 200, 50);
		panel.add(label_2);
		textFieldTelefone = new JTextField(fornecedor.getTelefone().toString());
		textFieldTelefone.setBackground(SystemColor.control);
		textFieldTelefone.setBounds(200, 112, 190, 38);
		panel.add(textFieldTelefone);

		setLocationRelativeTo(null);

		setUndecorated(true);

		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBackground(Color.BLACK);
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setBounds(10, 150, 176, 39);
		buttonSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvarAlteracoes();
			}
		});
		panel.add(buttonSalvar);

		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EditarFornecedorDialog.class.getResource("/imgs/alt.jpg")));
		lblNewLabel.setBounds(-71, 0, 471, 200);
		panel.add(lblNewLabel);
	}

	private void salvarAlteracoes() {
		
		String text = textFieldCep.getText();

		if (text.trim().length() == 0) {
			new MensagemErro("CEP não preenchido !").setVisible(true);
			return;
		} else {
			text = text.replace("-", "");
			text = text.trim();

			fornecedor.setCep(Long.valueOf(text));

		}
		
		// Atualiza as informações do funcionário com os novos valores
		fornecedor.setNomeEmpresa(textFieldNomeEmpresa.getText());
		fornecedor.setTelefone(Long.valueOf(textFieldTelefone.getText()));
		//fornecedor.setCep(Long.valueOf(textFieldCep.getText()));

		// Indica que as informações foram alteradas
		informacoesAlteradas = true;

		// Fecha a janela de diálogo
		dispose();
	}

	public boolean isInformacoesAlteradas() {
		return informacoesAlteradas;
	}

	public Fornecedor getFornecedorAtualizado() {
		return fornecedor;
	}

}
