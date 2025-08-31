package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionOnLocks {
	
	boolean itemAvailable = false;
	
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public void producer()
	{
		try {
			lock.lock();
			System.out.println("Producer lock acquired by :"+ Thread.currentThread().getName());
			
			if(itemAvailable)
			{
				System.out.println("Producer is waiting for consumer to consume "+Thread.currentThread().getName());
				condition.await();
			}
			
			itemAvailable = true;
			condition.signal();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			System.out.println("Producer lock released by :"+ Thread.currentThread().getName()+ " after producing");
			lock.unlock();
		}
	}
	
	public void consumer()
	{
		try {
			Thread.sleep(2000);
			lock.lock();
			System.out.println("Consumer lock acquired by :"+ Thread.currentThread().getName());
			
			if(!itemAvailable)
			{
				System.out.println("Consumer is waiting for Producer to produce "+Thread.currentThread().getName());
				condition.await();
			}
			
			itemAvailable = false;
			condition.signal();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			System.out.println("Consumer lock released by :"+ Thread.currentThread().getName()+" after consuming");
			lock.unlock();
		}
	}
}
