package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLockEg {
	
	boolean isAvailable = true;
	
	public void producer(ReadWriteLock lock)
	{
		try {
			lock.readLock().lock();
			System.out.println("Read Lock acquired by :"+ Thread.currentThread().getName());
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Read Lock releaed by :"+ Thread.currentThread().getName());
			lock.readLock().unlock();
		}
	}
	
	public void consumer(ReadWriteLock lock)
	{
		try {
			lock.writeLock().lock();
			System.out.println("Write Lock acquired by :"+ Thread.currentThread().getName());
			isAvailable = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Write Lock releaed by :"+ Thread.currentThread().getName());
			lock.writeLock().unlock();
		}
	}

}
