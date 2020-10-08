package com.lee.JAVA编程思想.Part8_多态;

public class Music {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute);
	}
}


