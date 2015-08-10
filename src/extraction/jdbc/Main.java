package extraction.jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		String cp = JOptionPane.showInputDialog("Code postal ?");
		if(cp.length()>5){
			System.out.println("Erreur de saisie pour le code postal");
			return;
		}
		
		DaoVille dao = new DaoVille();
		ResultSet rs = dao.getVillesByCodePostal(cp);
		String fileName = "villes-jdbc.xml";
		XMLHelper.createFile(rs, fileName);
		dao.disconnect();
	}

}
