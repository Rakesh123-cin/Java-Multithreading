package com.rakesh.MultiThreading.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

	public static void main(String[] args) {
		
		 ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,7,5,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(4),
				 Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
		 poolExecutor.allowCoreThreadTimeOut(true);
		 
		 // 1. supplyAsync()
		 
		 CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
			 System.out.println("Tak1 completed by : "+Thread.currentThread().getName());
			 return "Leaning Multithreading";
		 },poolExecutor);
		 
		 try {
			System.out.println(asyncTask1.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		 
		 // 2. thenApply() & thenApplyAsync()
		 
		 CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(()->
		 {
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 System.out.println("Tak2 completed by : "+Thread.currentThread().getName());
			 return "Learning Java & Spring Boot";
		 },poolExecutor).thenApply((String val)->{
			 System.out.println("Then apply task completed by : "+Thread.currentThread().getName());
			 return val+" from Concept & Coding....";
		 });
		 
		 try {
				System.out.println(asyncTask2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		 
		 CompletableFuture<String> asyncTask3 = asyncTask2.thenApplyAsync((String val)->
		 {
			 System.out.println("Tak3 completed by : "+Thread.currentThread().getName());
			 return val.substring(0, val.length()-4)+" from Basics to Advanced...";
		 });
		 
		 try {
				System.out.println(asyncTask3.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		 
		 // 3. thenCompose() & thenComposeAsync()
		 
		 CompletableFuture<String> asyncTask4 = CompletableFuture.supplyAsync(()->{
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 System.out.println("Tak4 completed by : "+Thread.currentThread().getName());
			 return "Learning Java, Spring Boot ";
		 },poolExecutor).thenComposeAsync((String val)->
		 {
			 System.out.println("Dependent task1 completed by : "+Thread.currentThread().getName());
			 return CompletableFuture.supplyAsync(()->val+" and Microservices ");
		 }, poolExecutor).thenComposeAsync((String val)->{
			 
			 System.out.println("Dependent task2 completed by : "+Thread.currentThread().getName());
			 return CompletableFuture.supplyAsync(()->val+"to be a good Java Backend Developer.... ");
		 },poolExecutor);
		 
		 try {
				System.out.println(asyncTask4.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		 
		 // 4. thenAccept() & thenAcceptAsync()
		 
		 CompletableFuture<Void> asyncTask5 = CompletableFuture.supplyAsync(()->{
				 System.out.println("Tak5 completed by : "+Thread.currentThread().getName());
				 return "Enhancing my skills ";
		 },poolExecutor).thenAccept((String val)->{
			 System.out.println("Then Accept task completed by : "+Thread.currentThread().getName());
			 System.out.println(val+"to become a skilled Software Developer");
		 });
		 
		 poolExecutor.close();
	}

}
