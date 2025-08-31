package com.rakesh.MultiThreading.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CustomThreadFactory implements ThreadFactory
{

	@Override
	public Thread newThread(Runnable r) {
		Thread th = new Thread(r);
		th.setDaemon(false);
		th.setPriority(Thread.NORM_PRIORITY);
		return th;
	}
	
}

class CustomRejectedHandler implements RejectedExecutionHandler
{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task rejected "+ r.toString());
		
	}
	
}

public class ThraedPoolExecutorImpl {
	
	public static void main(String[] args)
	{
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5,TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(2), new CustomThreadFactory(),new CustomRejectedHandler());
		
		executor.allowCoreThreadTimeOut(true);
		
		for(int i=1;i<=4;i++)
		{
			executor.submit(()->{
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task processed by : "+ Thread.currentThread().getName());
			});
		}
		
		executor.close();
			
	}

}
