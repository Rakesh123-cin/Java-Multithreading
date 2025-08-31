package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.Semaphore;

public class SemaphoreLock {
	
	boolean isAvailable = false;
	
	public void producer(Semaphore lock)
	{
		try {
			lock.acquire();
			System.out.println("Lock acquired by :"+ Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			System.out.println("Lock released by :"+ Thread.currentThread().getName());
			lock.release();
		}
	}
}
