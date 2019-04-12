package com.gui;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.SwingWorker;

import com.db.Auth;

import com.db.Users;

public class PlanPanel {

	Users user;
	Auth auth;

	PlanPanel() {

		AuthUser();

		System.out.println("auth");
	}

	private void InitPanel() {
		System.out.println("we ok");

	}

	private void AuthUser() {
		auth = new Auth();

		auth.addComponentListener(new ComponentAdapter() {
			public void componentHidden(ComponentEvent e) {
				user = auth.getUserKind();
				if (user == Users.ADMIN) {
					InitPanel();
				}
			}
		});

	}

}
