package com.lee.Part15;

//二维元组
public class TwoTuple<A, B> {
	private final A first;
	private final B second;

	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "first=" + first + ", second=" + second;
	}
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	private final C third;

	public ThreeTuple(A first, B second, C third) {
		super(first, second);
		this.third = third;
	}

	@Override
	public String toString() {
		return super.toString() + ", third=" + third;
	}
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	private final D fourth;

	public FourTuple(A first, B second, C third, D fourth) {
		super(first, second, third);
		this.fourth = fourth;
	}

	@Override
	public String toString() {
		return super.toString() + ", fourth=" + fourth;
	}
}

class FireTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
	private final E fifth;

	public FireTuple(A first, B second, C third, D fourth, E fifth) {
		super(first, second, third, fourth);
		this.fifth = fifth;
	}

	@Override
	public String toString() {
		return super.toString() + ", fifth=" + fifth;
	}

}

class Amphibian {
}

class Vehicle {
}

class TupleTest {
	static TwoTuple<String, Integer> f() {
		return new TwoTuple("hi", 47);
	}

	static ThreeTuple<Amphibian, String, Integer> g() {
		return new ThreeTuple(new Amphibian(), "hi", 47);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return new FourTuple(new Vehicle(), new Amphibian(), "hi", 47);
	}

	static FireTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return new FireTuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1D);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}
