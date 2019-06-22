package com.Model;

public class TableData{
	private int people = 0;
	private Boolean smk = false;
	
	public TableData() {
	}
	
	public TableData(int p, Boolean smk) {
		this.people = p;
		this.smk = smk;
	}
	
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public Boolean getSmk() {
		return smk;
	}
	public void setSmk(Boolean smk) {
		this.smk = smk;
	}
}
