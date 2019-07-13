package com.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;

import com.Model.Table;
import com.View.PlanView;
import com.Model.PaintMode;

public class PlanModel extends Model {

	public PlanModel(PlanView planView) {
		super.addObserver(planView.getPlanPanel());
	}

	public void addObstacle(int xPos, int yPos) {
		int tableIndex = getTableIndexByXY(xPos, yPos);
		int obIndex = getObstacleByXY(xPos, yPos);
		System.out.println(tableIndex + " " + obIndex);
		if (tableIndex == -1 && obIndex == -1) {
			Obstacle obs = new Obstacle();
			obs.setxPos(xPos);
			obs.setyPos(yPos);
			obstacles.add(obs);
		} else {
			JOptionPane.showMessageDialog(null, "An error occured during painting: This spot is taken");
		}
		notifyAllObservers();

	}

	public void addTable(TableData tableData, int xPos, int yPos, PaintMode paintMode) {
		int tableIndex = getTableIndexByXY(xPos, yPos);
		int obIndex = getObstacleByXY(xPos, yPos);
		if (tableIndex == -1 && obIndex == -1) {
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
		} else {
			JOptionPane.showMessageDialog(null, "An error occured during painting: This spot is taken");
		}
		notifyAllObservers();
	}

	public void deleteCube(int xPos, int yPos) {
		int tableIndex = getTableIndexByXY(xPos, yPos);
		int obsIndex;
		try {
			if (tableIndex != -1) {
				tables.remove(tableIndex);
			} else {
				obsIndex = getObstacleByXY(xPos, yPos);
				if (obsIndex != -1) {
					obstacles.remove(obsIndex);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An error occured during deleting a table");
		}
		notifyAllObservers();
	}

	public void saveModel() {
		try {
			SaveLoad.getInstance().SavePreset(tables, obstacles, "Rest.xml");
			notifyAllObservers();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public void loadModel() {
		SaveLoad.getInstance().LoadPreset(tables, obstacles, "Rest.xml");
		notifyAllObservers();
	}

}
