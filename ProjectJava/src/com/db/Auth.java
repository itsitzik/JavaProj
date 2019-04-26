package com.db;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.db.Users;

public class Auth extends JFrame {

	private JPanel mainPanel;
	Users user;

	private int scrWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

	public Auth() {
		InitAuth();
	}

	public Users getUserKind() {
		return user;
	}

	private void InitAuth() {
		this.setVisible(true);

		this.setTitle("Authentication");
		this.setSize(400, 200);
		this.setLocation(new Point(scrWidth / 2 - 200, scrHeight / 2 - 100));
		this.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 400, 200);

		JLabel label = new JLabel("Please Enter Username and Password:");
		label.setFont(new Font("arial", Font.PLAIN, 17));
		mainPanel.add(label);
		label.setBounds(20, 20, 300, 20);

		JTextField usr = new JTextField();
		mainPanel.add(usr);
		usr.setBounds(20, 50, 300, 25);

		JTextField pass = new JTextField();
		mainPanel.add(pass);
		pass.setBounds(20, 85, 300, 25);

		JButton ok = new JButton("Confirm");
		mainPanel.add(ok);
		ok.setBounds(20, 120, 100, 25);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckLogin();

			}
		});

		this.getContentPane().add(mainPanel);

	}
	
	private void CheckLogin() {
		if(true) {
			user = Users.ADMIN;
		}
		this.setVisible(false);
	}
}
