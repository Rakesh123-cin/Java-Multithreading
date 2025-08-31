package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEg {
	
	private boolean isAvailable = false;
	
	public void producer(ReentrantLock lock)
	{
		try{ 
			lock.lock();
		    System.out.println("Lock acquired by :"+ Thread.currentThread().getName());
		    isAvailable = true;
		
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Lock released by :"+ Thread.currentThread().getName());
			lock.unlock();
		}
	}

}
