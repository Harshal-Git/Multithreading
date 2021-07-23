/**
 * 
 */
package com.forkJoin.RecursiveActionDemo;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Harshal-Git
 *
 *	-> A recursive action demo (no return type) to fill a really huge array with some random number
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// expected array in which data is to be filled
		long [] data = new long[10000000];
		
		// prepare a RecursiveAction task
		ArrayFillerAction task = new ArrayFillerAction(data, 0, (data.length-1));
		
		// fork-join pool
		ForkJoinPool fjPool = new ForkJoinPool();
		fjPool.submit(task);
		
		// join the task to finish
		task.join();
		
		System.out.println("Data size: "+data.length);
		System.out.println("Data @ half position: "+data[(data.length-1)/2]);
		//System.out.println("Divisions done: "+task.printDivisionsFromBuffer());
	}
}
