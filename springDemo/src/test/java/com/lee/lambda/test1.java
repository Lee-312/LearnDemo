package com.lee.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class test1 {
	public static void main(String[] args) {
		String[] plantes = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
		System.out.println("使用长度从小到大比较器");

		class LengthAsComparator implements Comparator<String> {
			@Override
			public int compare(String fir, String sec) {
				int len1 = (fir == null ? 0 : fir.length());
				int len2 = (sec == null ? 0 : sec.length());
				return len1 - len2;
			}
		};
		//Arrays.sort(plantes, new LengthAsComparator());
		System.out.println("使用Lambda表达式");
		Arrays.sort(plantes,(String fir,String sec) -> fir.length() - sec.length());

		System.out.println(Arrays.toString(plantes));


		//Predicate<T>接收一个参数，返回一个boolean值
		System.out.println("Predicate<T>========================");
		Predicate<String> oddLength = s -> s.length()%2 == 0 ? false:true;
		for (String p : plantes){
			if(oddLength.test(p)){
				System.out.print(p+"\t");
			}
		}
		System.out.println();
		//Consumer<T>接收一个参数，做操作，无返回
		System.out.println("Consumer<T>========================");
		Consumer<String> printer = s -> System.out.print("Planet :"+s+",\t");
		for (String p : plantes) {
			printer.accept(p);
		}
		System.out.println();
		//Supplier<T>无输入参数，返回一个数据
		System.out.println("Supplier<T>========================");
		Supplier<String> planetFactory = () -> plantes[(int)floor(random()*8)];
		for (int i = 0; i < 5; i++) {
			System.out.print(planetFactory.get()+"  ");
		}
		System.out.println();
		//Funcition<T>接收一个参数，返回一个参数
		System.out.println("Function<T>========================");
		Function<String,String> upper = s ->  s.toUpperCase();
		for (String p : plantes) {
			System.out.print(upper.apply(p)+"  ");
		}

		/**
		 * 方法引用
		 * Class::staticMethod 如：Math::abs
		 * Clsss::instanceMethod 如：String::comparaToIgnoreCase
		 * Class::instanceMethod 如：System.out::printLn
		 * Class::new 调用某类构造函数，支持单个对象构建
		 * CLass[]::new 调用某类构造函数，支持数组对象构建
		 */

	}

}
