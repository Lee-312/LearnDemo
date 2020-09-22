package com.mytest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时调度Demo
 */
public class MyTimeTask {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//timer.schedule(new MyTask(),new Date());//执行一次
		timer.schedule(new MyTask(),1000,5000);//每5s执行一次
	}

}

class MyTask extends TimerTask {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Wake Up!!!");
		}
	}
}
