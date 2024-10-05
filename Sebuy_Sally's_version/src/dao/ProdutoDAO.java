package dao; 

import java.awt.Component;
import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import java.util.ArrayList;

public class ProdutoDAO{
	
	private Connection conn;
	private Component bBuscar;

	public ProdutoDAO() {
		
		this.conn = null;
		String url = "jdbc:mysql://localhost/SistemaCaixa";
		String user = "root";
		String password = "0000";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados estabelecida com sucesso");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//CRUD - CREATE 
	public boolean inserir(Produto produto) {
		String sql = "INSERT INTO Produto(nome, valor) VALUES(?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.execute();

			return true;
      
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	//CRUD - READ
	public List<Produto> listar(){
		List<Produto>listarProdutos = new ArrayList<Produto>();
		String sq1 = "SELECT * FROM produto";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sq1);
			ResultSet rs = ps.executeQuery(sq1);
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				double valor = rs.getDouble("valor");
				String nome = rs.getString("nome");
				
				Produto produto = new Produto(nome,valor,codigo);
				listarProdutos.add(produto);
			}
			return listarProdutos;
		} catch(SQLException e) {
			e.printStackTrace();
			return listarProdutos;
		}
	}
  
	//CRUD - UPDATE
	public boolean atualizar(String novoNome, double novoValor, int codigo) {
		String sql = "UPDATE Produto SET nome = ?, valor = ? WHERE codigo = ?";
		
		try {		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, novoNome);
			ps.setDouble(2, novoValor);
			ps.setInt(3, codigo);
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
  
	//CRUD - DELETE 
	public boolean deletar(int codigo) {
		String sql = "DELETE FROM Produto WHERE codigo = ?";
	  
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
		  
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
		  
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
	  	}
	}
  
	public Produto buscarPorCodigo(int busca) {   //metodo para buscar um determinado produto pelo codigo.
		String sql = "SELECT * FROM Produto WHERE codigo = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, busca);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				double valor = rs.getDouble("valor");
				
				Produto produto = new Produto(nome, valor, codigo);
				return produto;
			}else {
				JOptionPane.showMessageDialog(bBuscar, "Produto não encontrado!");
				return null;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}  
	}	
	
	public List<Produto> buscarPorNome(String busca) {
		List<Produto>listarProdutos = new ArrayList<Produto>();
		String sq1 = "SELECT * FROM produto WHERE nome = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sq1);
			ps.setString(1, busca);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int codigo = rs.getInt("codigo");
				double valor = rs.getDouble("valor");
				String nome = rs.getString("nome");
				
				Produto produto = new Produto(nome,valor,codigo);
				listarProdutos.add(produto);
				
				return listarProdutos;
			}else {
				JOptionPane.showMessageDialog(bBuscar, "Produto não encontrado!");
				  return this.listar();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public double getValor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
