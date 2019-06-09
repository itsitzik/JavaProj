package com.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;

import com.Model.Table;
import com.View.PlanView;
import com.Model.PaintMode;

public class PlanModel extends Observable implements Model {

	List<Table> tables = new ArrayList<Table>();

	public PlanModel(PlanView planView) {
		super.addObserver(planView.getPlanPanel());
	}

	public void notifyAllObservers() {
		setChanged();
		super.notifyObservers(tables);
	}

	public void addTable(TableData tableData, int xPos, int yPos, PaintMode paintMode) {
		int tableIndex = getTableIndexByXY(xPos, yPos);
		if (tableIndex == -1) {
			if (paintMode == PaintMode.RECT) {
				RectTable rectTable = new RectTable();
				rectTable.setPeople(tableData.getPeople());
				rectTable.setSmoke(tableData.getSmk());
				rectTable.setxPos(xPos);
				rectTable.setyPos(yPos);
				tables.add(rectTable);
			} else if (paintMode == PaintMode.CIRCLE) {
				CircleTable circTable = new CircleTable();
				circTable.setPeople(tableData.getPeople());
				circTable.setSmoke(tableData.getSmk());
				circTable.setxPos(xPos);
				circTable.setyPos(yPos);
				tables.add(circTable);
			} else {
				JOptionPane.showMessageDialog(null, "An error occured during picking table kind");
			}
		}
		notifyAllObservers();
	}

	public void deleteTable(int xPos, int yPos) {
		int tableIndex = getTableIndexByXY(xPos, yPos);
		try {
			if (tableIndex != -1) 
				tables.remove(tableIndex);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An error occured during deleting a table");
		}
		notifyAllObservers();
	}

	public int getTableIndexByXY(int xPos, int yPos) {
		Table table;
		for (int i = 0; i < tables.size(); i++) {
			table = tables.get(i);
			if (table.getxPos() == xPos && table.getyPos() == yPos) {
				return i;
			}
		}
		return -1;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void saveModel() {
		try {
			SaveLoad.getInstance().SavePreset(tables, "Rest.xml");
			notifyAllObservers();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}

	public void loadModel() {
		SaveLoad.getInstance().LoadPreset(tables, "Rest.xml");
		notifyAllObservers();
	}

}
