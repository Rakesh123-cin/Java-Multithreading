package com.rakesh.MultiThreading;

public class DaemonThreadMain {

	public static void main(String[] args) {
        System.out.println("Main thread started");
		
		DaemonThread obj = new DaemonThread();
		
		Thread th1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName()+ " calling produce method");
			obj.produce();
	    });
		
		th1.setDaemon(true); // Daemon thread
		
		th1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Main thread has finished its work");
	}

}
