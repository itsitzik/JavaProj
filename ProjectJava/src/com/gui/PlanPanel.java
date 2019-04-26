package com.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.xml.transform.TransformerException;

import com.db.SaveLoad;
import com.db.TableData;
import java.util.ArrayList;
import java.util.List;

public class PlanPanel {

	enum TableKind {
		RECT, CIRCLE
	}

	TableKind tableKind;

	JToolBar jtool;
	JPanel planPanel;
	JButton rectBtn, circleBtn, deleteBtn, saveButton, loadButton, retButton;
	Boolean isPainting = false;
	Boolean isDelete = false;
	List<Table> tables = new ArrayList<Table>();

	TablePref prefOfTable;
	TableData tabledata;
	int AmountOfTables = 0;

	JFrame wind;

	PlanPanel(Gui gui) {
		init(gui);

	}

	private void init(Gui gui) {
		initToolBar(gui);
		System.out.println(jtool.getHeight());
		initPlanPanel(gui.win);
		

		System.out.println("we ok2");
	}

	private void initPlanPanel(JFrame win) {

		planPanel = new JPanel(new BorderLayout());
		win.getContentPane().add(planPanel,BorderLayout.CENTER);
		planPanel.setBounds(0, 30, win.getWidth() , 600);
		planPanel.setVisible(true);

		planPanel.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				if (isPainting) {
					isPainting = false;
					paintTable(e);
					SetCursor();
					jtool.setVisible(true);
				} else if (isDelete) {
					isDelete = false;
					deleteTable(e);
					jtool.setVisible(true);
				}
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});

		System.out.println("Plan Panel is Ready...");
	}

	private void initToolBar(Gui gui) {
		
		JPanel toolPanel = new JPanel(new BorderLayout());
		gui.win.getContentPane().add(toolPanel);
		toolPanel.setBounds(0, 0, gui.win.getWidth(), 30);
		toolPanel.setVisible(true);
		//toolPanel.setBackground(Color.BLACK);
		
		jtool = new JToolBar("Toolbar");
		jtool.setVisible(true);
		jtool.setFloatable(false);
		
		addButtons(gui);
		
		toolPanel.add(jtool, BorderLayout.CENTER);
		
		gui.win.getContentPane().add(toolPanel, BorderLayout.PAGE_START);
		System.out.println("Tool Bar is Ready...");
	}

	private void addButtons(Gui gui) {
		// add rectangle table
		rectBtn = new JButton("Rectangle Table");
		jtool.add(rectBtn);
		rectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rectButtonPressed();
			}
		});

		// add circle table
		circleBtn = new JButton("Circle Table");
		jtool.add(circleBtn);
		circleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				circleButtonPressed();
			}
		});
		
		// DELETE table
				deleteBtn = new JButton("Delete Table");
				jtool.add(deleteBtn);
				deleteBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteButtonPressed();
					}
				});
		
		//jtool.addSeparator(new Dimension(20, 20));
		jtool.add(Box.createHorizontalGlue());

		saveButton = new JButton("Save Rest");
		jtool.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveButtonPressed();
			}
		});

		loadButton = new JButton("Load Rest");
		jtool.add(loadButton);
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadButtonPressed();
			}
		});
		
		retButton = new JButton("Return");
		jtool.add(retButton);
		retButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				planPanel.setVisible(false);
				gui.ShowInit();
			}
		});
	}

	private void deleteButtonPressed() {
		System.out.println("recr btn");
		isDelete = true;
	}

	private void rectButtonPressed() {
		System.out.println("recr btn");
		tableKind = TableKind.RECT;
		isPainting = true;
		SetCursor();
	}

	private void circleButtonPressed() {
		System.out.println("circ btn");
		tableKind = TableKind.CIRCLE;
		isPainting = true;
		SetCursor();
	}

	private void saveButtonPressed() {
		Thread thread = new Thread("SavePlanThread") {
			public void run() {
				try {
					SaveLoad.SaveRest(tables);
				} catch (TransformerException e) {
					e.printStackTrace();
				}
				System.out.println("Restaurant has saved...");
			}

		};
		thread.start();
	}

	private void loadButtonPressed() {

		SaveLoad.LoadRest(tables);
		AmountOfTables = tables.size();
		drawTables();
		System.out.println("Restaurant has loaded...");
	}

	private void SetCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = null;
		Cursor c = null;
		if (isPainting) {
			drawPlanGrid();
			if (tableKind == TableKind.RECT) {
				image = toolkit.getImage("resources/rectDraw.jpg");
			} else if (tableKind == TableKind.CIRCLE) {
				image = toolkit.getImage("resources/circDraw.jpg");
			}
			c = toolkit.createCustomCursor(image, new Point(planPanel.getX(), planPanel.getY()), "img");

		} else {
			c = new Cursor(Cursor.DEFAULT_CURSOR);
		}
		planPanel.setCursor(c);
	}

	private void paintTable(MouseEvent e) {
		System.out.println("I Paint " + tableKind);
		System.out.println(e.getX() + " and " + e.getY());

		prefOfTable = new TablePref();
		tabledata = prefOfTable.getTableData();
		// now we have table data from user.

		if (tableKind == TableKind.RECT) {
			RectTable rectTable = new RectTable();
			rectTable.setPeople(tabledata.getPeople());
			rectTable.setSmoke(tabledata.getSmk());
			rectTable.setxPos((e.getX() - (e.getX() % 100)) / 100);
			rectTable.setyPos((e.getY() - (e.getY() % 100)) / 100);
			tables.add(rectTable);
			AmountOfTables++;
		} else if (tableKind == TableKind.CIRCLE) {
			CircleTable circTable = new CircleTable();
			circTable.setPeople(tabledata.getPeople());
			circTable.setSmoke(tabledata.getSmk());
			circTable.setxPos((e.getX() - (e.getX() % 100)) / 100);
			circTable.setyPos((e.getY() - (e.getY() % 100)) / 100);
			tables.add(circTable);
			AmountOfTables++;
		} else {
			JOptionPane.showMessageDialog(planPanel, "An error occured during picking table kind");
		}

		drawTables();
	}

	private void deleteTable(MouseEvent e) {
		Table table;
		int xx, yy;
		xx = (e.getX() - (e.getX() % 100)) / 100;
		yy = (e.getY() - (e.getY() % 100)) / 100;
		for (int i = 0; i < AmountOfTables; i++) {
			table = tables.get(i);
			if (table.getxPos() == xx && table.getyPos() == yy) {
				tables.remove(i);
				AmountOfTables--;
				break;
			}
		}
		drawTables();
	}

	private void drawTables() {
		Graphics g = planPanel.getGraphics();
		g.clearRect(0, 0, 1000, planPanel.getHeight());
		drawPlanGrid();
		for (int i = 0; i < AmountOfTables; i++) {
			tables.get(i).printTable(planPanel);
		}
	}

	private void drawPlanGrid() {
		Graphics g = planPanel.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 1; i < 10; i++) {
			g.drawLine(i * 100 - 1, 0, i * 100 - 1, 699);
			g.drawLine(0, i * 100 - 1, 999, i * 100 - 1);
		}
		System.out.println("Grid has painted...");
	}

}
