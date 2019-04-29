package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.Cliente;
import model.Endereco;

public class ClienteDAO {

	/**
     * CRUD: Insere cliente
     * @param conn: Connection
     */
	public void createCliente(Cliente cliente) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "INSERT INTO Cliente (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getTelefone());
			stm.setString(3, cliente.getEmail());
			stm.setInt(4, cliente.getEndereco().getId());

			int affectedRows = stm.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Criação das informacaoes falhou. Nenhuma linha criada");
	        }

	        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	        	if (generatedKeys.next()) cliente.setId((int) generatedKeys.getLong(1));
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
	public void updateCliente(Cliente cliente) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getTelefone());
			stm.setString(3, cliente.getEmail());
			stm.setInt(4, cliente.getEndereco().getId());
			
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
     * CRUD: Deleta cliente
     * @param conn: Connection
     */
	public void deleteCliente(int id) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "DELETE FROM cliente WHERE id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, id);
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Carrega dados do cliente
     * @param conn: Connection
     */
	
	public Cliente loadCliente(int id) {
		EnderecoDAO dao = new EnderecoDAO();
		Cliente cliente = new Cliente();
		Connection conn = new ConnectionFactory().getConnection();
		String sqlInsert = "SELECT nome, telefone, email, endereco FROM cliente WHERE id =?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				cliente.setId(id);
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(dao.loadEndereco(rs.getInt("endereco_id")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
}
