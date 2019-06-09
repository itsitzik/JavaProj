package com.View;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public abstract class ToolView extends JToolBar {
	JPanel container;

	public ToolView(JPanel container) {

		this.container = container;

		container.add(this);
		setFloatable(false);
		setBounds(0, 0, container.getWidth(), 30);

	}

	public JButton addButton(String label) {
		JButton btn = new JButton(label);
		add(btn);
		return btn;
	}
	
	public void stickToTheRight() {
		add(Box.createHorizontalGlue());
	}
}
