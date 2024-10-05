package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import dao.ProdutoDAO;
import model.ModeloTabelaProduto;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastrados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JTextField textField;
	private JTable table;
//	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	//private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Cadastrados() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(21, 138, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textFieldCadastros = new JTextField();
		textFieldCadastros.setBounds(72, 96, 558, 22);
		contentPane.add(textFieldCadastros);
		textFieldCadastros.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 127, 727, 287);
		contentPane.add(scrollPane);
				
		ProdutoDAO buscar = new ProdutoDAO();
		ModeloTabelaProduto tabelaDeProdutos = new ModeloTabelaProduto(buscar.listar());
		table = new JTable();
		table.setModel(tabelaDeProdutos);
		scrollPane.setViewportView(table);
		
		JButton bBuscar = new JButton("BUSCAR"); // Da erro quando o produto não existe.
		bBuscar.setBackground(SystemColor.control);
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoDigitado = textFieldCadastros.getText();
				
				if(textFieldCadastros.getText()!= null ) {
					
					ProdutoDAO buscar = new ProdutoDAO();
					ModeloTabelaProduto tabelaDeBusca = new ModeloTabelaProduto(buscar.buscarPorNome(textoDigitado));
					table = new JTable();
					table.setModel(tabelaDeBusca);
					scrollPane.setViewportView(table);
				} 
				
				
				
			}
		});
		bBuscar.setBounds(647, 96, 152, 22);
		contentPane.add(bBuscar);
		
		lblNewLabel = new JLabel("Busca pelo nome:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(72, 64, 314, 22);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("SeBuy");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(577, 13, 328, 79);
		contentPane.add(lblNewLabel_1);
		
		JButton bVoltar = new JButton("Voltar");
		bVoltar.setBackground(SystemColor.control);
		bVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bVoltar.setBounds(385, 454, 89, 22);
		contentPane.add(bVoltar);
		bVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JPrincipal c = new JPrincipal(); 
			        c.setVisible(true);
			        c.setLocationRelativeTo(null);
			        dispose();
			}
		});
		
		
	}

}
