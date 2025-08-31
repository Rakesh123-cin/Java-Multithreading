package com.rakesh.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
	
	private Queue<Integer> sharedBuffer;
	private int bufferSize;
	
	public ProducerConsumerProblem(int bufferSize)
	{
		sharedBuffer = new LinkedList<>();
		this.bufferSize= bufferSize;
	}
	
	public synchronized void produce(int item) throws InterruptedException
	{
		// If Buffer is full, wait for the consumer to consume items
		while(sharedBuffer.size()==bufferSize)
		{
			System.out.println("Buffer is full, producer is waiting for consumer ");
			wait();
		}
		
		sharedBuffer.offer(item);
		System.out.println("produced : "+item);
		
		// Notify the consumer that there are items to consume now
		notify();
	}
	
	public synchronized int consume() throws InterruptedException
	{
		// If Buffer is empty, wait for the producer to produce items
		while(sharedBuffer.isEmpty())
		{
			System.out.println("Buffer is empty, consumer is waiting for producer ");
			wait();
		}
		
		int item = sharedBuffer.poll();
		System.out.println("Consumed : "+item);
		
		// Notify the producer that there is space in the buffer now
		notify();
		return item;
	}
}
