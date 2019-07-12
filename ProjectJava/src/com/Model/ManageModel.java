package com.Model;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Queue;

import com.Model.Table;
import com.View.ManageView;



public class ManageModel extends Observable implements Model {

	RestData restData;
	List<Table> tables = new ArrayList<Table>();
	List<Obstacle> obstacles = new ArrayList<Obstacle>();
	List<Integer> waiting = new ArrayList<Integer>();

	public ManageModel(ManageView manageView) {
		super.addObserver(manageView.getManagePanel());
	}
	
	public void SetTaken(int xPos, int yPos) {
		int tableInd = getTableIndexByXY(xPos, yPos);
		tables.get(tableInd).setTaken(true);
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

	public void notifyAllObservers() {
		setChanged();
		super.notifyObservers(tables);
	}

	public void saveModel() {
		// TODO Auto-generated method stub
	}

	public void loadModel() {
		SaveLoad.getInstance().LoadPreset(tables, obstacles, "Rest.xml");
		setInitState();
		notifyAllObservers();
		
	}
	
	public Boolean getIsTakenByIndex(int ind) {
		return tables.get(ind).getTaken();
	}

	private void setInitState() {
		for(int i = 0 ; i < tables.size(); i++) {
			waiting.add(0);
			tables.get(i).setStartTime("00:00");
			tables.get(i).setEndTime("00:00");
		}
		
	}
	
	public void addWait(int tableInd) {
		waiting.set(tableInd, 1);
		IncWaiting();
	}

	public void clearWait(int tableInd) {
		waiting.set(tableInd, 0);
		DecWaiting();
	}
	
	public Boolean isWaiting(int tableInd) {
		return waiting.get(tableInd) == 1 ? true : false;
	}
	
	private void IncWaiting() {
		restData.waiting++;
	}
	
	private void DecWaiting() {
		restData.waiting--;
		if(restData.waiting < 0) restData.waiting = 0;
	}
	
	public void sitGuests(int tableInd) {
		Table table = tables.get(tableInd);
		table.setTaken(true);
		table.setStartTime(LocalTime.now());
		table.setEndTime(LocalTime.now().plusHours(2));
		notifyAllObservers();
	}

	public void setRestInfo(LocalTime now, LocalTime time, int i, int j, int waiting) {
		restData = new RestData(now, time, i, j, waiting);
	}
	
	public void freeTable(int index, double money) {
		addTebleServed();
		addProfit(money);
		tables.get(index).setTaken(false);
		tables.get(index).setEndTime("00:00");
		tables.get(index).setStartTime("00:00");
		notifyAllObservers();
	}
	
	private void addTebleServed() {
		restData.tablesServed++;
	}
	
	private void addProfit(double money) {
		restData.TodayProfit += money;
	}
	
	public RestData getRestInfo() {
		return restData;
	}

	

}
