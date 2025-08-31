package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockOptimistic {
	int a =10;
	
	public void produce(StampedLock lock)
	{
		long stamp = lock.tryOptimisticRead();
		try {
			System.out.println("Taken Optimistic Read");
			a=11;
			Thread.sleep(6000);
			if(lock.validate(stamp))
			{
				System.out.println("Updated the value successfully");
			}
			else
			{
				System.out.println("Rollback of work");
				a=10; // rollback
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void consume(StampedLock lock)
	{
		long stamp = lock.writeLock();
		try
		{
			System.out.println("Write Lock acquired by :"+ Thread.currentThread().getName());
			System.out.println("Performing task");
			a=9;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Write Lock relesed by :"+ Thread.currentThread().getName());
			lock.unlockWrite(stamp);
		}
	}
}
