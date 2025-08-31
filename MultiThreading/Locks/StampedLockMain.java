package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockMain {

	public static void main(String[] args) {
		StampedLock lock = new StampedLock();
		
		StampedLockReadWriteVersion obj1 = new StampedLockReadWriteVersion();
		
		Thread th1 = new Thread(()->{
			obj1.producer(lock);
		});
		
		Thread th2 = new Thread(()->{
			obj1.producer(lock);
		});
		
		StampedLockReadWriteVersion obj2 = new StampedLockReadWriteVersion();
		
		Thread th3 = new Thread(()->{
			obj2.consumer(lock);
		});
		
		th1.start();
		th2.start();
		th3.start();
	}

}
