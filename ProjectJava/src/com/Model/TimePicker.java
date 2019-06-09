package com.Model;

import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class TimePicker extends JPanel {
	JSpinner jspinH,jspinM;
	
	public TimePicker() {
		int i = 20;
		setLayout(null);
		setPreferredSize(new Dimension(400, 150));

		JLabel label1 = new JLabel("Whene do you close the Restaurent?");
		label1.setFont(new Font("arial", Font.PLAIN, 17));
		add(label1);
		label1.setBounds(20, i, 300, 20);
		i += 50;
		
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 23, 1);
		
		jspinH = new JSpinner(model);
		jspinH.setBounds(20, i, 50, 25);
		jspinH.setFont(new Font("arial", Font.PLAIN, 17));
		add(jspinH);
		jspinH.setVisible(true);
		
		JLabel sep = new JLabel(":");
		sep.setFont(new Font("arial", Font.PLAIN, 20));
		add(sep);
		sep.setBounds(73, i, 300, 20);
		
		SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, 0, 15);
		
		jspinM = new JSpinner(model2);
		jspinM.setBounds(80, i, 50, 25);
		jspinM.setFont(new Font("arial", Font.PLAIN, 17));
		add(jspinM);
		jspinM.setVisible(true);
	}
	
	public static LocalTime getTime() {
		TimePicker timePicker = new TimePicker();
		LocalTime time = null;
		JOptionPane.showMessageDialog(null,timePicker,"Pick Time",JOptionPane.INFORMATION_MESSAGE);
		try {
			time = LocalTime.of(Integer.parseInt(timePicker.jspinH.getValue().toString()), Integer.parseInt(timePicker.jspinM.getValue().toString()));
		} catch(Exception e) {
			System.out.println(e);
		}
		return time;
	}
}
