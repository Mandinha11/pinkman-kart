package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Conexao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.SystemColor;

public class TelaSelecao extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaSelecao() {

		Conexao con = Conexao.getInstancia();
		Connection conn = con.conectar();
		setTitle("Seleção");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2217, 1100);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.setBackground(new Color(167, 10, 10));
		btnVoltar.setBounds(10, 23, 109, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial ti = new TelaInicial();
				ti.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ti.setVisible(true);
				con.fecharConexao();
				if (con.fecharConexao() == true) {
					new MensagemAcerto("Logout efetuado com sucesso!").setVisible(true);

				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(594, 177, 308, 265);
		panel_1.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBackground(new Color(0, 0, 0));
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBounds(52, 159, 206, 46);
		panel_1.add(btnCliente);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaCliente tc = new TelaCliente();
				tc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tc.setVisible(true);
			}
		});
		btnCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/Cliente.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(71, 34, 154, 114);
		panel_1.add(lblNewLabel_1);
		
		JLabel painel_cliente = new JLabel("");
		painel_cliente.setHorizontalAlignment(SwingConstants.RIGHT);
		painel_cliente.setVerticalAlignment(SwingConstants.BOTTOM);
		painel_cliente.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/fundoAzul.jpg")));
		painel_cliente.setBounds(0, 0, 308, 265);
		panel_1.add(painel_cliente);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(1006, 177, 308, 265);
		panel_1_1.setBackground(new Color(0, 128, 192));
		panel_1_1.setLayout(null);
		contentPane.add(panel_1_1);

		JButton btnKarts = new JButton("Karts");
		btnKarts.setForeground(new Color(255, 255, 255));
		btnKarts.setBackground(new Color(0, 0, 0));
		btnKarts.setBounds(46, 160, 206, 46);
		panel_1_1.add(btnKarts);
		btnKarts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaKarts tk = new TelaKarts();
				tk.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tk.setVisible(true);

			}
		});
		btnKarts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/kart1.2.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(77, 44, 149, 89);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel painel_kart = new JLabel("");
		painel_kart.setHorizontalAlignment(SwingConstants.RIGHT);
		painel_kart.setVerticalAlignment(SwingConstants.BOTTOM);
		painel_kart.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/fundoAzul.jpg")));
		painel_kart.setBounds(0, 0, 308, 265);
		panel_1_1.add(painel_kart);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(429, 481, 308, 265);
		panel_1_2.setBackground(new Color(0, 128, 192));
		panel_1_2.setLayout(null);
		contentPane.add(panel_1_2);

		JButton btnVendas = new JButton("Vendas");
		btnVendas.setForeground(new Color(255, 255, 255));
		btnVendas.setBackground(new Color(0, 0, 0));
		btnVendas.setBounds(55, 147, 206, 43);
		panel_1_2.add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaVendas tv = new TelaVendas();
				tv.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tv.setVisible(true);

			}
		});
		btnVendas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(42, 23, 206, 167);
		panel_1_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/CarrinhoDeCompras.png")));
		
		JLabel painel_vendas = new JLabel("");
		painel_vendas.setHorizontalAlignment(SwingConstants.RIGHT);
		painel_vendas.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/fundoAzul.jpg")));
		painel_vendas.setVerticalAlignment(SwingConstants.BOTTOM);
		painel_vendas.setBounds(0, 0, 308, 265);
		panel_1_2.add(painel_vendas);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(816, 481, 308, 265);
		panel_1_3.setBackground(new Color(0, 128, 192));
		panel_1_3.setLayout(null);
		contentPane.add(panel_1_3);

		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setForeground(new Color(255, 255, 255));
		btnFornecedor.setBounds(59, 145, 206, 47);
		panel_1_3.add(btnFornecedor);
		btnFornecedor.setBackground(new Color(0, 0, 0));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaFornecedor tf = new TelaFornecedor();
				tf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tf.setVisible(true);
			}
		});
		btnFornecedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/fornec.png")));
		lblNewLabel_2.setBounds(24, 27, 260, 165);
		panel_1_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/fundoAzul.jpg")));
		lblNewLabel_6.setBounds(0, 0, 329, 265);
		panel_1_3.add(lblNewLabel_6);

		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setBackground(new Color(0, 128, 192));
		panel_1_3_1.setBounds(1213, 481, 308, 265);
		contentPane.add(panel_1_3_1);
		panel_1_3_1.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(64, 24, 172, 104);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1_3_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(81, 24, 172, 110);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/Funcionario2.png")));
		panel_1_3_1.add(lblNewLabel_4);

		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setForeground(new Color(255, 255, 255));
		btnFuncionario.setBackground(new Color(0, 0, 0));
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaFuncionario tf = new TelaFuncionario();
				tf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tf.setVisible(true);
			}
		});
		btnFuncionario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnFuncionario.setBounds(61, 145, 206, 47);
		panel_1_3_1.add(btnFuncionario);
		
		JLabel painel_funcionario = new JLabel("");
		painel_funcionario.setHorizontalAlignment(SwingConstants.RIGHT);
		painel_funcionario.setVerticalAlignment(SwingConstants.BOTTOM);
		painel_funcionario.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/fundoAzul.jpg")));
		painel_funcionario.setBounds(0, 0, 308, 265);
		panel_1_3_1.add(painel_funcionario);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_5.setBounds(0, -19, 1939, 1080);
		contentPane.add(lblNewLabel_5);
	}
}
