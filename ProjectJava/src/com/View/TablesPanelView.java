package com.View;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.Model.Model;
import com.Model.Obstacle;
import com.Model.Table;

public class TablesPanelView extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int size = 100;
	private final int lnSpace = 15;
	private final int padding = 5;
	private Timer timer;

	JPanel container;

	List<Table> tables = new ArrayList<Table>();
	List<Obstacle> obstacles = new ArrayList<Obstacle>();

	public TablesPanelView(JPanel container) {
		this.container = container;
		container.add(this, BorderLayout.CENTER);
		this.setBounds(0, 30, container.getWidth(), 600);
		this.setVisible(true);
		
		defineTimer();
	}

	private void defineTimer() {
		ActionListener timeOutRoutine = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Panel Refreshed: t/o");
				repaint();
			}
		};
		timer = new Timer(120000, timeOutRoutine);
		timer.setRepeats(true);
        timer.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawPlanGrid(g);
		drawTables(g);
		drawObstacles(g);
	}

	private void drawObstacles(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		System.out.println(obstacles.size());
		for (int i = 0; i < obstacles.size(); i++) {
			g.fillRect(obstacles.get(i).getxPos() * size - 1, obstacles.get(i).getyPos() * size - 1, size, size);
		}
		
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

		int timeToFree = (int) MINUTES.between(LocalTime.now(), table.getEndTime());
		Color color = table.getTaken() ? (timeToFree <= 0 ? Color.ORANGE: Color.RED) : Color.GREEN; // change to 0

		
		table.printTable(g, size, color); // polymorpishm of function to print the circle or rectangle
		
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

	@Override
	public void update(Observable planModel, Object model) {
		this.tables = (List<Table>) ((Model) model).getTables();
		this.obstacles = (List<Obstacle>) ((Model) model).getObstacles();
		repaint();
	}
	
	
}
