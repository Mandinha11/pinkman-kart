package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecao max = new TelaSelecao();
					max.setExtendedState(JFrame.MAXIMIZED_BOTH);
					max.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaSelecao() {
		
		
		setTitle("Seleção");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2217, 1100);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(30, 36, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicial ti = new TelaInicial();
				ti.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ti.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(594, 177, 308, 265);
		panel_1.setBackground(new Color(47, 79, 79));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(new Color(0, 0, 0));
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(1006, 177, 308, 265);
		panel_1_1.setBackground(new Color(47, 79, 79));
		panel_1_1.setLayout(null);
		contentPane.add(panel_1_1);
		
		JButton btnKarts = new JButton("Karts");
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
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(429, 481, 308, 265);
		panel_1_2.setBackground(new Color(47, 79, 79));
		panel_1_2.setLayout(null);
		contentPane.add(panel_1_2);
		
		JButton btnVendas = new JButton("Vendas");
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
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(816, 481, 308, 265);
		panel_1_3.setBackground(new Color(47, 79, 79));
		panel_1_3.setLayout(null);
		contentPane.add(panel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/Cliente.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(65, 24, 172, 104);
		panel_1_3.add(lblNewLabel_2);
		
		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setBounds(59, 145, 206, 47);
		panel_1_3.add(btnFornecedor);
		btnFornecedor.setBackground(UIManager.getColor("Button.background"));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TelaFornecedor tf = new TelaFornecedor();
				tf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tf.setVisible(true);
			}
		});
		btnFornecedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setBackground(new Color(47, 79, 79));
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
		
		JButton btnNewButton = new JButton("Funcionario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TelaFuncionari tf = new TelaFuncionari();
				tf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				tf.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnNewButton.setBounds(61, 145, 206, 47);
		panel_1_3_1.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaSelecao.class.getResource("/imgs/FundoDeTela.jpg")));
		lblNewLabel_5.setBounds(0, 0, 1924, 1061);
		contentPane.add(lblNewLabel_5);
	}
}
