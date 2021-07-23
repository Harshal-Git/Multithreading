/**
 * 
 */
package com.forkJoin.forkJoinTaskDemo;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Harshal-Git
 *
 *	-> How to calculate Fibonacci series in multithreaded way using "RecursiveTask -> ForkJoinTask"? 
 *
 *	-> Too much slow compared to iterative approach. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// series end
		long seriesNumber = 45;
		
		// prepare the computation object
		Fibonacci fb = new Fibonacci(seriesNumber);
		
		// feed the object to pool
		long startTime = System.currentTimeMillis();
	
		// use all processors
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("Task has been initiated for Fib("+seriesNumber+")...");
		
		// invoke computation
		Long result = pool.invoke(fb);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Fib("+seriesNumber+") = "+result);
		
		// print total time taken
		System.out.println("Time = "+((endTime-startTime)/1000)+" s.");
	}
}
