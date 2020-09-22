package com.lee.Part3;

public class Tank {
	int level;
}
class Assignment{
	public static void main(String[] args) {
		/**
		 * 对基本数据类型a=b，那么b的内容就复制给了a，若修改a，而b不会受影响
		 * 当一个对象赋值给另一个对象，实际是将引用从一个地方复制到另一个地方，这意味着若使用c=d，那么c和d都指向原本只有d指向的对象
		 */
		Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.level = 1;
		t2.level = 2;
		System.out.println(t1.level);
		System.out.println(t2.level);
		t1 = t2;
		System.out.println(t1.level);
		System.out.println(t2.level);
		t1.level = 3;
		System.out.println(t1.level);
		System.out.println(t2.level);

		System.out.println("-------------------");

		int a = 10;
		int b = 20;
		System.out.println(a);
		System.out.println(b);
		a = b;
		System.out.println(a);
		System.out.println(b);
		b = 22;
		System.out.println(a);
		System.out.println(b);


	}

}
