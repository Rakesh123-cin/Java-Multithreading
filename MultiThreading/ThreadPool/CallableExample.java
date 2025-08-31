package com.rakesh.MultiThreading.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,5,TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
				Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
		
		executor.allowCoreThreadTimeOut(true);
		
		// Use Case -1
		Future<?> futureObj1 = executor.submit(()->{
			System.out.println("Task1 with Runnable");
		});
		
		try {
			Object result = futureObj1.get();
			System.out.println(result==null);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
		
		// Use case-2
		List<Integer> output = new ArrayList<>();
		Future<List<Integer>> futureObj2 = executor.submit(()->{
			output.add(100);
			System.out.println("Task2 with Runnable and Return output");
		},output);
		
		try {
			List<Integer> result = futureObj2.get();
			System.out.println(result.get(0));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		// Use Case - 3
		Future<List<Integer>> futureObj3 = executor.submit(()->{
			System.out.println("Task3 with Callable");
			List<Integer> list = new ArrayList<>();
			list.add(200);
			return list;
		});
		
		try {
			List<Integer> result = futureObj3.get();
			System.out.println(result.get(0));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		executor.close();

	}

}
