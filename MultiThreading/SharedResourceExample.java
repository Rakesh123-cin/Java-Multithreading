package com.rakesh.MultiThreading;

public class SharedResourceExample {
	
	boolean itemAvailable = false;
	
	//synchronized put the monitor lock
	public synchronized void addItem()
	{
		itemAvailable = true;
		System.out.println("Item added by: "+ Thread.currentThread().getName()+" and invoking all threads which are waiting");
		notifyAll();
	}
	
	public synchronized void consumeItem()
	{
		System.out.println("consumeItem method invoked by "+ Thread.currentThread().getName());
		if(!itemAvailable)
		{
			try {
				System.out.println(Thread.currentThread().getName()+ " is waiting now");
				wait(); // It releases the monitor lock
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Item consumed by : "+ Thread.currentThread().getName());
		itemAvailable = false;
	}
}
