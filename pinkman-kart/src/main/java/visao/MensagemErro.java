package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MensagemErro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MensagemErro frame = new MensagemErro(null);
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
	public MensagemErro(String msg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-200, 25, 477, 280);
		lblNewLabel.setIcon(new ImageIcon(MensagemErro.class.getResource("/imgs/Atenção.png")));
		contentPane.add(lblNewLabel);

		JLabel lblMsgErro = new JLabel("");
		lblMsgErro.setBounds(293, 94, 318, 104);
		lblMsgErro.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		lblMsgErro.setForeground(new Color(255, 255, 255));
		contentPane.add(lblMsgErro);

		if (!msg.isEmpty()) {
			lblMsgErro.setText(msg);
		}

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(355, 209, 189, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		contentPane.add(btnOk);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
