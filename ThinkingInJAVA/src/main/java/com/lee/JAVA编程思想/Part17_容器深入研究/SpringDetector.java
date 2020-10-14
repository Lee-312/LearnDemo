package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SpringDetector {
	public static <T extends Groudhog> void detectSpring(Class type) throws Exception {
		Constructor<T> constructor = type.getConstructor(int.class);
		Map<Groudhog, Prediction> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(constructor.newInstance(i), new Prediction());
		}
		System.out.println(map);

		Groudhog hog = constructor.newInstance(3);
		System.out.println("Looking up prediction for " + hog);
		if (map.containsKey(hog)) {
			System.out.println(map.get(hog));
		} else {
			System.out.println("Key not found " + hog);
		}
	}

	public static void main(String[] args) throws Exception {
		detectSpring(Groudhog.class);
		System.out.println("Override hashCode and equals");
		detectSpring(Groudhog2.class);
	}
}

class Groudhog {
	protected int number;

	public Groudhog(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Groudhog #" + number;
	}
}

class Groudhog2 extends Groudhog {
	public Groudhog2(int n) {
		super(n);
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Groudhog2 && (number == ((Groudhog2) o).number);
	}
}

class Prediction {
	private static Random rand = new Random(47);
	private boolean shadow = rand.nextDouble() > 0.5;

	@Override
	public String toString() {
		if (shadow) {
			return "Six more weeks of Winter";
		} else {
			return "Early Spring";
		}
	}
}
