package extraction.jpa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class XMLHelper {

	public static void createFile(List<Ville> villes, String fileName) throws IOException {
		Writer writer = new FileWriter(fileName);
		String root = "villes";
		writePrologue(writer);
		openRoot(writer, root);
		addChildren(writer, villes);
		closeRoot(writer, root);
		writer.flush();
		writer.close();
		System.out.println(">>> Ecriture terminée <<<");
	}

	private static void writePrologue(Writer writer) throws IOException {
		writer.write("<?xml version='1.0' encoding='UTF-8'?>");
	}

	private static void openRoot(Writer writer, String root) throws IOException {
		writer.write("<" + root + ">");
	}

	private static void closeRoot(Writer writer, String root) throws IOException {
		writer.write("</" + root + ">");
	}

	private static void addChildren(Writer writer, List<Ville> villes) throws IOException {
		StringBuffer buffer = new StringBuffer();
		for (Ville v : villes) {
			buffer.setLength(0);
			buffer.append("<ville id='_" + v.getId() + "'>");
			buffer.append("<nom>" + v.getNom() + "</nom>");
			buffer.append("<cp>" + v.getCodePostal() + "</cp>");
			buffer.append("<region>" + v.getRegion() + "</region>");
			buffer.append("<departement>" + v.getDepartement() + "</departement>");
			buffer.append("<latitude>" + v.getLatitude() + "</latitude>");
			buffer.append("<longitude>" + v.getLongitude() + "</longitude>");
			buffer.append("</ville>");
			writer.write(buffer.toString());
		}
	}

}
