package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnecton {
	
	private static String url = "jdbc:postgresql://localhost:5433/jsp";
	private static String user = "postgres";
	private static String  senha = "12345678";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	static {
		conectar();
	}
	
	
	public SingleConnecton() {
	conectar();
	}
	
	
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, senha);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}

}
