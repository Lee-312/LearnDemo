package com.lee.learn.Part2;

/**
 * 创建线程导致内存溢出
 * 勿运行！！！勿运行！！！勿运行！！！
 */
public class JavaVMStackOOM {
	//勿运行！！！
	private void dontStop() {
		while (true) {

		}
	}

	//勿运行！！！
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	//勿运行！！！
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
