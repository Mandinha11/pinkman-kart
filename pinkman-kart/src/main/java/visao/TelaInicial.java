package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.Conexao;
import controle.LoginDao;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class TelaInicial extends JFrame {

	protected static final JTextField String = null;
	protected static final JTextField Empty = null;
	private JPanel contentPane;
	private JTextField textLogin;
	private JLabel lblLogoPinkmanKart;
	private JPasswordField textSenha;

	/**
	 * public void run() { JFrame frame = new JFrame("Tela de Login");
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.getContentPane().add(new TelaInicial()); frame.pack();
	 * frame.setVisible(true); } });
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2093, 1169);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(81, 162, 162));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		//Icon logoPinkmanKart = new ImageIcon("imgs/PinkmanKartLogo.png");
		contentPane.setLayout(null);
		JLabel lblLogoPinkmanKart = new JLabel("");
		lblLogoPinkmanKart.setBounds(718, 433, 512, 180);
		lblLogoPinkmanKart.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/PinkmanKartLogo.png")));
		contentPane.add(lblLogoPinkmanKart);

		JLabel txtLog = new JLabel("Login:");
		txtLog.setBounds(608, 637, 56, 27);
		txtLog.setForeground(Color.WHITE);
		txtLog.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		contentPane.add(txtLog);

		JLabel txtSe = new JLabel("Senha:");
		txtSe.setBounds(603, 667, 61, 27);
		txtSe.setForeground(Color.WHITE);
		txtSe.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		contentPane.add(txtSe);

		textLogin = new JTextField();
		textLogin.setBounds(674, 645, 637, 20);
		textLogin.setForeground(new Color(0, 0, 0));
		textLogin.setBackground(new Color(230, 242, 242));
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JButton btnEntrar = new JButton("Logar");
		btnEntrar.setMnemonic(KeyEvent.VK_ENTER);
		btnEntrar.setBounds(674, 706, 637, 31);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		btnEntrar.setBackground(new Color(0, 0, 0));
		textSenha = new JPasswordField();
		textSenha.setBounds(674, 675, 637, 20);
		contentPane.add(textSenha);
		contentPane.add(btnEntrar);

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textLogin.getText();
				Long senha = Long.valueOf(new String(textSenha.getPassword())); // Obtenha a senha como uma String

				LoginDao loginDao = new LoginDao();
				boolean autenticado = loginDao.autenticarLogin(login, senha);

				if (autenticado) {
					dispose();
					TelaSelecao tela = new TelaSelecao();
					tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
					tela.setVisible(true);
					Conexao con = Conexao.getInstancia();
					//Connection conn = con.conectar();
					con.conectar();

					new MensagemAcerto("Você entrou com sucesso!").setVisible(true);

				} else {
					new MensagemErro("Usuário ou senha incorretos!").setVisible(true);

				}
			}
		});
	}
}
