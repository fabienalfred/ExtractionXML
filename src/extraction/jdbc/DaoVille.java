package extraction.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoVille {
	
	Connection connection;
	
	public ResultSet getVillesByCodePostal(String cp) throws SQLException{
		connect();
		String query = "SELECT * FROM villes WHERE code_postal LIKE ? ORDER BY code_postal";
		PreparedStatement pstat = connection.prepareStatement(query);
		pstat.setString(1, cp+"%");
		ResultSet rs = pstat.executeQuery();
		return rs;
	}
	
	public void connect(){
		this.connection = BDD.connect();
	}
	
	public void disconnect(){
		BDD.disconnect(this.connection);
	}
	
}
