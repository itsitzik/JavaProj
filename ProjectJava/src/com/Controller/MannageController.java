package com.Controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import com.Model.ManageModel;
import com.Model.TableData;
import com.Model.TimePicker;
import com.Model.ManageMode;
import com.Model.PaintMode;
import com.Model.RestData;
import com.Model.Table;
import com.View.ManagePanelView;
import com.View.ManageView;
import com.View.RestInfo;
import com.View.TableFree;
import com.View.TablePref;

public class MannageController {

	ManageModel manageModel;
	ManageView manageView;
	ManageMode manageMode;
	FindTable findTable;

	public MannageController(ManageModel manageModel, ManageView manageView) {
		this.manageModel = manageModel;
		this.manageView = manageView;
		manageMode = ManageMode.INIT;

		addToolbarListeners();
		addManagePanelListeners();
		addToolOpenCloseListeners();

		openRest();
		addFindTableSys();

	}

	// add listeners functions

	private void addToolbarListeners() {

		manageView.getJtool().getRestInfoButton().addActionListener(e -> showInfo());
		manageView.getJtool().getFindTableButton().addActionListener(e -> findTable());

	}

	private void addFindTableSys() {
		findTable = new FindTable(manageModel.getTables());
		findTable.getConfirm().addActionListener(e -> addFoundTable());
	}

	private void addFoundTable() {
		int index;
		try {
			index = (int) findTable.getList().getValueAt(findTable.getList().getSelectedRow(), 0);
			if (index >= 0) {
				if(manageModel.getTables().get(index).getTaken() == false) {
					sitGuests(index);
				} else {
					addToWaiting(index);
				}
				findTable.dispatchEvent(new WindowEvent(findTable, WindowEvent.WINDOW_CLOSING));
			} else {
				JOptionPane.showMessageDialog(findTable, "Please select table from the list table");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(findTable, "System Error: Table not found");
		}
		
	}

	private void addToWaiting(int index) {
		manageModel.addWait(index);
	}

	private void findTable() {
		findTable.showFind();
	}

	private void showInfo() {
		RestInfo.showInfo(manageModel.getRestInfo());
	}

	private void addManagePanelListeners() {
		manageView.getManagePanel().addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					mannagePanelClicked(e);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}

		});
	}

	private void addToolOpenCloseListeners() {
		manageView.getJtool().getOpenRestButton().addActionListener(e -> openRest());
		manageView.getJtool().getCloseRestButton().addActionListener(e -> closeRest());
	}

	// save load functions

	private void openRest() {
		manageMode = ManageMode.WORKING;
		manageModel.setRestInfo(LocalTime.now(), TimePicker.getTime(), 0, 0,0);
		manageModel.loadModel();
		manageView.getJtool().openButtonsState();
	}

	private void closeRest() {
		int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the restaurent for today?", "",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			manageMode = ManageMode.CLOSE;
			manageView.getJtool().closeButtonsState();
			manageModel.cleanModel();
		}
	}

	private void saveRest() {
		System.out.println("N/A");
//		mannageModel.saveModel();
	}

	private void mannagePanelClicked(MouseEvent e) {
		System.out.println("N/A");

		int xPos, yPos;
		xPos = (e.getX() - (e.getX() % 100)) / 100;
		yPos = (e.getY() - (e.getY() % 100)) / 100;
		int TableInd = manageModel.getTableIndexByXY(xPos, yPos);

		if (TableInd != -1) {
			if (!manageModel.getIsTakenByIndex(TableInd)) {
				sitGuests(TableInd);
				System.out.println("Table " + TableInd + " is now taken...");
			} else {
				freeGuests(TableInd);
				System.out.println("Table " + TableInd + " is now free...");
			}
		}

//		System.out.println("No new Tables Created...");
	}

	private void freeGuests(int tableInd) {
		int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to free table number: " + tableInd + "?", "",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			TableFree tableFree = new TableFree();
			manageModel.freeTable(tableInd, tableFree.getBillData());
			if(manageModel.isWaiting(tableInd)) {
				sitGuests(tableInd);
				manageModel.clearWait(tableInd);
			}
		}

	}

	private void sitGuests(int tableInd) {
		int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to sit on table number: " + tableInd + "?", "",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			manageModel.sitGuests(tableInd);

		}
	}

}
