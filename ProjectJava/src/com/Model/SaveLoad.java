package com.Model;

import java.util.List;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;


import com.Model.CircleTable;
import com.Model.RectTable;
import com.Model.Table;

public class SaveLoad {
	
	private final static SaveLoad SAVELOAD = new SaveLoad();

	private static final String pre = "com.Model.";
	
	public static SaveLoad getInstance() {
	    return SAVELOAD;
	  }

	public void SavePreset(List<Table> tables, String filename) throws TransformerException {

		Element table, tableClass, tablePeople, tableXpos, tableYpos, tableStart, tableEnd, tableSmoke;
		Element obstacle, obsXpos, obsYpos;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rest = doc.createElement("Rest");
			doc.appendChild(rest);

			for (int i = 0; i < tables.size(); i++) {

				table = doc.createElement("Table");
				rest.appendChild(table);

				tableClass = doc.createElement("Class");
				tableClass.appendChild(doc.createTextNode(tables.get(i).getClass().getName()));
				table.appendChild(tableClass);

				tablePeople = doc.createElement("People");
				tablePeople.appendChild(doc.createTextNode(tables.get(i).getPeople() + ""));
				table.appendChild(tablePeople);

				tableXpos = doc.createElement("xPos");
				tableXpos.appendChild(doc.createTextNode(tables.get(i).getxPos() + ""));
				table.appendChild(tableXpos);

				tableYpos = doc.createElement("yPos");
				tableYpos.appendChild(doc.createTextNode(tables.get(i).getyPos() + ""));
				table.appendChild(tableYpos);

				tableStart = doc.createElement("StartTime");
				tableStart.appendChild(doc.createTextNode(tables.get(i).getStartTime() + ""));
				table.appendChild(tableStart);

				tableEnd = doc.createElement("EndTime");
				tableEnd.appendChild(doc.createTextNode(tables.get(i).getEndTime() + ""));
				table.appendChild(tableEnd);

				tableSmoke = doc.createElement("Smoke");
				tableSmoke.appendChild(doc.createTextNode(tables.get(i).isSmoke() + ""));
				table.appendChild(tableSmoke);
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./" + filename));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void LoadPreset(List<Table> tables, List<Obstacle> obstacles, String filename) {
		tables.removeAll(tables);
		obstacles.removeAll(obstacles);
		Table table;
		Obstacle obstacle;
		Node nNode;
		Element eElement;

		try {
			File inputFile = new File("./" + filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Table");

			for (int i = 0; i < nList.getLength(); i++) {
				nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					eElement = (Element) nNode;
					if (eElement.getElementsByTagName("Class").item(0).getTextContent().toString()
							.equals(pre + "RectTable")) {
						RectTable recTable = new RectTable();
						table = recTable;
					} else {
						CircleTable cirTable = new CircleTable();
						table = cirTable;
					}
					//System.out.println(eElement.getElementsByTagName("People").item(0).getTextContent().toString());
					table.setPeople(eElement.getElementsByTagName("People").item(0).getTextContent().toString());
					table.setSmoke(eElement.getElementsByTagName("Smoke").item(0).getTextContent().toString());
					table.setStartTime(eElement.getElementsByTagName("StartTime").item(0).getTextContent().toString());
					table.setEndTime(eElement.getElementsByTagName("EndTime").item(0).getTextContent().toString());
					table.setxPos(eElement.getElementsByTagName("xPos").item(0).getTextContent().toString());
					table.setyPos(eElement.getElementsByTagName("yPos").item(0).getTextContent().toString());

					tables.add(table);
				}
			}
			
			nList = doc.getElementsByTagName("Obstacle");
			
			for (int i = 0; i < nList.getLength(); i++) {
				nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					eElement = (Element) nNode;
					obstacle = new Obstacle();
					obstacle.setxPos(eElement.getElementsByTagName("xPos").item(0).getTextContent().toString());
					obstacle.setyPos(eElement.getElementsByTagName("yPos").item(0).getTextContent().toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void LoadManagePreset(List<Table> tables, String filename) {
		
	}
}
