package com.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;

import com.Model.Table;
import com.View.MannageView;
import com.Model.PaintMode;

public class MannageModel extends Observable {

	List<Table> tables = new ArrayList<Table>();

	public MannageModel(MannageView mannageView) {
		super.addObserver(mannageView.getMannagePanel());
	}

	public void notifyAllObservers() {
		setChanged();
		super.notifyObservers(tables);
	}

	public List<Table> getTables() {
		return tables;
	}

}
