package com.lee.JAVA编程思想.Part7_复用类;

class SpaceShipControls{
	void up(int velocity){}
	void down(int velocity){}
	void left(int velocity){}
	void right(int velocity){}
	void forward(int velocity){}
	void back(int velocity){}
	void turboBoost(int velocity){}
}
public class SpaceShip extends SpaceShipControls {
	private String name;
	public SpaceShip(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		SpaceShip spaceShip = new SpaceShip("NSEA");
		spaceShip.forward(100);
	}
}
