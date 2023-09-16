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
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-232, 11, 563, 272);
		lblNewLabel.setIcon(new ImageIcon(MensagemAcerto.class.getResource("/imgs/Acerto.png")));
		contentPane.add(lblNewLabel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnOk.setBounds(341, 178, 159, 23);
		contentPane.add(btnOk);
		
		
		JLabel lblMsgAcerto = new JLabel("");
		lblMsgAcerto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 28));
		lblMsgAcerto.setBounds(278, 84, 328, 60);
		contentPane.add(lblMsgAcerto);
		
		if (!msg.isEmpty()) {
			lblMsgAcerto.setText(msg);
		
	}
	}
}
