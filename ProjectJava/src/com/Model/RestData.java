package com.Model;

import java.time.LocalTime;

public class RestData {
	LocalTime openTime;
	LocalTime closeTime;
	double TodayProfit;
	int tablesServed;
	int waiting;
	
	public RestData(LocalTime now, LocalTime time, int TodayProfit, int tablesServed, int waiting) {
		this.openTime = now;
		this.closeTime = time;
		this.TodayProfit = TodayProfit;
		this.tablesServed = tablesServed;	
		this.waiting = waiting;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public double getTodayProfit() {
		return TodayProfit;
	}

	public void setTodayProfit(double todayProfit) {
		TodayProfit = todayProfit;
	}

	public int getTablesServed() {
		return tablesServed;
	}

	public void setTablesServed(int tablesServed) {
		this.tablesServed = tablesServed;
	}

	public int getWaiting() {
		return waiting;
	}

	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}
}
