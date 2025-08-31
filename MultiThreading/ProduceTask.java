package com.rakesh.MultiThreading;

public class ProduceTask implements Runnable{
	
	private SharedResourceExample sharedResource;
	
	public ProduceTask(SharedResourceExample sharedResource)
	{
		this.sharedResource = sharedResource;
	}
	
	@Override
	public void run()
	{
		System.out.println("Producer thread "+ Thread.currentThread().getName());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		sharedResource.addItem();
	}

}
