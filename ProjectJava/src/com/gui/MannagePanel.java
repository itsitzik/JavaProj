package com.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.xml.transform.TransformerException;

import com.Model.CircleTable;
import com.Model.RectTable;
import com.Model.SaveLoad;
import com.Model.Table;
import com.Model.TableData;
import com.View.TablePref;

import java.util.ArrayList;
import java.util.List;

public class MannagePanel {

	JButton retButton;
	JToolBar jtool;
	JPanel mannagePanel;
	
	private void addButtons(Gui gui) {

		retButton = new JButton("Return");
		jtool.add(retButton);
		retButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											mannagePanel.setVisible(false);
											gui.ShowInit();
										}
									});
		
	}
	
	MannagePanel(Gui gui) {
		init(gui);
	}
	
	private void init(Gui gui) {
		initToolBar(gui);
		System.out.println(jtool.getHeight());
		initMannagePanel(gui.win);
		System.out.println("we ok2");
	}
	
	private void initMannagePanel(JFrame win) {

		mannagePanel = new JPanel(new BorderLayout());
		win.getContentPane().add(mannagePanel,BorderLayout.CENTER);
		mannagePanel.setBounds(0, 30, win.getWidth() , 600);
		mannagePanel.setVisible(true);

		mannagePanel.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});

		System.out.println("Mannage Panel is Ready...");
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
	
}
