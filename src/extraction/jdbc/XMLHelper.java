package extraction.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class XMLHelper {

	public static void createFile(ResultSet rs, String fileName) throws IOException, SQLException{
		Writer writer = new FileWriter(fileName);
		ResultSetMetaData metaData = rs.getMetaData();
		addPrologue(writer);
		openRoot(writer, metaData.getCatalogName(1));
		addChildren(writer, rs);
		closeRoot(writer, metaData.getCatalogName(1));
		writer.flush();
		writer.close();
		System.out.println(">>> Ecriture terminée <<<");
	}

	private static void addPrologue(Writer writer) throws IOException {
		writer.write("<?xml version='1.0' encoding='UTF-8'?>");
	}

	private static void openRoot(Writer writer, String root) throws IOException {
		writer.write("<"+root+">");
	}

	private static void closeRoot(Writer writer, String root) throws IOException {
		writer.write("</"+root+">");
	}

	private static void addChildren(Writer writer, ResultSet rs) throws SQLException, IOException {
		ResultSetMetaData metaData = rs.getMetaData();
		int nbColumns = metaData.getColumnCount();
		StringBuffer buffer = new StringBuffer();
		while(rs.next()){
			buffer.setLength(0);
			buffer.append("<"+metaData.getTableName(1)+">");
			for(int i=1 ; i<=nbColumns ; i++){
				buffer.append("<"+metaData.getColumnName(i)+">");
				buffer.append(rs.getString(i));
				buffer.append("</"+metaData.getColumnName(i)+">");
			}
			buffer.append("</"+metaData.getTableName(1)+">");
			writer.write(buffer.toString());
		}
	}
	
}
