package com.gui;
import java.awt.*;

import javax.swing.*;

public class Gui {

	public JFrame win;
	public InitPanel initPanel;
	public PlanPanel planPanel;
	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static Mode mode;

	public Gui() {
		win = new JFrame();
		win.setSize(1000, 720);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane().setLayout(null);
		win.setResizable(false);
		win.setLocation(new Point(scrWidth/2 - 500, scrHeight/2 - 370));
		
		mode = Mode.INIT;
		initPanel = new InitPanel(this);
		win.setVisible(true);
	}
	
	public void ShowPlan() {
		mode = Mode.PLAN;
		win.getContentPane().removeAll();
		System.out.println(initPanel.toString());
		planPanel = new PlanPanel(this);
	}
	
	public void ShowManage() {
		mode = Mode.MANAGE;
		System.out.println("bye");
	}

	
}
