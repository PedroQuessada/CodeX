package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.Endereco;
import model.PessoaFisica;

public class PessoaFisicaDAO {

	/**
     * CRUD: Insere PessoaFisica
     * @param conn: Connection
     */
	public void createPessoaFisica(PessoaFisica pessoaFisica) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "INSERT INTO pessoaFisica (cpf, clienete) VALUES (?, ?)";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, pessoaFisica.getCpf());
			stm.setInt(2, pessoaFisica.getCliente().getId());
			
			int affectedRows = stm.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Criação das informacaoes falhou. Nenhuma linha criada");
	        }

	        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	        	if (generatedKeys.next()) pessoaFisica.setId((int) generatedKeys.getLong(1));
	        	else throw new SQLException("Criação das informacaoes falhou. Nenhum id criado");
	        }
	        
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Atualiza PessoaFisica
     * @param conn: Connection
     */
	public void updatePessoaFisica(PessoaFisica pessoaFisica) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "UPDATE pessoaFisica SET cpf = ?, cliente = ? WHERE id = ?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, pessoaFisica.getCpf());
			stm.setInt(2, pessoaFisica.getCliente().getId());
			
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
     * CRUD: Deleta PessoaFisica
     * @param conn: Connection
     */
	public void deletePessoaFisica(int id) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "DELETE FROM pessoaFisica WHERE id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, id);
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Carrega dados do PessoaFisica
     * @param conn: Connection
     */
	
	public PessoaFisica loadPessoaFisica(int id) {
		PessoaFisica pessoaFisica = new PessoaFisica();
		ClienteDAO dao = new ClienteDAO();
		Connection conn = new ConnectionFactory().getConnection();
		String sqlInsert = "SELECT cpf, cliente FROM pessoaFisica WHERE id =?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				pessoaFisica.setId(id);
				pessoaFisica.setCpf(rs.getInt("cpf"));
				pessoaFisica.setCliente(dao.loadCliente(rs.getInt("cliente")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pessoaFisica;
	}
	
	
}
