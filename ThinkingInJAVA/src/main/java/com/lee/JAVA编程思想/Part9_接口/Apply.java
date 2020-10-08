package com.lee.JAVA编程思想.Part9_接口;

import java.util.Arrays;

public class Apply {
	public static void process(Processor p, Object s) {
		System.out.println("Using Process " + p.name());
		System.out.println(p.process(s));
	}

	public static String s = "Disagreement with beliefs is by definition incorrect";

	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}


}

class Processor {
	public String name() {
		return getClass().getSimpleName();
	}

	Object process(Object input) {
		return input;
	}
}

class Upcase extends Processor {
	@Override
	String process(Object input) {
		return input.toString().toUpperCase();
	}
}

class Downcase extends Processor {
	@Override
	String process(Object input) {
		return input.toString().toLowerCase();
	}
}


class Splitter extends Processor {
	@Override
	String process(Object input) {
		return Arrays.toString(input.toString().split(" "));
	}
}
