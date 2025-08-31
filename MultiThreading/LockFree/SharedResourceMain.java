package com.rakesh.MultiThreading.LockFree;

public class SharedResourceMain {

	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		
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
