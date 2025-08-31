package com.rakesh.MultiThreading;

public class ThreadJoin {
	
    boolean itemAvailable = false;
	
	public synchronized void produce()
	{
		System.out.println("Lock acquired");
		itemAvailable = true;
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Lock released");
	}
}
