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

	public void printTable(Graphics g, int size, Color color) {
		g.drawRect(this.getxPos() * size - 1, this.getyPos() * size - 1, size, size);
		g.setColor(color);
		g.fillRect(this.getxPos() * size, this.getyPos() * size, size - 1, size - 1);
	}

}
