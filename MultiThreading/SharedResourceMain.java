package com.rakesh.MultiThreading;

public class SharedResourceMain {

	public static void main(String[] args) {
		
		System.out.println("Main method started");
		
		SharedResourceExample obj = new SharedResourceExample();
		
		// producer thread
		Thread producerThread = new Thread(new ProduceTask(obj));
		
		// consumer thread
		
		Thread consumerThread = new Thread(()->{
			System.out.println("Consumer thread "+ Thread.currentThread().getName());
			obj.consumeItem();
		});
		
		// Thread is in runnable state
		
		producerThread.start();
		consumerThread.start();
		
		System.out.println("Main method end");
	}

}
