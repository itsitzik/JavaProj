package com.Controller;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.Model.Table;
import com.Model.TableData;

public class FindTable extends JFrame {
	
	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private JPanel mainPanel;
	JTable list;
	List<Table> tables = new ArrayList<Table>();
	JTextField people;
	JComboBox<Boolean> smk;
	int Choosen;
	String[] colNames = {"id","people","smk"};
	DefaultTableModel dtm = new DefaultTableModel(0, 0);
	
	public FindTable(List<Table> tables) {
		this.tables = tables;
		designFrame();
	}
	
	
	
	private void designFrame() {
		int i = 20;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setBounds(scrWidth/2 - 175, scrHeight/2 - 250, 350 , 500);
		this.setVisible(true);

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(400, 150));
		
		
		this.getContentPane().add(mainPanel,BorderLayout.CENTER);
		mainPanel.setBounds(0, 0, this.getWidth() , this.getHeight());

		JLabel label1 = new JLabel("How many for?:");
		label1.setFont(new Font("arial", Font.PLAIN, 17));
		mainPanel.add(label1);
		label1.setBounds(20, i, 300, 20);
		i+=30;

		people = new JTextField();
		mainPanel.add(people);
		people.setBounds(20, i, 300, 25);
		i+=30;
		
		JLabel label2 = new JLabel("Tables for Smokers?:");
		label2.setFont(new Font("arial", Font.PLAIN, 17));
		mainPanel.add(label2);
		label2.setBounds(20, i, 300, 20);
		i+=30;

		Boolean[] vec = new Boolean[] {true, false};
		smk = new JComboBox<Boolean>(vec);
		mainPanel.add(smk);
		smk.setBounds(20, i, 300, 25);
		i+=35;
		
		list = new JTable();
		mainPanel.add(list);
		list.setBounds(20, i, 300, 500 - 60 - i);
		list.setVisible(true);
		
		mainPanel.setVisible(true);
		
		dtm.setColumnIdentifiers(colNames);
		list.setModel(dtm);
		list.setDefaultEditor(Object.class, null);

		
		findTable(tables, new TableData(1,true));
	}



	private void findTable(List<Table> tables, TableData data) {

		int size = tables.size();
		for(int i = 0; i < size; i++) {
			Table table = tables.get(i);
			if(table.getPeople() >= data.getPeople()) {
				if(table.isSmoke() == data.getSmk()) {
					if(table.getTaken() == false || MINUTES.between(LocalTime.now(), table.getEndTime()) < 20) {
						dtm.addRow(new Object[] {i,table.getPeople(),table.isSmoke()});
					}

				}
			}
		}
		

	}
}

