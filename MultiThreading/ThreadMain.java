package com.rakesh.MultiThreading;

public class ThreadMain {

	public static void main(String[] args) {
        System.out.println("Main thread started");
		
		ThreadJoin obj = new ThreadJoin();
		
		Thread th1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName()+ " calling produce method");
			obj.produce();
	    });
		
		th1.start();
		
		try {
			System.out.println("Main thread waiting for Thread-0 to finish its work");
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Main thread has finished its work");
	}

}
