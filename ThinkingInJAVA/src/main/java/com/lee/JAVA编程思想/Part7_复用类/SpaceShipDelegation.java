package com.lee.JAVA编程思想.Part7_复用类;

/**
 * 代理的使用
 */
public class SpaceShipDelegation {
	private String name ;
	private SpaceShipControls controls = new SpaceShipControls();
	public SpaceShipDelegation(String name){
		this.name = name;
	}
	public void up(int velocity){
		controls.up(velocity);
	}
	public void down(int velocity){
		controls.down(velocity);
	}
	public void left(int velocity){
		controls.left(velocity);
	}
	public void right(int velocity){
		controls.right(velocity);
	}
	public void forward(int velocity){
		controls.forward(velocity);
	}
	public void back(int velocity){
		controls.back(velocity);
	}
	public void turboBoost(int velocity){
		controls.turboBoost(velocity);
	}

	public static void main(String[] args) {
		SpaceShipDelegation spaceShip = new SpaceShipDelegation("NSEA");
		spaceShip.forward(100);
	}
}
