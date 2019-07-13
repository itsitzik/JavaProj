package com.View;

import javax.swing.JButton;

public class PlanToolView extends ToolView {
	
	PlanView planView;
	JButton rectBtn, circleBtn, deleteBtn, cancelBtn, saveButton, loadButton, retButton, obsButton;
	
	public PlanToolView(PlanView planView) {
		super(planView);
		this.planView = planView;
		
		addButtons();

		System.out.println("Plan Panel is Ready...");
	}
	


	private void addButtons() {
		// add rectangle table
		rectBtn = addButton("Rect Table");
		// add circle table
		circleBtn = addButton("Circle Table");
		//OBSTACLE
		obsButton = addButton("Add Obstacle");
		// DELETE table
		deleteBtn = addButton("Delete Table");
		//CANCEL PAINTING BTN
		cancelBtn = addButton("Cancel Painting");

		stickToTheRight();
		
		//save button
		saveButton = addButton("Save Rest");
		//load button
		loadButton = addButton("Load Rest");
		//return button
		retButton = addButton("Return");

	}

	public JButton getRetButton() {
		return retButton;
	}

	public void setRetButton(JButton retButton) {
		this.retButton = retButton;
	}

	public JButton getRectBtn() {
		return rectBtn;
	}

	public void setRectBtn(JButton rectBtn) {
		this.rectBtn = rectBtn;
	}

	public JButton getCircleBtn() {
		return circleBtn;
	}

	public void setCircleBtn(JButton circleBtn) {
		this.circleBtn = circleBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
	
	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}



	public JButton getObsButton() {
		return obsButton;
	}



	public void setObsButton(JButton obsButton) {
		this.obsButton = obsButton;
	}
	
}
