package com.gui;
import java.awt.*;

import javax.swing.*;

public class Gui {

	public JFrame win;
	public InitPanel initPanel;
	public PlanPanel planPanel;
	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

	public Gui() {
		win = new JFrame();
		win.setSize(1000, 700);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane().setLayout(null);
		win.setResizable(false);
		win.setLocation(new Point(scrWidth/2 - 500, scrHeight/2 - 350));
		
		initPanel = new InitPanel(this);
		win.setVisible(true);
	}
	
	public void ShowPlan() {
		planPanel = new PlanPanel();
	}
	
	public void ShowManage() {
		System.out.println("bye");
	}

	
}
