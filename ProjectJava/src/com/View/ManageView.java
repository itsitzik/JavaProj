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
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.Model.PaintMode;

public class ManageView extends JPanel {
	
	private Rest restView;
	private ManageToolView jtool;
	private TablesPanelView managePanel;

	public ManageView(Rest rest) {
		restView = rest;
		
		//mannagePanel = new JPanel(new BorderLayout());
		setLayout(null);
		restView.getContentPane().add(this,BorderLayout.CENTER);
		setBounds(0, 0, restView.getWidth() , restView.getHeight());
		
		managePanel = new TablesPanelView(this);
		jtool = new ManageToolView(this);
		
		setVisible(true);
	}
	
	public void setCursor(PaintMode paintMode) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = null;
		Cursor c = null;
		if (paintMode != PaintMode.NOT) {
			if (paintMode == PaintMode.RECT) {
				image = toolkit.getImage("resources/rectDraw.jpg");
				c = toolkit.createCustomCursor(image, new Point(getManagePanel().getX(), getManagePanel().getY()), "img");
			} else if (paintMode == PaintMode.CIRCLE) {
				image = toolkit.getImage("resources/circDraw.jpg");
				c = toolkit.createCustomCursor(image, new Point(getManagePanel().getX(), getManagePanel().getY()), "img");
			}else if (paintMode == PaintMode.DELETE) {
				c = new Cursor(Cursor.CROSSHAIR_CURSOR);
			}

		} else {
			c = new Cursor(Cursor.DEFAULT_CURSOR);
		}
		getManagePanel().setCursor(c);
	}

	public ManageToolView getJtool() {
		return jtool;
	}

	public void setJtool(ManageToolView jtool) {
		this.jtool = jtool;
	}

	public TablesPanelView getManagePanel() {
		return managePanel;
	}

	public void setManagePanel(TablesPanelView mannagePanel) {
		this.managePanel = mannagePanel;
	}
	
	
}
