package com.mytest;

/**
 * Volatile保证数据的同步，不保证数据的原子性
 */
public class VolatileTest {
	//private static int num = 0;
	private volatile static int num = 0;

	public static void main(String[] args) throws InterruptedException {

		new Thread(() -> {
			while (num == 0) {
			}
		}).start();

		Thread.sleep(1000);
		num = 1;
	}
}
