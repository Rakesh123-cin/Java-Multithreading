package com.rakesh.MultiThreading;

public class DeadLockMain {

	public static void main(String[] args) {
		
		System.out.println("Main thread started");
		
		DeadLock obj = new DeadLock();
		
		Thread th1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName()+ " calling produce method");
			obj.produce();
	    });
		
		Thread th2 = new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ " calling produce method");
			obj.produce();
	    });
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread-0 is suspended");
		
		th1.suspend();
		
		System.out.println("Main thread is finishing its work");
	}
}
