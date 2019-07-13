package com.View;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.Controller.PlanController;
import com.Controller.MannageController;
import com.Model.PlanModel;
import com.Model.ManageModel;
import com.Model.Mode;

public class Rest extends JFrame {

	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

	public ManageView manageView;
	public PlanView planView;
	public InitView initView;

	public PlanModel planModel;
	public ManageModel manageModel;

	public PlanController planController;
	public MannageController manageController;

	private Mode mode;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Rest rest = new Rest();
			}
		});
	}

	public Rest() {

		initRest();
		ApplyInitApp();

	}

	public void initRest() {
		this.setSize(1000, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocation(new Point(getScrWidth() / 2 - 500, scrHeight / 2 - 330));
		this.setVisible(true);

		//
	}

	public void ApplyInitApp() {
		mode = Mode.INIT;
		this.getContentPane().removeAll();
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
		if (JOptionPane.showInputDialog("Admin Login").compareTo("admin") == 0) {
			mode = Mode.PLAN;
			this.getContentPane().removeAll();
			planView = new PlanView(this);
			planModel = new PlanModel(planView);
			planController = new PlanController(planModel, planView);
			AddPlanListeners();
			System.out.println("Plan Mode Initiated...");
		} else {
			JOptionPane.showMessageDialog(this, "Wrong password!");
		}
	}

	private void AddPlanListeners() {
		planView.getJtool().getRetButton().addActionListener(e -> ApplyInitApp());
	}

	public void ApplyManageApp() {
		mode = Mode.MANAGE;
		this.getContentPane().removeAll();
		manageView = new ManageView(this);
		manageModel = new ManageModel(manageView);
		manageController = new MannageController(manageModel, manageView);
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

	private JTextField loginPanel() {
		JTextField text = new JTextField();

		return text;
	}
}
