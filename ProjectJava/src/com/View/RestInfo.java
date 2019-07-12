package com.View;

import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.Model.RestData;
import com.Model.TimePicker;

public class RestInfo extends JPanel {
	public RestInfo(RestData restData) {
		int i = 20;
		setLayout(null);
		setPreferredSize(new Dimension(400, 150));

		JLabel label1 = new JLabel("Open time: " + restData.getOpenTime().format(DateTimeFormatter.ofPattern("HH:mm")));
		JLabel label2 = new JLabel("Close time: " + restData.getCloseTime().format(DateTimeFormatter.ofPattern("HH:mm")));
		JLabel label3 = new JLabel("Today Profit: " + restData.getTodayProfit());
		JLabel label4 = new JLabel("Tables served: " + restData.getTablesServed());
		JLabel label5 = new JLabel("Waiting outside: " + restData.getWaiting());
		
		label1.setFont(new Font("arial", Font.PLAIN, 17));
		label2.setFont(new Font("arial", Font.PLAIN, 17));
		label3.setFont(new Font("arial", Font.PLAIN, 17));
		label4.setFont(new Font("arial", Font.PLAIN, 17));
		label5.setFont(new Font("arial", Font.PLAIN, 17));
		
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		
		label1.setBounds(20, i, 300, 20);
		i += 20;
		label2.setBounds(20, i, 300, 20);
		i += 20;
		label3.setBounds(20, i, 300, 20);
		i += 20;
		label4.setBounds(20, i, 300, 20);
		i += 20;
		label5.setBounds(20, i, 300, 20);

	}
	
	public static void showInfo(RestData restData) {
		RestInfo restInfo = new RestInfo(restData);
		JOptionPane.showMessageDialog(null,restInfo,"Restaurant Information",JOptionPane.INFORMATION_MESSAGE);
	}
}
