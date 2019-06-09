package com.Controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.Model.PlanModel;
import com.Model.TableData;
import com.Model.PaintMode;
import com.View.TablesPanelView;
import com.View.PlanView;
import com.View.TablePref;

public class PlanController {

	PlanModel planModel;
	PlanView planView;
	PaintMode paintMode;

	public PlanController(PlanModel planModel, PlanView planView) {
		this.planModel = planModel;
		this.planView = planView;
		paintMode = PaintMode.NOT;

		addToolbarListeners();
		addPlanPanelListeners();
		addToolSaveLoadListeners();

	}
	
	//add listeners functions

	private void addToolbarListeners() {

		planView.getJtool().getRectBtn().addActionListener(e -> startPainting(PaintMode.RECT));
		planView.getJtool().getCircleBtn().addActionListener(e -> startPainting(PaintMode.CIRCLE));
		planView.getJtool().getDeleteBtn().addActionListener(e -> startPainting(PaintMode.DELETE));
		planView.getJtool().getCancelBtn().addActionListener(e -> endPainting());
	}

	private void addPlanPanelListeners() {
		planView.getPlanPanel().addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				planPanelClicked(e);
			}

			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}

		});
	}
	

	private void addToolSaveLoadListeners() {
		planView.getJtool().getSaveButton().addActionListener(e -> saveRest());
		planView.getJtool().getLoadButton().addActionListener(e -> loadRest());
	}
	
	//save load functions
	
	private void loadRest() {
		planModel.loadModel();
	}

	private void saveRest() {
		planModel.saveModel();
	}

	//Painting functions
	
	private void planPanelClicked(MouseEvent e) {
		int xPos,yPos;
		
		if (paintMode != PaintMode.NOT) {
			xPos = (e.getX() - (e.getX() % 100)) / 100;
			yPos = (e.getY() - (e.getY() % 100)) / 100;
			if (paintMode == PaintMode.DELETE) {
				planModel.deleteTable(xPos, yPos);
			} else {
				TablePref prefOfTable = new TablePref();
				TableData tableData = prefOfTable.getTableData();
				planModel.addTable(tableData, xPos, yPos, paintMode);
			}
			endPainting();
			return;
		}
		System.out.println("No new Tables Created...");
	}

	private void startPainting(PaintMode paintMode) {
		this.paintMode = paintMode;
		planView.setCursor(paintMode);
		System.out.println("Paint mode has Started...");
	}

	private void endPainting() {
		this.paintMode = PaintMode.NOT;
		planView.setCursor(paintMode);
		System.out.println("Paint mode has Stopped...");
	}

}
