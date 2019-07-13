package com.View;

import javax.swing.JButton;

public class ManageToolView extends ToolView {

	ManageView mannageView;
	JButton retButton, openRestButton, closeRestButton, findTableButton, restInfoButton;

	public ManageToolView(ManageView mannageView) {
		super(mannageView);
		this.mannageView = mannageView;

		addButtons();

		System.out.println("Mannage Panel is Ready...");
	}

	private void addButtons() {
		
		findTableButton = addButton("Find Table");
		restInfoButton = addButton("Restaurant Info");

		stickToTheRight();
		openRestButton = addButton("Open Rest");
		closeRestButton = addButton("Close Rest");
		retButton = addButton("Return");

		closeButtonsState();

	}

	public void openButtonsState() {
		closeRestButton.setEnabled(true);
		openRestButton.setEnabled(false);
		retButton.setEnabled(false);
		
		findTableButton.setEnabled(true);
		restInfoButton.setEnabled(true);
	}

	public void closeButtonsState() {
		closeRestButton.setEnabled(false);
		openRestButton.setEnabled(true);
		retButton.setEnabled(true);
		
		findTableButton.setEnabled(false);
		restInfoButton.setEnabled(false);
	}

	// getters setters
	public JButton getRetButton() {
		return retButton;
	}

	public void setRetButton(JButton retButton) {
		this.retButton = retButton;
	}

	public JButton getOpenRestButton() {
		return openRestButton;
	}

	public void setOpenRestButton(JButton openRest) {
		this.openRestButton = openRest;
	}

	public JButton getCloseRestButton() {
		return closeRestButton;
	}

	public void setCloseRestButton(JButton closeRest) {
		this.closeRestButton = closeRest;
	}

	public JButton getFindTableButton() {
		return findTableButton;
	}

	public void setFindTableButton(JButton findTableButton) {
		this.findTableButton = findTableButton;
	}

	public JButton getRestInfoButton() {
		return restInfoButton;
	}

	public void setRestInfoButton(JButton restInfoButton) {
		this.restInfoButton = restInfoButton;
	}

}
