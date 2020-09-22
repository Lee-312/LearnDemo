package com.mytest;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * quertz调度Demo
 */
public class QuartzTest implements Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("HelloWord" + new Date());
	}
}

class MyJob {
	public static void main(String[] args) throws Exception {
		//1.创建SchedulerFactory工厂
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		//2.从工厂中获取调度器
		Scheduler scheduler = schedulerFactory.getScheduler();
		//3.创建JobDetail(QuartzTest类必须有public修饰)
		JobDetail detail = newJob(QuartzTest.class).withIdentity("job1", "group1").build();
		//4.触发器
		Date runTime = evenSecondDateAfterNow();
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		//5.注册任务和触发器
		scheduler.scheduleJob(detail, trigger);
		//6.启动
		scheduler.start();
	}
}