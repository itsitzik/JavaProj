package com.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Model.PaintMode;

public class PlanView extends JPanel {
	
	private Rest restView;
	private PlanToolView jtool;
	private PlanPanelView planPanel;

	public PlanView(Rest rest) {
		restView = rest;
		
		//planPanel = new JPanel(new BorderLayout());
		setLayout(null);
		restView.getContentPane().add(this,BorderLayout.CENTER);
		setBounds(0, 0, restView.getWidth() , restView.getHeight());
		
		planPanel = new PlanPanelView(this);
		jtool = new PlanToolView(this);
		
		setVisible(true);
	}
	
	public void setCursor(PaintMode paintMode) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = null;
		Cursor c = null;
		if (paintMode != PaintMode.NOT) {
			if (paintMode == PaintMode.RECT) {
				image = toolkit.getImage("resources/rectDraw.jpg");
				c = toolkit.createCustomCursor(image, new Point(getPlanPanel().getX(), getPlanPanel().getY()), "img");
			} else if (paintMode == PaintMode.CIRCLE) {
				image = toolkit.getImage("resources/circDraw.jpg");
				c = toolkit.createCustomCursor(image, new Point(getPlanPanel().getX(), getPlanPanel().getY()), "img");
			}else if (paintMode == PaintMode.DELETE) {
				c = new Cursor(Cursor.CROSSHAIR_CURSOR);
			}

		} else {
			c = new Cursor(Cursor.DEFAULT_CURSOR);
		}
		getPlanPanel().setCursor(c);
	}

	public PlanToolView getJtool() {
		return jtool;
	}

	public void setJtool(PlanToolView jtool) {
		this.jtool = jtool;
	}

	public PlanPanelView getPlanPanel() {
		return planPanel;
	}

	public void setPlanPanel(PlanPanelView planPanel) {
		this.planPanel = planPanel;
	}
	
}
