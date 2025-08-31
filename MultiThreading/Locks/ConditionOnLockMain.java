package com.rakesh.MultiThreading.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class ConditionOnLockMain {

	public static void main(String[] args) {
		
		ConditionOnLocks obj1 = new ConditionOnLocks();
		
		Thread th1 = new Thread(()->{
			for(int i=1;i<=2;i++)
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				
				}
				obj1.producer();
			}
		});
		
		
		Thread th2 = new Thread(()->{
			for(int i=1;i<=2;i++)
			{
				obj1.consumer();
			}
		});
		
		th1.start();
		th2.start();

	}

}
