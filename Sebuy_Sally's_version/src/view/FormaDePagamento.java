package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Mercado;
import model.ModeloTabelaNotaFiscal;
//import model.NotaFiscal;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
import java.awt.event.ActionEvent;

public class FormaDePagamento extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FormaDePagamento() {
		
		Mercado mercado = new Mercado();
		
		setSize(910, 602);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(21, 138, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Forma de pagamento");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel_1.setBounds(48, 37, 921, 93);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 338, 610, 50);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"codigo", "valorTotal", "hora", "dia", "CNPJ", "idCompra", "formaDePagamento"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(FormaDePagamento.class.getResource("/imagens/carrinho-virado2 (1).png")));
		lblNewLabel_2.setBounds(554, 338, 356, 291);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(48, 141, 429, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Aceitamos dinheiro, crédito ou débito");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(48, 172, 367, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nota Fiscal");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel_4.setBounds(48, 260, 373, 50);
		panel.add(lblNewLabel_4);
		
		JButton bConcluir = new JButton("Concluir");
		bConcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		bConcluir.setBackground(SystemColor.control);
		bConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conclusao c = new Conclusao();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				dispose();
			}
		});
		//bConcluir.setBounds(357, 471, 120, 23);
		panel.add(bConcluir);
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(mercado.finalizarCompra(textField.getText())) {
					JOptionPane.showMessageDialog(btnNewButton, "Compra realizada!");
					bConcluir.setBounds(357, 471, 120, 23);
					btnNewButton.setBounds(0, 0, 0, 0);
					ModeloTabelaNotaFiscal modeloTabelaNotaFiscal = new ModeloTabelaNotaFiscal(mercado.gerarNotaFiscal());
					table.setModel(modeloTabelaNotaFiscal);
				}
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(519, 141, 139, 20);
		panel.add(btnNewButton);
		
		
	}
}
