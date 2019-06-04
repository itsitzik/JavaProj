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

public class MannageView extends JPanel {
	
	private Rest restView;
	private MannageToolView jtool;
	private MannagePanelView mannagePanel;

	public MannageView(Rest rest) {
		restView = rest;
		
		//mannagePanel = new JPanel(new BorderLayout());
		setLayout(null);
		restView.getContentPane().add(this,BorderLayout.CENTER);
		setBounds(0, 0, restView.getWidth() , restView.getHeight());
		
		mannagePanel = new MannagePanelView(this);
		jtool = new MannageToolView(this);
		
		setVisible(true);
	}
	
	public void setCursor(PaintMode paintMode) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = null;
		Cursor c = null;
		if (paintMode != PaintMode.NOT) {
			if (paintMode == PaintMode.RECT) {
				image = toolkit.getImage("resources/rectDraw.jpg");
				c = toolkit.createCustomCursor(image, new Point(getMannagePanel().getX(), getMannagePanel().getY()), "img");
			} else if (paintMode == PaintMode.CIRCLE) {
				image = toolkit.getImage("resources/circDraw.jpg");
				c = toolkit.createCustomCursor(image, new Point(getMannagePanel().getX(), getMannagePanel().getY()), "img");
			}else if (paintMode == PaintMode.DELETE) {
				c = new Cursor(Cursor.CROSSHAIR_CURSOR);
			}

		} else {
			c = new Cursor(Cursor.DEFAULT_CURSOR);
		}
		getMannagePanel().setCursor(c);
	}

	public MannageToolView getJtool() {
		return jtool;
	}

	public void setJtool(MannageToolView jtool) {
		this.jtool = jtool;
	}

	public MannagePanelView getMannagePanel() {
		return mannagePanel;
	}

	public void setMannagePanel(MannagePanelView mannagePanel) {
		this.mannagePanel = mannagePanel;
	}
	
}
