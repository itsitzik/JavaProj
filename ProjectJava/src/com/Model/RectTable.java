package com.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JPanel;

import org.omg.CosNaming.IstringHelper;

public class RectTable extends Table {
	
	private final int size = 100;
	private final int lnSpace = 15;
	private final int padding = 5;
	private String tableInfo = "";
	
	public RectTable(){
		super(0,false, LocalTime.now(),LocalTime.now() ,false,0,0);
	}
	
	@Override
	public PaintMode getTableKind() {
		return PaintMode.RECT;
		
	}

	public void printTable(JPanel win) {
		// = new;
		Graphics g = win.getGraphics();
		g.drawRect(getxPos() * size -1, getyPos() * size -1, size, size);
		g.setColor(Color.RED);
		g.fillRect(getxPos() * size, getyPos() * size, size -1, size -1);
		
		drawTableInfo(g);
		System.out.println(tableInfo);
		
	}

	private void drawTableInfo(Graphics g) {
		g.setColor(Color.BLACK);
		int i = 1;
		g.drawString("people: " + getPeople(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("smoke?: " + isSmoke(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("start: " + getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")) , getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("end: " + getEndTime().format(DateTimeFormatter.ofPattern("HH:mm")), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));
		g.drawString("taken?: " + getTaken(), getxPos() * size + padding, getyPos() * size + (lnSpace * i++));

	}

}
