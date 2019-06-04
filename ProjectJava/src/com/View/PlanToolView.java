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

public class PlanToolView extends JToolBar {
	
	PlanView planView;
	JButton rectBtn, circleBtn, deleteBtn, cancelBtn, saveButton, loadButton, retButton;
	
	public PlanToolView(PlanView planView) {
		
		this.planView = planView;
		
		planView.add(this);
		setFloatable(false);
		setBounds(0, 0, planView.getWidth(), 30);
		
		


		//this = new JPanel(new BorderLayout());
		
		
		
		addButtons();

		System.out.println("Plan Panel is Ready...");
	}
	


	private void addButtons() {
		// add rectangle table
		rectBtn = new JButton("Rectangle Table");
		add(rectBtn);

		// add circle table
		circleBtn = new JButton("Circle Table");
		add(circleBtn);
		
		// DELETE table
		deleteBtn = new JButton("Delete Table");
		add(deleteBtn);
		
		cancelBtn = new JButton("Cancel Painting");
		add(cancelBtn);

		//jtool.addSeparator(new Dimension(20, 20));
		add(Box.createHorizontalGlue());

		saveButton = new JButton("Save Rest");
		add(saveButton);

		loadButton = new JButton("Load Rest");
		add(loadButton);
		
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
	
}
