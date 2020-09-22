package com.mytest;

/**
 * 消费者生产者模式【缓冲区】-->管程法
 */
public class CoTest1 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Thread(new Productor(container)).start();
		new Thread(new Consumer(container)).start();
	}
}

//生产者
class Productor implements Runnable {
	SynContainer container;

	public Productor(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		//生产
		for (int i = 0; i < 100; i++) {
			System.out.println("生产第" + i + "个货物");
			container.push(new Something(i));
		}
	}
}

//消费者
class Consumer implements Runnable {
	SynContainer container;

	public Consumer(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		//消费
		for (int i = 0; i < 100; i++) {
			System.out.println("消费第" + i + "个货物");
			container.pop();
		}
	}
}

//缓冲区
class SynContainer {
	Something[] st = new Something[10];
	int index = 0;

	//存
	public synchronized void push(Something s) {
		// 货物慢时，线程等待，等待消费者通知
		if (index == st.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		st[index] = s;
		index++;
		this.notifyAll();// 唤醒消费者
	}

	//取
	public synchronized Something pop() {
		// 无货物时，线程等待，等待生产者通知
		if (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		index--;
		this.notifyAll();// 唤醒生产者
		return st[index];
	}

}

//物品
class Something {
	int id;

	public Something(int id) {
		this.id = id;
	}
}
