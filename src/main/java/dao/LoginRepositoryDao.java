package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnecton;
import model.ModelLogin;

public class LoginRepositoryDao {
	private Connection connection;
	
	public LoginRepositoryDao() {
		connection = SingleConnecton.getConnection();

}
	public boolean validarAutenticacao(ModelLogin login) throws SQLException {
		String sql = "select * from model_login where login = ? and senha = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, login.getLogin());
		preparedStatement.setString(2, login.getSenha());
		ResultSet resultSet = preparedStatement.executeQuery();
		
		
		if(resultSet.next()) {
			return true;
		}
		return false; //nao autenticado
		
	}
}
