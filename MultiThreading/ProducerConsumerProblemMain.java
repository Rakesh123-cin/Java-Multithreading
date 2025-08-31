package com.rakesh.MultiThreading;

public class ProducerConsumerProblemMain {

	public static void main(String[] args) {
		
		ProducerConsumerProblem obj = new ProducerConsumerProblem(3);
		
		// creating producer thread using lambda expression
		
		Thread producerThread = new Thread(()->{
			for(int i=1;i<=6;i++)
				try {
					obj.produce(i);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		});
		
		// creating consumer thread using lambda expression
		
		Thread consumerThread = new Thread(()->{
			for(int i=1;i<=6;i++)
				try {
					obj.consume();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		});
		
		producerThread.start();
		consumerThread.start();
	}

}
