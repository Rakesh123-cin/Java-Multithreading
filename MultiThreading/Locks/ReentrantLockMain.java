package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {
	
	public static void main(String[] args)
	{
		ReentrantLock lock = new ReentrantLock();
		
		ReentrantLockEg obj1 = new ReentrantLockEg();
		Thread th1 = new Thread(()->
		{
			obj1.producer(lock);
		});
		
		ReentrantLockEg obj2 = new ReentrantLockEg();
		Thread th2 = new Thread(()->
		{
			obj2.producer(lock);
		});
		
		th1.start();
		th2.start();
	}

}
