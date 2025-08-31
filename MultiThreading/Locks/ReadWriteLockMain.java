package com.rakesh.MultiThreading.Locks;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {

	public static void main(String[] args) {
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		ReadWriteLockEg obj1 = new ReadWriteLockEg();
		
		Thread th1 = new Thread(()->{
			obj1.producer(lock);
		});
		
		Thread th2 = new Thread(()->{
			obj1.producer(lock);
		});
		
		ReadWriteLockEg obj2 = new ReadWriteLockEg();
		
		Thread th3 = new Thread(()->{
			obj2.consumer(lock);
		});
		
		th1.start();
		th2.start();
		th3.start();
	}

}
