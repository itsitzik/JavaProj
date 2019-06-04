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
		win.setSize(1000, 660);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane().setLayout(null);
		win.setResizable(false);
		win.setLocation(new Point(scrWidth/2 - 500, scrHeight/2 - 330));
		win.setVisible(true);
		
		ShowInit();
		
	}
	
	public void ShowInit() {
		mode = Mode.INIT;
		win.getContentPane().removeAll();
		System.out.println("Init Mode Initiated...");
		initPanel = new InitPanel(this);
	}
	
	public void ShowPlan() {
		mode = Mode.PLAN;
		win.getContentPane().removeAll();
		System.out.println("Plan Mode Initiated...");
		planPanel = new PlanPanel(this);
	}
	
	public void ShowManage() {
		mode = Mode.MANAGE;
		win.getContentPane().removeAll();
		System.out.println("Manage Mode Initiated...");
	}

	
}
