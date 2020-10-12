package com.lee.JAVA编程思想.Part14_类型信息;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegisteredFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.createRandom());
		}
	}
}

class Part {

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}


	static List<Factory<? extends Part>> factories = new ArrayList<>();

	static {
		factories.add(new FuelFilter.Factory());
		factories.add(new AirFilter.Factory());
		factories.add(new CabinAirFilter.Factory());
		factories.add(new OilFilter.Factory());
		factories.add(new FanBelt.Factory());
		factories.add(new PowerSteeringBelt.Factory());
		factories.add(new GeneratorBelt.Factory());
	}

	private static Random rand = new Random(47);

	public static Part createRandom() {
		int n = rand.nextInt(factories.size());
		return factories.get(n).create();
	}

}

interface Factory<T> {
	T create();
}

class Filter extends Part {
}

class FuelFilter extends Filter {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<FuelFilter> {
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}


class AirFilter extends Filter {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<AirFilter> {
		@Override
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinAirFilter extends Filter {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<CabinAirFilter> {
		@Override
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<OilFilter> {
		@Override
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<FanBelt> {
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<GeneratorBelt> {
		@Override
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements com.lee.JAVA编程思想.Part14_类型信息.Factory<PowerSteeringBelt> {
		@Override
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}