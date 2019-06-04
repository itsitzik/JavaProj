package com.Controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.Model.MannageModel;
import com.Model.TableData;
import com.Model.PaintMode;
import com.View.MannagePanelView;
import com.View.MannageView;
import com.View.TablePref;

public class MannageController {

	MannageModel mannageModel;
	MannageView mannageView;
	PaintMode paintMode;

	public MannageController(MannageModel mannageModel, MannageView mannageView) {
		this.mannageModel = mannageModel;
		this.mannageView = mannageView;
		paintMode = PaintMode.NOT;

		addToolbarListeners();
		addMannagePanelListeners();
		addToolSaveLoadListeners();

	}
	
	//add listeners functions

	private void addToolbarListeners() {

		//mannageView.getJtool().getRectBtn().addActionListener(e -> startPainting(PaintMode.RECT));
		//mannageView.getJtool().getCircleBtn().addActionListener(e -> startPainting(PaintMode.CIRCLE));
		//mannageView.getJtool().getDeleteBtn().addActionListener(e -> startPainting(PaintMode.DELETE));
		//mannageView.getJtool().getCancelBtn().addActionListener(e -> endPainting());
	}

	private void addMannagePanelListeners() {
		mannageView.getMannagePanel().addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				mannagePanelClicked(e);
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
		System.out.println("N/A");
//		mannageView.getJtool().getSaveButton().addActionListener(e -> saveRest());
//		mannageView.getJtool().getLoadButton().addActionListener(e -> loadRest());
	}
	
	//save load functions
	
	private void loadRest() {
		System.out.println("N/A");
//		mannageModel.loadModel();
	}

	private void saveRest() {
		System.out.println("N/A");
//		mannageModel.saveModel();
	}

	private void mannagePanelClicked(MouseEvent e) {
		System.out.println("N/A");
//		int xPos,yPos;		
//		if (paintMode != PaintMode.NOT) {
//			xPos = (e.getX() - (e.getX() % 100)) / 100;
//			yPos = (e.getY() - (e.getY() % 100)) / 100;
//			if (paintMode == PaintMode.DELETE) {
//				mannageModel.deleteTable(xPos, yPos);
//			} else {
//				TablePref prefOfTable = new TablePref();
//				TableData tableData = prefOfTable.getTableData();
//				mannageModel.addTable(tableData, xPos, yPos, paintMode);
//			}
//			endPainting();
//			return;
//		}
//		System.out.println("No new Tables Created...");
	}
	
	//Painting functions
	
	private void startPainting(PaintMode paintMode) {
		this.paintMode = paintMode;
		mannageView.setCursor(paintMode);
		System.out.println("Paint mode has Started...");
	}

	private void endPainting() {
		this.paintMode = PaintMode.NOT;
		mannageView.setCursor(paintMode);
		System.out.println("Paint mode has Stopped...");
	}

}
