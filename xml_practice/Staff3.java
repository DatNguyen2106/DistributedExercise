package xml_test_1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Staff3 {
	public static void main(String[] args) {
		// Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// parse XML file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("src/xml_test_1/staff3.xml"));
			NodeList nl = doc.getElementsByTagName("staff");
			System.out.println(nl.getLength());

			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				Element e = (Element) n;
			
				// node staff e
				// print
				System.out.println("");
				System.out.println("Staff:" + e.getAttribute("id"));
				System.out.println("Name: " + e.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("Nickname: " + e.getElementsByTagName("nickname").item(0).getTextContent());
                System.out.println("salary: " + e.getElementsByTagName("salary").item(0).getTextContent());
                Element e1 =  (Element) e.getElementsByTagName("salary").item(0);
                System.out.println("currency: " + e1.getAttribute("currency"));

			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}