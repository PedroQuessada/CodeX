package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.Endereco;
import model.Produto;

public class ProdutoDAO {

	/**
     * CRUD: Insere Produto
     * @param conn: Connection
     */
	public void createProduto(Produto produto) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "INSERT INTO produto (nome, quantidade, data_entrada, data_saida, valor, custo, descricao, qtd_minomo, pessoa_juridica_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, produto.getNome());
			stm.setInt(2, produto.getQuantidade());
			stm.setDate(3, produto.getDataEntrada());
			stm.setDate(4, produto.getDataSaida());
			stm.setDouble(5, produto.getValor());
			stm.setDouble(6, produto.getCusto());
			stm.setString(7, produto.getDescricao());
			stm.setInt(8, produto.getQtdMinimo());
			stm.setInt(9, produto.getPessoaJuridica().getId());
			
			int affectedRows = stm.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Criação das informacaoes falhou. Nenhuma linha criada");
	        }

	        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	        	if (generatedKeys.next()) produto.setId((int) generatedKeys.getLong(1));
	        	else throw new SQLException("Criação das informacaoes falhou. Nenhum id criado");
	        }
	        
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
     * CRUD: Atualiza Produto
     * @param conn: Connection
     */
	public void updateProduto(Produto produto) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "UPDATE produto SET nome = ?, quantidade = ?, data_entrada= ?, data_saida = ?, valor = ?, custo = ? descricao = ?, qtd_minimo = ?, pessoa_juridica_id = ? WHERE id = ?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, produto.getNome());
			stm.setInt(2, produto.getQuantidade());
			stm.setDate(3, produto.getDataEntrada());
			stm.setDate(4, produto.getDataSaida());
			stm.setDouble(5, produto.getValor());
			stm.setDouble(6, produto.getCusto());
			stm.setString(7, produto.getDescricao());
			stm.setInt(8, produto.getQtdMinimo());
			stm.setInt(9, produto.getPessoaJuridica().getId());
			
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
     * CRUD: Deleta Produto
     * @param conn: Connection
     */
	public void deleteProduto(int id) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "DELETE FROM produto WHERE id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, id);
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Carrega dados do produto
     * @param conn: Connection
     */
	
	public Produto loadProduto(int id) {
		Produto produto = new Produto();
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		Connection conn = new ConnectionFactory().getConnection();
		String sqlInsert = "SELECT nome, quantidade, data_entrada, data_saida, valor, custo, descricao, qtd_minomo, pessoa_juridica FROM produto WHERE id =?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				produto.setId(id);
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setDataEntrada(rs.getDate("data_entrada"));
				produto.setDataSaida(rs.getDate("data_saida"));
				produto.setValor(rs.getDouble("valor"));
				produto.setCusto(rs.getDouble("custo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtdMinimo(rs.getInt("qtd_minimo"));
				produto.setPessoaJuridica(dao.loadPessoaJuridica(rs.getInt("pessoa_juridica_id")));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	
}
