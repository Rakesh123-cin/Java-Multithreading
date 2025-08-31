package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockOptimisticMain {

	public static void main(String[] args) {
		
		StampedLock lock = new StampedLock();
		
		StampedLockOptimistic obj1 = new StampedLockOptimistic();
		
		Thread th1 = new Thread(()->{
			obj1.produce(lock);
		});
		
        StampedLockOptimistic obj2 = new StampedLockOptimistic();
		
		Thread th2 = new Thread(()->{
			obj2.consume(lock);
		});
		
		th1.start();
		th2.start();
	}

}
