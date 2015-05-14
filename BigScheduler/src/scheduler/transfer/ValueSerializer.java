package scheduler.transfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import representation.values.ListValue;
import representation.values.Value;
import scheduler.datamodel.Variable;

public class ValueSerializer {
	private static List<Class> baseTypes;
	private static DocumentBuilderFactory dbFactory;
	private static DocumentBuilder dBuilder;
	private static Document doc;

	public static String serialize(Variable variable) {
		initialize();
		Value value = variable.getValueObject();
		StringBuffer buffer = new StringBuffer();
		if (baseTypes.contains(value.getClass())) {
			String typeName = value.getType().toString();
			buffer.append("<");
			buffer.append(typeName);
			buffer.append(">");
			buffer.append(value.getValue().toString());
			buffer.append("</");
			buffer.append(typeName);
			buffer.append(">");
		} else if (value instanceof ListValue) {
		}
		// File file=new File(variable.getName());
		String filename = variable.getName();
		try {
			PrintWriter out = new PrintWriter(filename);
			out.print(new String(buffer));
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return filename;
	}

	public static Value deSerialize(String filepath) {
		Value value = null;
		File file = new File(filepath);
		dbFactory = DocumentBuilderFactory.newInstance();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);
			Element root = doc.getDocumentElement();
			root.normalize();
			root.getNodeValue();
			System.out.println("Root element :" + root.getNodeName() + "---->"
					+ root.getTextContent());
			// NodeList nList = doc.getElementsByTagName("student");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}

	private static void initialize() {
		if (baseTypes == null) {
			baseTypes = new ArrayList<Class>();
			try {
				baseTypes.add(Class.forName("representation.values.IntValue"));
				baseTypes
						.add(Class.forName("representation.values.FloatValue"));
				baseTypes.add(Class
						.forName("representation.values.StringValue"));
				baseTypes.add(Class
						.forName("representation.values.BooleanValue"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
