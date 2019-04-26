package com.db;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.gui.Table;

public class SaveLoad {

	public static void SaveRest(List<Table> tables) throws TransformerException {

		Element table, tableClass, tablePeople, tableXpos, tableYpos, tableStart, tableEnd, tableSmoke;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rest = doc.createElement("Rest");
			doc.appendChild(rest);

			for (int i = 0; i < tables.size(); i++) {
				// supercars element
				table = doc.createElement("Table");
				rest.appendChild(table);

				tableClass = doc.createElement("Class");
				tableClass.appendChild(doc.createTextNode(tables.get(i).getClass().getName()));
				table.appendChild(tableClass);

				tablePeople = doc.createElement("people");
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
			StreamResult result = new StreamResult(new File("./Rest.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static void LoadRest(List<Table> tables) {

	}
}
