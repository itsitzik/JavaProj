package com.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.gui.Gui;

public class MannageToolView extends JToolBar {
	
	MannageView mannageView;
	JButton retButton;
	
	public MannageToolView(MannageView mannageView) {
		
		this.mannageView = mannageView;
		
		mannageView.add(this);
		setFloatable(false);
		setBounds(0, 0, mannageView.getWidth(), 30);
		
		//this = new JPanel(new BorderLayout());

		addButtons();

		System.out.println("Mannage Panel is Ready...");
	}
	

	private void addButtons() {
		
		retButton = new JButton("Return");
		add(retButton);
		retButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//planPanel.setVisible(false);
				//gui.ShowInit();
			}
		});
	}

	public JButton getRetButton() {
		return retButton;
	}

	public void setRetButton(JButton retButton) {
		this.retButton = retButton;
	}
	
}
