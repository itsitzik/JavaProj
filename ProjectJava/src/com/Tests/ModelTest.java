package com.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.Model.CircleTable;
import com.Model.Model;
import com.Model.Table;

class ModelTest extends Model {

	List<Table> tableTest;
	@Test
	void testTables() {
		tableTest = getTables();
		assertNotNull(tableTest);
	}
	
	@Test
	void testGetIndex() {
		Table table;
		int count = 0;
		int num = 4;
		for(int i = 0;i<num;i++) {
			table = new CircleTable(i,i);
			getTables().add(table);
		}
		
		for(int i = 0;i<10;i++) {
			for(int j=0;j<6;j++) {
				if(getTableIndexByXY(i, j) != -1) count++;
			}
		}
		
		assertSame(num,count);
	}

}
