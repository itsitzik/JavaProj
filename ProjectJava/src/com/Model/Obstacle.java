package com.Model;

public class Obstacle {
	protected int xPos, yPos;

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setxPos(String xPos) {
		try {
			this.xPos = Integer.parseInt(xPos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public void setyPos(String yPos) {
		try {
			this.yPos = Integer.parseInt(yPos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
