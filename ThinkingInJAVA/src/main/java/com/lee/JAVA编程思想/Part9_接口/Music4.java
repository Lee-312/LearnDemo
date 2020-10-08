package com.lee.JAVA编程思想.Part9_接口;

import com.lee.JAVA编程思想.Part8_多态.Note;

public class Music4 {
	static public void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	static public void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}

	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed()
		};
		tuneAll(orchestra);
	}
}

abstract class Instrument {
	private int i;

	public abstract void play(Note n);

	public String what() {
		return "Instrument";
	}

	public abstract void adjust();
}

class Wind extends Instrument {

	@Override
	public void play(Note n) {
		System.out.println(" Wind.play() " + n);
	}

	@Override
	public String what() {
		return "Wind";
	}

	@Override
	public void adjust() {

	}
}

class Percussion extends Instrument {

	@Override
	public void play(Note n) {
		System.out.println(" Percussion.play() " + n);
	}

	@Override
	public String what() {
		return "Percussion";
	}

	@Override
	public void adjust() {

	}
}

class Stringed extends Instrument {

	@Override
	public void play(Note n) {
		System.out.println(" Stringed.play() " + n);
	}

	@Override
	public String what() {
		return "Stringed";
	}

	@Override
	public void adjust() {

	}
}
