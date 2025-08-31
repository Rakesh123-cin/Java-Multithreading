package com.rakesh.MultiThreading;


class RunnableImpl implements Runnable
{
	public void run()
	{
		System.out.println("Code executed by thread : "+ Thread.currentThread().getName());
	}
}
public class MultiThreadingLearning {

	public static void main(String[] args) {
		
		System.out.println("Going inside main method : "+ Thread.currentThread().getName());
		RunnableImpl runnableObj = new RunnableImpl();
		Thread thread = new Thread(runnableObj);
		thread.start();
		System.out.println("Finish main method : "+ Thread.currentThread().getName());
	}

}
