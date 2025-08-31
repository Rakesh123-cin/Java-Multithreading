package com.rakesh.MultiThreading.LockFree;

public class SharedResourceLockBasedSolutionMain {

	public static void main(String[] args) {
		
		SharedResourceLockBasedSolution resource = new SharedResourceLockBasedSolution();
		
		Thread th1 = new Thread(()->{
			for(int i=1;i<=500;i++)
			{
				resource.increment();
			}
		});
		
		Thread th2 = new Thread(()->{
			for(int i=1;i<=500;i++)
			{
				resource.increment();
			}
		});
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		System.out.println(resource.get());
	}

}
