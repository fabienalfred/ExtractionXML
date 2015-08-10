package extraction.jpa;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		String cp = JOptionPane.showInputDialog("Code postal ?");
		if(cp.length()>5){
			System.out.println("Erreur de saisie pour le code postal");
			return;
		}
		
		DaoVille dao = new DaoVille();
		List<Ville> villes = dao.getVillesByCodePostal(cp);
		String fileName = "villes-jpa.xml";
		XMLHelper.createFile(villes, fileName);
//		for(Ville v : villes){
//			System.out.println(v.getCodePostal()+" : "+v.getNom());
//		}
	}

}
