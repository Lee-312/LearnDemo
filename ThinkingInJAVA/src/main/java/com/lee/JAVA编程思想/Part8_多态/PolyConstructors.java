package com.lee.JAVA编程思想.Part8_多态;

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;

	public RoundGlyph(int r) {
		radius = r;
		System.out.println(" RoundGlyph.RoundGlyph(),radius= " + radius);
	}

	@Override
	void draw() {
		System.out.println(" RoundGlyph.draw(),radius= " + radius);
	}
}

class Glyph {
	void draw() {
		System.out.println(" Glyph.draw() ");
	}

	public Glyph() {
		System.out.println(" Glyph before draw ");
		draw();
		System.out.println(" Glyph after draw ");
	}
}