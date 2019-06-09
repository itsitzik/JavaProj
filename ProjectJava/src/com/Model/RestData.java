package com.Model;

import java.time.LocalTime;

public class RestData {
	LocalTime openTime;
	LocalTime closeTime;
	double TodayProfit;
	int tablesServed;
	
	public RestData(LocalTime now, LocalTime time, int TodayProfit, int tablesServed) {
		this.openTime = now;
		this.closeTime = time;
		this.TodayProfit = TodayProfit;
		this.tablesServed = tablesServed;		
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
}
