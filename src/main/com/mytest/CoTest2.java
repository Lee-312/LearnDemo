package com.mytest;

/**
 * 消费者生产者模式-->信号灯法
 */
public class CoTest2 {
	public static void main(String[] args) {
		TV tv = new TV();
		new Thread(new Player(tv)).start();
		new Thread(new Watcher(tv)).start();
	}
}

//演员
class Player implements Runnable {
	TV tv;

	public Player(TV tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				this.tv.play("电视");
			} else {
				this.tv.play("广告");
			}
		}
	}
}

//观众
class Watcher implements Runnable {
	TV tv;

	public Watcher(TV tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			this.tv.watch();
		}
	}
}

//电视
class TV {
	//信号灯
	String voice;
	boolean flag = true;

	public synchronized void play(String voice) {
		this.voice = voice;
		//演员等待
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("表演了" + voice);
		this.notifyAll();
	}

	public synchronized void watch() {
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("听到了" + voice);
		this.notifyAll();
	}
}