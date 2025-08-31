package com.rakesh.MultiThreading.LockFree;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResourceLockFreeSolution {
	
	AtomicInteger counter = new AtomicInteger(0);
	
	public void increment()
	{
		counter.incrementAndGet();
	}
	
	public int get()
	{
		return counter.get();
	}
	
}
