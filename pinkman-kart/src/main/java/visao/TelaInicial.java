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
		setBounds(100, 100, 1056, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(3, 175, 175));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane
				.setLayout(new MigLayout("", "[grow][53px][221px,grow][grow]", "[grow][grow][24px][24px][23px,grow]"));

		Icon logoPinkmanKart = new ImageIcon("imgs/PinkmanKartLogo.png");
		JLabel lblLogoPinkmanKart = new JLabel("");
		lblLogoPinkmanKart.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/PinkmanKartLogo.png")));
		contentPane.add(lblLogoPinkmanKart, "cell 2 1,alignx center");

		JLabel txtLog = new JLabel("Login:");
		txtLog.setForeground(Color.WHITE);
		txtLog.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		contentPane.add(txtLog, "cell 1 2,alignx left,aligny top");

		JLabel txtSe = new JLabel("Senha:");
		txtSe.setForeground(Color.WHITE);
		txtSe.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		contentPane.add(txtSe, "flowy,cell 1 3,alignx trailing,aligny top");

		textLogin = new JTextField();
		textLogin.setForeground(new Color(0, 0, 0));
		textLogin.setBackground(new Color(230, 242, 242));
		contentPane.add(textLogin, "cell 2 2,growx,aligny bottom");
		textLogin.setColumns(10);

		JButton btnEntrar = new JButton("Logar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		btnEntrar.setBackground(new Color(0, 0, 0));
		textSenha = new JPasswordField();
		contentPane.add(textSenha, "cell 2 3,growx,aligny bottom");
		contentPane.add(btnEntrar, "cell 2 4,growx,aligny top");

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
					Connection conn = con.conectar();
					con.conectar();

					new MensagemAcerto("Você entrou com sucesso!").setVisible(true);

				} else {
					new MensagemErro("Usuário ou senha incorretos!").setVisible(true);

				}
			}
		});
	}

}
