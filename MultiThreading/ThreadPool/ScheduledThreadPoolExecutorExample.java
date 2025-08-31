package com.rakesh.MultiThreading.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

	public static void main(String[] args) {
		
		ScheduledExecutorService poolExecutor = Executors.newScheduledThreadPool(5);
		
		Future<?> futureObj1= poolExecutor.schedule(()->{
			System.out.println("Thread name: "+Thread.currentThread().getName());
			System.out.println("Hello World!");
		}, 2, TimeUnit.SECONDS);
//		
		
//		Future<?> futureObj2 = poolExecutor.scheduleAtFixedRate(()->
//		{
//			System.out.println("Radhe Radhe");
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Happy Janamashtmi!");
//		}, 3, 5, TimeUnit.SECONDS);
//		
//		
//		try {
//			Thread.sleep(35000);
//			futureObj2.cancel(true);
//			poolExecutor.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Future<?> futureObj2 = poolExecutor.scheduleWithFixedDelay(()->
		{
			System.out.println("Thread name: "+Thread.currentThread().getName());
			System.out.println("Radhe Radhe");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Happy Janamashtmi!");
		}, 3, 5, TimeUnit.SECONDS);
		
		
		try {
			Thread.sleep(55000);
			futureObj2.cancel(true);
			poolExecutor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
