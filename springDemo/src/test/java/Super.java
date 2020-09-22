
public class Super {
	public Super() {
		System.out.println("这是父dao类的构造方法");
		this.show();
		// 子类初始化之前JVM会先调用父类的构造方法。所以你会先看到父类构造器中的代码先执行。执行到show（）的时候，
		// 因为当前的对象类型是子类，而子类又重写了show方法，所以调用的是子类的show（）,父类构造完毕之后才开始调用子类的构造器，就会执行子类的构造方法的代码。
	}

	public void show() {
		System.out.println("这是父类的 Show() 方法");
	}
}

class Sub extends Super {
	public Sub() {
		System.out.println("这是子类的构造方法");
	}

	public void show() {
		System.out.println("这是子类的 show() 方法");
	}

	public static void main(String[] args) {
		new Sub();
	}
}
