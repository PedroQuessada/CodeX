package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.PessoaJuridica;

public class PessoaJuridicaDAO {

	/**
     * CRUD: Insere PessoaJuridica
     * @param conn: Connection
     */
	public void createPessoaJuridica(PessoaJuridica pessoaJuridica) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "INSERT INTO pessoaJuridica (nome_fantasia, cnpj, cliente, fornecedor) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, pessoaJuridica.getNomeFantasia());
			stm.setInt(2, pessoaJuridica.getCnpj());
			stm.setInt(3, pessoaJuridica.getCliente().getId());
			stm.setInt(4, pessoaJuridica.getFornecedor());
			
			int affectedRows = stm.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Criação das informacaoes falhou. Nenhuma linha criada");
	        }

	        try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
	        	if (generatedKeys.next()) pessoaJuridica.setId((int) generatedKeys.getLong(1));
	        	else throw new SQLException("Criação das informacaoes falhou. Nenhum id criado");
	        }
	        
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Atualiza PessoaJuridica
     * @param conn: Connection
     */
	public void updatepessoaFisica(PessoaJuridica pessoaJuridica) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "UPDATE pessoaJuridica SET nome_fantasia = ?, cnpj = ?, cliente = ?, fornecedor = ? WHERE id = ?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, pessoaJuridica.getNomeFantasia());
			stm.setInt(2, pessoaJuridica.getCnpj());
			stm.setInt(3, pessoaJuridica.getCliente().getId());
			stm.setInt(4, pessoaJuridica.getFornecedor());
			
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
     * CRUD: Deleta PessoaJuridica
     * @param conn: Connection
     */
	public void deletepessoaJuridica(int id) {
		Connection conn = new ConnectionFactory().getConnection();
		
		String sqlComand = "DELETE FROM pessoaJuridica WHERE id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlComand, Statement.RETURN_GENERATED_KEYS)){
			stm.setInt(1, id);
			stm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * CRUD: Carrega dados do PessoaJuridica
     * @param conn: Connection
     */
	
	public PessoaJuridica loadPessoaJuridica(int id) {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		ClienteDAO dao = new ClienteDAO();
		Connection conn = new ConnectionFactory().getConnection();
		String sqlInsert = "SELECT nome_fantasia, cnpj, fornecedor, cliente FROM pessoaFisica WHERE id =?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				pessoaJuridica.setId(id);
				pessoaJuridica.setNomeFantasia(rs.getString("nome_fantasia"));
				pessoaJuridica.setCnpj(rs.getInt("cnpj"));
				pessoaJuridica.setFornecedor(rs.getInt("fornecedor"));
				pessoaJuridica.setCliente(dao.loadCliente(rs.getInt("cliente")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pessoaJuridica;
	}
	
	
}
