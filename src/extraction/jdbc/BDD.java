package extraction.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql:///france";
	private static String user = "root";
	private static String password = "";
	
	
	public static Connection connect(){
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(">>> Connexion réussie <<<");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void disconnect(Connection connection){
		try {
			connection.close();
			connection = null;
			System.out.println(">>> Connexion fermée <<<");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
