package com.View;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Model.TableData;


public class TablePref /*extends JFrame*/ {
	
	
	TableData tableData;
	private JPanel mainPanel;
	
	JTextField people;
	JComboBox<Boolean> smk;
	private int xPos, yPos;
	
	public TablePref(){
		int i = 20;

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(400, 150));

		JLabel label1 = new JLabel("How many people can sit on this table?:");
		label1.setFont(new Font("arial", Font.PLAIN, 17));
		mainPanel.add(label1);
		label1.setBounds(20, i, 300, 20);
		i+=30;

		people = new JTextField();
		mainPanel.add(people);
		people.setBounds(20, i, 300, 25);
		i+=30;
		
		JLabel label2 = new JLabel("Can people smoke in the table?:");
		label2.setFont(new Font("arial", Font.PLAIN, 17));
		mainPanel.add(label2);
		label2.setBounds(20, i, 300, 20);
		i+=30;

		Boolean[] vec = new Boolean[] {true, false};
		smk = new JComboBox<Boolean>(vec);
		mainPanel.add(smk);
		smk.setBounds(20, i, 300, 25);
		i+=35;
		
		//JOptionPane.showMessageDialog(null,mainPanel,"Table Data",JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	public TableData getTableData() {

		for(;;) {
			JOptionPane.showMessageDialog(null,mainPanel,"Table Data",JOptionPane.INFORMATION_MESSAGE);
			try {
				tableData = new TableData();
				if(ValidateData(smk.getSelectedItem().toString(),people.getText())){ //validate user input
					tableData.setPeople(Integer.parseInt(people.getText()));
					tableData.setSmk(Boolean.parseBoolean(smk.getSelectedItem().toString()));
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Enter Valid Information");
				}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Enter Valid Information");
			}
		}
		return tableData;
	}
	
	protected Boolean ValidateData(String smk, String people) {
		int p;
		Boolean smoke;
		try {
			p = Integer.parseInt(people);
			smoke = Boolean.parseBoolean(smk);
			if(p <= 0) return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
