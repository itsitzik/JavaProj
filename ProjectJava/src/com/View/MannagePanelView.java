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

public class MannagePanelView extends JPanel implements Observer {
	
	private final int size = 100;
	private final int lnSpace = 15;
	private final int padding = 5;
	private String tableInfo = "";
	
	List<Table> tables = new ArrayList<Table>();
	
	MannageView mannageView;
	
	public MannagePanelView(MannageView mannageView){
		this.mannageView = mannageView;
		mannageView.add(this,BorderLayout.CENTER);
		this.setBounds(0, 30, mannageView.getWidth() , 600);
		this.setVisible(true);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable mannageModel, Object tables) {
		this.tables = (List<Table>) tables;
		repaint();
	}

}
