package com.rakesh.MultiThreading;

public class MonitorLockExample {
	
	public synchronized void task1()
	{
		System.out.println("Inside task1");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task1 completed");
	}
	
	public void task2()
	{
		System.out.println("Task2, but before synchronized");
		synchronized(this)
		{
			System.out.println("Task2 inside synchronized");
		}
	}
	
	public void task3()
	{
		System.out.println("Inside task3");
	}
}
