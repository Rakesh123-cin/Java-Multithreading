package com.rakesh.MultiThreading.LockFree;

public class SharedResourceLockBasedSolution {
	
int counter;
	
	public synchronized void increment()
	{
		counter++;
	}
	
	public int get()
	{
		return counter;
	}

}
