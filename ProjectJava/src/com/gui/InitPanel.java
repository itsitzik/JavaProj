package com.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitPanel {
	
	JPanel initPanel;
	JButton planB, manageB;
	
	InitPanel(Gui gui) {
		

		AddInitPanel(gui.win);
		AddInitLabel("Welcome To RestPnM");
		AddInitButtons(gui);
	}

	private void AddInitPanel(JFrame win) {
		initPanel = new JPanel(new GridLayout(2, 1));
		initPanel.setBounds(0, 200, 1000, 200);
		initPanel.setVisible(true);
		win.getContentPane().add(initPanel);
	}

	private void AddInitLabel(String str) {

		JPanel labelpan = new JPanel();
		labelpan.setSize(1000, 1);
		initPanel.add(labelpan, BorderLayout.NORTH);

		JLabel label = new JLabel(str);
		Font font = new Font("arial", Font.PLAIN, 30);
		label.setFont(font);
		labelpan.add(label, BorderLayout.PAGE_START);

	}

	private void AddInitButtons(Gui gui) {

		JPanel buttonspan = new JPanel();
		buttonspan.setSize(1000, 1);
		initPanel.add(buttonspan, BorderLayout.SOUTH);

		planB = new JButton("Plan Restaurant");
		planB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPanel.setVisible(false);
				gui.ShowPlan();
			}
		});

		manageB = new JButton("Mannage Restaurant");
		manageB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initPanel.setVisible(false);
				gui.ShowManage();
			}
		});

		buttonspan.add(planB, BorderLayout.EAST);
		buttonspan.add(manageB, BorderLayout.WEST);
	}

	
}
