package com.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalTime;

public class CircleTable extends Table {
	
	public CircleTable(){
		super(0,false, LocalTime.now(), LocalTime.now(), false, 0, 0);
	}
	
	public CircleTable(int x, int y){
		super(0,false, LocalTime.now(), LocalTime.now(), false, x, y);
	}
	
	@Override
	public PaintMode getTableKind() {
		return PaintMode.CIRCLE;
		
	}

	public void printTable(Graphics g, int size, Color color) {
		g.drawOval(this.getxPos() * size - 1, this.getyPos() * size - 1, size, size);
		g.setColor(color);
		g.fillOval(this.getxPos() * size, this.getyPos() * size, size - 1, size - 1);
		
	}


}
