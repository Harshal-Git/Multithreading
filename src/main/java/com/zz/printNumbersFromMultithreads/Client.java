/**
 * 
 */
package com.zz.printNumbersFromMultithreads;

/**
 * @author Harshal-Git
 *
 *	-> Print given number in given range by given number of threads.
 *
 *	-> ex: Print numbers from 1 -> 20 by 3 threads.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RunnableService r1 = new RunnableService(0);
		RunnableService r2 = new RunnableService(1);
		RunnableService r3 = new RunnableService(2);
		
		// prepare threads
		Thread t1 = new Thread(r1, "T1");
		Thread t2 = new Thread(r2, "T2");
		Thread t3 = new Thread(r3, "T3");
		
		// start threads
		t1.start();
		t2.start();
		t3.start();
	}
}
