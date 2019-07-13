package com.Controller;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.IntegerSyntax;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	JButton confirm, filter;
	JComboBox<Boolean> smk;
	int Choosen;
	String[] colNames = {"id","people","smk", "freetime"};
	DefaultTableModel dtm = new DefaultTableModel(0, 0);
	
	public FindTable(List<Table> tables) {
		this.tables = tables;
		designFrame();
		initSystem();
	}
	
	private void initSystem() {
		

		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				people.setText("");
				smk.setSelectedIndex(0);
				dtm.setRowCount(0);
			}
			@Override
			public void windowActivated(WindowEvent arg0) {}
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
			@Override
			public void windowDeactivated(WindowEvent arg0) {}
			@Override
			public void windowDeiconified(WindowEvent arg0) {}
			@Override
			public void windowIconified(WindowEvent arg0) {}
			@Override
			public void windowOpened(WindowEvent arg0) {}
		});
		
		filter.addActionListener(e -> filterResult());
	}
	
	private void filterResult() {
		dtm.setRowCount(0);
		int enteredPeople;
		try {
			enteredPeople = Integer.parseInt(people.getText());
			if(enteredPeople >= 1) {
				findTable(tables, new TableData(enteredPeople,(Boolean)smk.getSelectedItem()));
			} else {
				JOptionPane.showMessageDialog(this, "Please enter more than positive number of people");
				people.setText("");
			}
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Please enter valid information\n" +  e.getMessage());
			people.setText("");
		}
	}

	private void designFrame() {
		int i = 20;
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setBounds(scrWidth/2 - 175, scrHeight/2 - 250, 350 , 550);
		this.setVisible(false);

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
		smk.setBounds(20, i, 140, 25);
		
		filter = new JButton("Filter");
		mainPanel.add(filter);
		filter.setBounds(180,i,140,25);
		i+=35;
		
		JLabel label3 = new JLabel("|table id:     |seats:        |smoke:       |free time:");
		label3.setFont(new Font("arial", Font.PLAIN, 14));  
		mainPanel.add(label3);
		label3.setBounds(20, i, 300, 20);
		i+=20;
		
		list = new JTable();
		mainPanel.add(list);
		list.setBounds(20, i, 300, 500 - 40 - i);
		list.setVisible(true);
		i+= 500 - 60 - i + 35;
		
		confirm = new JButton("Confirm");
		mainPanel.add(confirm);
		confirm.setBounds(20, i, 300, 25);
		confirm.setVisible(true);
		
		mainPanel.setVisible(true);
		
		dtm.setColumnIdentifiers(colNames);
		list.setModel(dtm);
		list.setDefaultEditor(Object.class, null);

	}
	
	public void showFind() {
		this.setVisible(true);
	}



	private void findTable(List<Table> tables, TableData data) {
		int size = tables.size();
		int timeToFree;
		for(int i = 0; i < size; i++) {
			Table table = tables.get(i);
			if(table.getPeople() >= data.getPeople()) {
				if(table.isSmoke() == data.getSmk()) {
					timeToFree = (int) MINUTES.between(LocalTime.now(), table.getEndTime());
					if(timeToFree < 0) timeToFree = 0;
					if(table.getTaken() == false || timeToFree < 20) { // !!!!change to 20!!!!!!
						dtm.addRow(new Object[] {i,table.getPeople(),table.isSmoke(),timeToFree});
					}

				}
			}
		}

	}
	
	public JButton getConfirm() {
		return confirm;
	}

	public void setConfirm(JButton confirm) {
		this.confirm = confirm;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JTable getList() {
		return list;
	}
}

