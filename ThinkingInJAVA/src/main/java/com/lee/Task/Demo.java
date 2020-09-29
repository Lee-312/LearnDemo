package com.lee.Task;

/**
 * 线程状态，及相互间的切换
 */
public class Demo {
	public static Thread thread;
	public static Demo obj;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("******************* 第一种状态切换 - 新建 -> 运行 -> 终止 *******************");
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" thread1当前状态 " + Thread.currentThread().getState().toString());
				System.out.println(" thread1执行了 ");
			}
		});
		System.out.println(" 没调用start方法，thread1当前状态 " + thread1.getState().toString());
		thread1.start();
		Thread.sleep(2000L);
		System.out.println(" 等待2s，再看thread1当前状态 " + thread1.getState().toString());
		//thread1.start(); //当线程终止后，在调用start，会抛出IllegalThreadStateException异常

		System.out.println();

		System.out.println("******************* 第二种状态切换 - 新建 -> 运行 -> 等待 -> 运行 -> 终止(sleep方式) *******************");
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2500L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(" thread2当前状态 " + Thread.currentThread().getState().toString());
				System.out.println(" thread2执行了 ");
			}
		});
		System.out.println(" 没调用start方法，thread2当前状态 " + thread2.getState().toString());
		thread2.start();
		System.out.println(" 调用start方法，thread2当前状态 " + thread2.getState().toString());
		Thread.sleep(2000L);
		System.out.println(" 等待2s，再看thread2当前状态 " + thread2.getState().toString());
		Thread.sleep(1000L);
		System.out.println(" 等待3s，再看thread2当前状态 " + thread2.getState().toString());

		System.out.println();

		System.out.println("******************* 第二种状态切换 - 新建 -> 运行 -> 阻塞 -> 运行 -> 终止(sleep方式) *******************");
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (Demo.class) {
					System.out.println(" thread2当前状态 " + Thread.currentThread().getState().toString());
					System.out.println(" thread2执行了 ");
				}
			}
		});
		synchronized (Demo.class) {
			System.out.println(" 没调用start方法，thread3当前状态 " + thread3.getState().toString());
			thread3.start();
			System.out.println(" 调用start方法，thread3当前状态 " + thread3.getState().toString());
			Thread.sleep(2000L);
			System.out.println(" 等待2s，再看thread3当前状态 " + thread3.getState().toString());
		}
		Thread.sleep(1000L);
		System.out.println(" 等待3s，再看thread3当前状态 " + thread3.getState().toString());
	}

}
