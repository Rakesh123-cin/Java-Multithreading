package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {

	public static void main(String[] args) {
		
		Semaphore lock = new Semaphore(3);
		
		SemaphoreLock obj = new SemaphoreLock();
		
		Thread th1 = new Thread(()->{
			obj.producer(lock);
		});
		
		Thread th2 = new Thread(()->{
			obj.producer(lock);
		});
		
		Thread th3 = new Thread(()->{
			obj.producer(lock);
		});
		
		Thread th4 = new Thread(()->{
			obj.producer(lock);
		});
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}
