package com.rakesh.MultiThreading.LockFree;

public class SingleThreadMain {

	public static void main(String[] args) {
		
		SingleThread obj = new SingleThread();
		
		for(int i=1;i<=400;i++)
		{
			obj.increment();
		}
		
		System.out.println(obj.get());

	}

}
