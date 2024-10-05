package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conclusao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Conclusao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SeBuy");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 99));
		lblNewLabel_1.setForeground(new Color(53, 154, 255));
		lblNewLabel_1.setBounds(80, 146, 716, 172);
		contentPane.add(lblNewLabel_1);
		
		JButton bMenu = new JButton("Menu");
		bMenu.setBackground(SystemColor.control);
		bMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		bMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPrincipal c = new JPrincipal();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				dispose();
			}
		});
		bMenu.setBounds(385, 341, 96, 25);
		contentPane.add(bMenu);
		
		JLabel lblNewLabel = new JLabel("Agradecemos pela preferência!!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(317, 293, 237, 25);
		contentPane.add(lblNewLabel);
		
	}

}
