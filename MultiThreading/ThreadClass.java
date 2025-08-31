package com.rakesh.MultiThreading;

class MyThread extends Thread
{
	public void run()
	{
		System.out.println("Code executed by thread : "+ Thread.currentThread().getName());
	}
}
public class ThreadClass {

	public static void main(String[] args) {
		
		System.out.println("Going inside main method : "+ Thread.currentThread().getName());
		MyThread thread = new MyThread();
		thread.start();
		System.out.println("Finish main method : "+ Thread.currentThread().getName());
	}

}
