package com.View;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.Controller.MannageController;
import com.Controller.PlanController;
import com.Model.ManageModel;
import com.Model.Mode;
import com.Model.PlanModel;

public class Rest extends JFrame {

	private static final long serialVersionUID = 1L;
	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

	public ManageView manageView;
	public PlanView planView;
	public InitView initView;

	public PlanModel planModel;
	public ManageModel manageModel;

	public PlanController planController;
	public MannageController manageController;

	private Mode mode; //enum. to specify the working mode (formal, not in use)

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Rest rest = new Rest();
			}
		});
	}

	public Rest() {

		initRest(); //init first load properties
		ApplyInitApp(); //start application in init mode

	}

	public void initRest() {
		this.setSize(1000, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocation(new Point(scrWidth / 2 - 500, scrHeight / 2 - 330));
		this.setVisible(true);

		//
	}

	public void ApplyInitApp() {
		mode = Mode.INIT;
		this.getContentPane().removeAll(); // remove all content of frame before adding new
		initView = new InitView(this);
		AddInitListeners();
		System.out.println("Init Mode Initiated...");
	}

	// add listeners to init panel buttons
	private void AddInitListeners() {
		initView.getManageB().addActionListener(e -> ApplyManageApp());
		initView.getPlanB().addActionListener(e -> ApplyPlanApp());
	}

	public void ApplyPlanApp() {
		if (JOptionPane.showInputDialog("Admin Login").compareTo("admin") == 0) { // check if admin
			mode = Mode.PLAN;
			this.getContentPane().removeAll(); // remove all content of frame before adding new
			//mvc
			planView = new PlanView(this);
			planModel = new PlanModel(planView);
			planController = new PlanController(planModel, planView);
			//add listener for return button
			AddPlanListeners();
			System.out.println("Plan Mode Initiated...");
		} else {
			JOptionPane.showMessageDialog(this, "Wrong password!");
		}
	}

	private void AddPlanListeners() {
		planView.getJtool().getRetButton().addActionListener(e -> ApplyInitApp());
	}

	public void ApplyManageApp() { // start manage application
		mode = Mode.MANAGE;
		this.getContentPane().removeAll(); // remove all content of frame before adding new
		//mvc
		manageView = new ManageView(this);
		manageModel = new ManageModel(manageView);
		manageController = new MannageController(manageModel, manageView);
		//add listener for return button
		AddMannageListeners();
		System.out.println("Manage Mode Initiated...");
	}

	private void AddMannageListeners() {
		manageView.getJtool().getRetButton().addActionListener(e -> ApplyInitApp());
	}

	public int getScrWidth() {
		return scrWidth;
	}

	public void setScrWidth(int scrWidth) {
		this.scrWidth = scrWidth;
	}
}
