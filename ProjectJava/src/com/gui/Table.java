package com.gui;

import java.awt.Graphics;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JPanel;

public abstract class Table {
	private int people;
	private Boolean taken = false;
	private LocalTime startTime, endTime;
	private boolean isSmoke;
	private int xPos, yPos;

	public Table(int _p, boolean _t, LocalTime _strt, LocalTime _end, boolean _smk, int xPos, int yPos) {
		this.setPeople(_p);
		this.setTaken(_t);
		this.setStartTime(_strt);
		this.setEndTime(_end);
		this.setSmoke(_smk);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}

	abstract void printTable(JPanel win);

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public void setPeople(String people) {
		try {
			this.people = Integer.parseInt(people);
		} catch (Exception e) {
			e.printStackTrace();
			this.people = 0;
		}
	}

	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public void setStartTime(String startTime) {
		try {
			this.startTime = LocalTime.parse(startTime);
			//this.startTime.setTime(Long.parseLong(startTime));
		} catch (Exception e) {
			e.printStackTrace();
			// this.startTime = new Date();
		}
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public void setEndTime(String endTime) {
		try {
			this.endTime = LocalTime.parse(endTime);
			//this.endTime.setTime(Long.parseLong(endTime));
		} catch (Exception e) {
			e.printStackTrace();
			// this.startTime = new Date();
		}
	}

	public boolean isSmoke() {
		return isSmoke;
	}

	public void setSmoke(boolean isSmoke) {
		this.isSmoke = isSmoke;
	}

	public void setSmoke(String isSmoke) {
		try {
			this.isSmoke = Boolean.parseBoolean(isSmoke);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setxPos(String xPos) {
		try {
			this.xPos = Integer.parseInt(xPos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void setyPos(String yPos) {
		try {
			this.yPos = Integer.parseInt(yPos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
