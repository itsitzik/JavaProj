package com.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
	
	List<Table> tables = new ArrayList<Table>();
	List<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public List<Table> getTables() {
		return tables;
	}
	
	public List<Obstacle> getObstacles() {
		return obstacles;
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
	
	public int getObstacleByXY(int xPos, int yPos) {
		Obstacle ob;
		for (int i = 0; i < obstacles.size(); i++) {
			ob = obstacles.get(i);
			if (ob.getxPos() == xPos && ob.getyPos() == yPos) {
				return i;
			}
		}
		return -1;
	}
	
	public void notifyAllObservers() {
		setChanged();
		super.notifyObservers(this);
	}

}
