package com.lee.Task;


public class Demo1 {
	public volatile static boolean flag = true;

	public static void main(String[] args) throws InterruptedException {
		StopThread thread = new StopThread();
		thread.start();
		Thread.sleep(1000L);
		/**
		 *  不正确的线程终止 -- stop， 未保证同步代码块中数据等待一致性，破环了线程安全
		 * 	正确的线程终止 -- interrupt ,如目标线程在调用wait,join,sleep方法时被阻塞，那么interrupt会生效，该线程中断状态将被清除，抛出InterruptedException异常
		 * 		如果，目标线程被IO或NIO中的Channel所阻塞，同样，IO操作会被中断或者返回特殊异常值，达到终止线程的目的
		 * 		如不是以上条件，则会设置此线程的中断状态
		 *	正确的线程终止 -- 标志位
		 *
		 */
//		thread.stop();
		thread.interrupt();
		while (thread.isAlive()) {
		}
		thread.print();


		new Thread(() -> {
			while (flag) {
				try {
					System.out.println("运行中~");
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		Thread.sleep(5000L);
		flag = false;
		System.out.println("程序运行结束");

	}

	public static class StopThread extends Thread {
		private int i = 0, j = 0;

		@Override
		public void run() {
			synchronized (this) {
				++i;
				try {
					Thread.sleep(10000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				++j;
			}
		}

		public void print() {
			System.out.println("i=" + i + ",j=" + j);
		}
	}

}
