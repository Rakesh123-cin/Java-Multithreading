package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockReadWriteVersion {
	boolean isAvailable = true;
	
	public void producer(StampedLock lock)
	{
		long stamp = lock.readLock();
		try
		{
			System.out.println("Read Lock acquired by :"+ Thread.currentThread().getName());
			Thread.sleep(6000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Read Lock relesed by :"+ Thread.currentThread().getName());
			lock.unlockRead(stamp);
		}
	}
	
	public void consumer(StampedLock lock)
	{
		long stamp = lock.writeLock();
		try
		{
			System.out.println("Write Lock acquired by :"+ Thread.currentThread().getName());
			isAvailable = false;
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
