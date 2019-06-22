package com.View;


import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Model.TableData;


public class TableFree {
	
	
	TableData tableData;
	private JPanel mainPanel;
	JTextField bill;
	
	public TableFree(){
		int i = 20;

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(400, 150));

		JLabel label1 = new JLabel("What is the bill of this table?:");
		label1.setFont(new Font("arial", Font.PLAIN, 17));
		mainPanel.add(label1);
		label1.setBounds(20, i, 300, 20);
		i+=30;

		bill = new JTextField();
		mainPanel.add(bill);
		bill.setBounds(20, i, 300, 25);
		i+=30;
		
		//JOptionPane.showMessageDialog(null,mainPanel,"Table Data",JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	public int getBillData() {
		int money;
		for(;;) {
			JOptionPane.showMessageDialog(null,mainPanel,"Table Data",JOptionPane.INFORMATION_MESSAGE);
			try {
				money = Integer.parseInt(bill.getText());
				break;
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Enter Valid number");
			}
		}
		return money;
	}
}

