import javax.swing.*; 
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.*;

//MAIN CLASS WHERE main FUNCTION IS
public class Rest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File(".settings/RestSettings.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputFile);
		System.out.println(doc.getDocumentElement().getNodeName());
	}
	
	void InitRest() {
		JFrame gui = new JFrame();
	}

}
