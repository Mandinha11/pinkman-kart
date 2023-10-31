package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MensagemAcerto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MensagemAcerto frame = new MensagemAcerto(null);
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
	public MensagemAcerto(String msg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 327);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-232, 11, 563, 272);
		lblNewLabel.setIcon(new ImageIcon(MensagemAcerto.class.getResource("/imgs/Acerto.png")));
		contentPane.add(lblNewLabel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(0, 0, 0));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnOk.setBounds(358, 172, 195, 32);
		contentPane.add(btnOk);
		
		
		JLabel lblMsgAcerto = new JLabel("");
		lblMsgAcerto.setForeground(new Color(255, 255, 255));
		lblMsgAcerto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lblMsgAcerto.setBounds(278, 84, 357, 60);
		contentPane.add(lblMsgAcerto);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MensagemAcerto.class.getResource("/imgs/azulFundo.png")));
		lblNewLabel_1.setBounds(-23, 0, 714, 377);
		contentPane.add(lblNewLabel_1);
		
		if (!msg.isEmpty()) {
			lblMsgAcerto.setText(msg);
		
	}
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
