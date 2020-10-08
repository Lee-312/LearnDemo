package com.lee.JAVA编程思想.Part8_多态;

public class Wind extends Instrument {
	@Override
	void play(Note n) {
		System.out.println(" Wind.play() " + n);
	}
}
