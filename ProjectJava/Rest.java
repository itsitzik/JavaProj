package com.View;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.Controller.PlanController;
import com.Controller.MannageController;
import com.Model.PlanModel;
import com.Model.MannageModel;
import com.gui.InitPanel;
import com.gui.Mode;
import com.gui.PlanPanel;
import com.gui.MannagePanel;

public class Rest extends JFrame {
	
	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	public InitPanel initPanel;
	
	public MannageView mannageView;
	public PlanView planView;
	public InitView initView;
	
	public PlanModel planModel;
	public MannageModel mannageModel;
	
	public PlanController planController; 
	public MannageController mannageController; 
	
	private Mode mode;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Rest rest = new Rest();
			}
		});
	}
	
	public Rest(){

		initRest();
		ApplyInitApp();
		
	}
	
	public void initRest() {
		this.setSize(1000, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocation(new Point(getScrWidth()/2 - 500, scrHeight/2 - 330));
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
	
	//add listeners to init panel buttons
	private void AddInitListeners() {
		initView.getManageB().addActionListener(e -> ApplyManageApp());
		initView.getPlanB().addActionListener(e -> ApplyPlanApp());
	}
	
	public void ApplyPlanApp() {
		mode = Mode.PLAN;
		this.getContentPane().removeAll();
		planView = new PlanView(this);
		planModel = new PlanModel(planView);
		planController = new PlanController(planModel, planView);
		AddPlanListeners();
		System.out.println("Plan Mode Initiated...");
	}
	
	private void AddPlanListeners() {
		planView.getJtool().getRetButton().addActionListener(e -> ApplyInitApp());
	}
	
	public void ApplyManageApp() {
		mode = Mode.MANAGE;
		this.getContentPane().removeAll();
		mannageView = new MannageView(this);
		mannageModel = new MannageModel(mannageView);
		mannageController = new MannageController(mannageModel, mannageView);
		AddMannageListeners();
		System.out.println("Manage Mode Initiated...");
	}

	private void AddMannageListeners() {
		planView.getJtool().getRetButton().addActionListener(e -> ApplyInitApp());
	}
	
	public int getScrWidth() {
		return scrWidth;
	}

	public void setScrWidth(int scrWidth) {
		this.scrWidth = scrWidth;
	}
}
