package com.mytest;

/**
 * 创建线程的四种方法
 * 1.extends Thread
 * 2.implements Runnable
 * 3.implements Callable
 * 4.ThreadPool
 */
public class MyThread implements Runnable{

	public static void main(String[] args) {
		Thread th = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		});
		th.start();
	}

	@Override
	public void run() {



	}
}
