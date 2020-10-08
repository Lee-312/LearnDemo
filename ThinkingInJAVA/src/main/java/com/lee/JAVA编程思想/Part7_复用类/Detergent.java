package com.lee.JAVA编程思想.Part7_复用类;

class Cleanser {
	private String s = "Cleanser";

	public void append(String s) {
		this.s += s;
	}

	public void dilute() {
		append(" dilute() ");
	}

	public void apply() {
		append(" apply() ");
	}

	public void scrub() {
		append(" scrub() ");
	}

	@Override
	public String toString() {
		return this.s;
	}

	public static void main(String[] args) {
		Cleanser c = new Cleanser();
		c.dilute();
		c.apply();
		c.scrub();
		System.out.println(c);
	}
}

public class Detergent extends Cleanser {
	@Override
	public void scrub() {
		append(" Detergeent.scrub() ");
		super.scrub();
	}

	public void foam() {
		append(" foam() ");
	}

	public static void main(String[] args) {
		Detergent d = new Detergent();
		d.dilute();
		d.apply();
		d.scrub();
		d.foam();
		System.out.println(d);
		System.out.println(" Test base clase");
		Cleanser.main(args);
	}

}
