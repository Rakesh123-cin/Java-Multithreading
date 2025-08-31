package com.rakesh.MultiThreading.ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

class ComputeSumTask extends RecursiveTask<Integer>
{
	int start;
	int end;
	
	public ComputeSumTask(int start, int end)
	{
		this.start=start;
		this.end=end;
	}

	@Override
	protected Integer compute() {
		
		if(end-start<=4)
		{
			int totalSum =0;
			for(int i=start;i<=end;i++)
			{
				totalSum+=i;
			}
			return totalSum;
		}
		else
		{
			// split the task
			int mid = (start+end)/2;
			ComputeSumTask leftTask = new ComputeSumTask(start,mid);
			ComputeSumTask rightTask = new ComputeSumTask(mid+1,end);
			
			// fork the subtasks for parallel execution
			leftTask.fork();
			rightTask.fork();
			
			// combine the result of subtasks
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			
			return leftResult+rightResult;
		}
		
	}
	
}
public class ForkJoinPoolExample {

	public static void main(String[] args) {
		
		ForkJoinPool poolExecutor = ForkJoinPool.commonPool();
		Future<Integer> futureObj = poolExecutor.submit(new ComputeSumTask(0,10));
		
		try {
			System.out.println(futureObj.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
