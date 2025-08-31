package com.rakesh.MultiThreading.LockFree;

public class SingleThread {
	int counter;
	
	public void increment()
	{
		counter++;
	}
	
	public int get()
	{
		return counter;
	}
}
