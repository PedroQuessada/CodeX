package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.Endereco;

public class EnderecoDAO {
	
	
	/**
     * CRUD: Insere Endereco
     * @param conn: Connection
     */
	public void createEndereco(Endereco endereco) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "INSERT INTO Endereco (rua, numero, cep, bairro, estado, cidade, pais, complemento, observacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, endereco.getRua());
			stm.setInt(2, endereco.getNumero());
			stm.setInt(3, endereco.getCep());
			stm.setString(4, endereco.getBairro());
			stm.setString(5, endereco.getEstado());
			stm.setString(6, endereco.getCidade());
			stm.setString(7, endereco.getPais());
			stm.setInt(8, endereco.getComplemento());
			stm.setString(9, endereco.getObservacao());
			
			int affectedRows = stm.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Criação das informacaoes falhou. Nenhuma linha criada");
	        }

	        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	        	if (generatedKeys.next()) endereco.setId((int) generatedKeys.getLong(1));
	        	else throw new SQLException("Criação das informacaoes falhou. Nenhum id criado");
	        }
	        
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
     * CRUD: Atualiza Endereco
     * @param conn: Connection
     */
	public void updateEndereco(Endereco endereco) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "UPDATE endereco SET rua = ?, numero = ?, cep = ?, bairro = ?, estado = ?, cidade = ? pais = ?, complemento = ?, observacao = ? WHERE id = ?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, endereco.getRua());
			stm.setInt(2, endereco.getNumero());
			stm.setInt(3, endereco.getCep());
			stm.setString(4, endereco.getBairro());
			stm.setString(5, endereco.getEstado());
			stm.setString(6, endereco.getCidade());
			stm.setString(7, endereco.getPais());
			stm.setInt(8, endereco.getComplemento());
			stm.setString(9, endereco.getObservacao());
			stm.setInt(10, endereco.getId());
			
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
     * CRUD: Deleta endereco
     * @param conn: Connection
     */
	public void deleteEndereco(int id) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "DELETE FROM endereco WHERE id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, id);
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Carrega dados do endereco
     * @param conn: Connection
     */
	
	public Endereco loadEndereco(int id) {
		Endereco endereco = new Endereco();
		Connection conn = new ConnectionFactory().getConnection();
		String sqlInsert = "SELECT rua, numero, cep, bairro, estado, cidade, pais, complemento, observacao FROM endereco WHERE id =?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				endereco.setId(id);
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setCep(rs.getInt("cep"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setPais(rs.getString("pais"));
				endereco.setComplemento(rs.getInt("complemento"));
				endereco.setEstado(rs.getString("observacao"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return endereco;
	}
	
}
