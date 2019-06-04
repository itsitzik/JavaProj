package com.View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitView extends JPanel {
	
	Rest rest;
	JButton planB, manageB;

	public InitView(Rest rest) {
		this.rest = rest;
		
		AddInitPanel(rest);
		AddInitLabel("Welcome To RestPnM");
		AddInitButtons(rest);
		revalidate();
		setVisible(true);
	}

	private void AddInitPanel(JFrame win) {
		
		Graphics g = win.getGraphics();
		g.clearRect(0, 0, win.getWidth(), win.getHeight());
		
		setLayout(new GridLayout(2, 1));
		setBounds(0, 200, rest.getWidth(), 200);
		win.getContentPane().add(this);
		
	}

	private void AddInitLabel(String str) {

		JPanel labelpan = new JPanel();
		labelpan.setSize(1000, 1);
		add(labelpan, BorderLayout.NORTH);

		JLabel label = new JLabel(str);
		Font font = new Font("arial", Font.PLAIN, 30);
		label.setFont(font);
		labelpan.add(label, BorderLayout.PAGE_START);

	}

	private void AddInitButtons(JFrame win) {

		JPanel buttonspan = new JPanel();
		buttonspan.setSize(1000, 1);
		add(buttonspan, BorderLayout.SOUTH);

		planB = new JButton("Plan Restaurant");
		planB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initPanel.setVisible(false);
				//gui.ShowPlan();
			}
		});

		manageB = new JButton("Mannage Restaurant");
		manageB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initPanel.setVisible(false);
				//gui.ShowManage();
			}
		});

		buttonspan.add(planB, BorderLayout.EAST);
		buttonspan.add(manageB, BorderLayout.WEST);
	}

	public JButton getPlanB() {
		return planB;
	}

	public void setPlanB(JButton planB) {
		this.planB = planB;
	}

	public JButton getManageB() {
		return manageB;
	}

	public void setManageB(JButton manageB) {
		this.manageB = manageB;
	}
	
}
