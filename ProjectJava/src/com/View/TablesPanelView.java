package com.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.Model.PaintMode;
import com.Model.Table;
import com.View.PlanView;

public class TablesPanelView extends JPanel implements Observer {

	private final int size = 100;
	private final int lnSpace = 15;
	private final int padding = 5;

	JPanel container;

	List<Table> tables = new ArrayList<Table>();

	public TablesPanelView(JPanel container) {
		this.container = container;
		container.add(this, BorderLayout.CENTER);
		this.setBounds(0, 30, container.getWidth(), 600);
		this.setVisible(true);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawPlanGrid(g);
		drawTables(g);
	}

	private void drawPlanGrid(Graphics g) {
		// Graphics g = planPanel.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 1; i < 10; i++) {
			g.drawLine(i * 100 - 1, 0, i * 100 - 1, 699);
			g.drawLine(0, i * 100 - 1, 999, i * 100 - 1);
		}
		System.out.println("Grid has painted...");
	}

	private void drawTables(Graphics g) {
		for (int i = 0; i < tables.size(); i++) {
			printTable(tables.get(i), g);
		}
	}

	public void printTable(Table table, Graphics g) {

		PaintMode tableToPaint = table.getTableKind();
		Color color = table.getTaken() ? Color.RED : Color.GREEN;

		if (tableToPaint == PaintMode.RECT) {
			g.drawRect(table.getxPos() * size - 1, table.getyPos() * size - 1, size, size);
			g.setColor(color);
			g.fillRect(table.getxPos() * size, table.getyPos() * size, size - 1, size - 1);
		} else if (tableToPaint == PaintMode.CIRCLE) {
			g.drawOval(table.getxPos() * size - 1, table.getyPos() * size - 1, size, size);
			g.setColor(color);
			g.fillOval(table.getxPos() * size, table.getyPos() * size, size - 1, size - 1);
		}
		g.setColor(Color.BLACK);
		int i = 1;
		g.drawString("people: " + table.getPeople(), table.getxPos() * size + padding,
				table.getyPos() * size + (lnSpace * i++));
		g.drawString("smoke?: " + table.isSmoke(), table.getxPos() * size + padding,
				table.getyPos() * size + (lnSpace * i++));
		g.drawString("start: " + table.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")),
				table.getxPos() * size + padding, table.getyPos() * size + (lnSpace * i++));
		g.drawString("end: " + table.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm")),
				table.getxPos() * size + padding, table.getyPos() * size + (lnSpace * i++));
		g.drawString("taken?: " + table.getTaken(), table.getxPos() * size + padding,
				table.getyPos() * size + (lnSpace * i++));

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable planModel, Object tables) {
		this.tables = (List<Table>) tables;
		repaint();
	}
	
}
