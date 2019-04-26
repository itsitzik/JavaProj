package com.gui;

import java.awt.Graphics;
import java.util.Date;

import javax.swing.JPanel;

public abstract class Table {
	private int people;
	private Boolean taken = false;
	private Date startTime,endTime;
	private boolean isSmoke;
	private int xPos,yPos;
	
	public Table(int _p, boolean _t, Date _strt, Date _end, boolean _smk, int xPos, int yPos) {
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

	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isSmoke() {
		return isSmoke;
	}

	public void setSmoke(boolean isSmoke) {
		this.isSmoke = isSmoke;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
