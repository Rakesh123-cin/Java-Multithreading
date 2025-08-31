package com.rakesh.MultiThreading.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,5,TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(5),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		
		executor.allowCoreThreadTimeOut(true);
		
		Future<?> futureObj = executor.submit(()->{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("This is the task which thread will execute..");
		});
		
		System.out.println("Is done :"+futureObj.isDone());
		
		try {
			futureObj.get(2,TimeUnit.SECONDS);
		}  catch (TimeoutException e) {
			System.out.println(e.toString());
		}
		catch (Exception e){
			
		}
		
		try {
			futureObj.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Is Done : "+ futureObj.isDone());
		System.out.println("Is Cancelled : "+ futureObj.isCancelled());
		
		executor.close();

	}

}
