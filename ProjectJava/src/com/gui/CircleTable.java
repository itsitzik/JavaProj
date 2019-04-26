package com.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JPanel;

public class CircleTable extends Table {
	
	private final int size = 100;
	private final int lnSpace = 15;
	private final int padding = 5;
	private String tableInfo = "";
	
	public CircleTable(){
		super(0,false,new Date(),new Date(),false,0,0);
	}

	public void printTable(JPanel win) {
		// = new;
		Graphics g = win.getGraphics();
		g.drawOval(getxPos() * size -1, getyPos() * size -1, size, size);
		g.setColor(Color.RED);
		g.fillOval(getxPos() * size, getyPos() * size, size -1, size -1);
		
		drawTableInfo(g);
		System.out.println(tableInfo);
		
	}

	private void drawTableInfo(Graphics g) {
		g.setColor(Color.BLACK);
		int i = 1;
		g.drawString("people: " + getPeople(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("smoke?: " + isSmoke(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("start: " + getStartTime().getHours() + ":" + getStartTime().getMinutes(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("end: " + + getEndTime().getHours() + ":" + getEndTime().getMinutes(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("taken?: " + getTaken(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));

	}
}
