package com.lee.JAVA编程思想.Part8_多态;

public class Music3 {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}


	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Stringed(),
				new Brass()
		};
		tuneAll(orchestra);
	}
}

