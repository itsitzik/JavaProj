package com.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.xml.transform.TransformerException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.Model.CircleTable;
import com.Model.Obstacle;
import com.Model.SaveLoad;
import com.Model.Table;

public class SaveLoadTest extends SaveLoad {
	
	List<Table> tables;
	List<Table> tableTest;
	List<Obstacle> obstacles;
	
	@Test
	public void test() throws TransformerException {
		
		tables = new ArrayList<Table>();
		tableTest = new ArrayList<Table>();
		obstacles = new ArrayList<Obstacle>();
		Table table;
		
		for(int i = 0; i < 5; i++) {
			table = new CircleTable();
			tables.add(table);
		}
		
		SaveLoad.getInstance().SavePreset(tables, obstacles, "test.xml");
		SaveLoad.getInstance().LoadPreset(tableTest, obstacles, "test.xml");
		
		for(int i = 0; i < 5; i++) {
			assertSame(tables.get(i).getxPos(), tableTest.get(i).getxPos());
			assertSame(tables.get(i).getyPos(), tableTest.get(i).getyPos());
			assertSame(tables.get(i).getTableKind(), tableTest.get(i).getTableKind());
			assertSame(tables.get(i).getPeople(), tableTest.get(i).getPeople());
			assertSame(tables.get(i).isSmoke(), tableTest.get(i).isSmoke());
			
		}

	}

}
