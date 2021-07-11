/**
 * 
 */
package com.threadDeadlock.withJoin;

/**
 * @author Harshal-Git
 *
 *	-> A DEAD LOCK: Main thread waiting for completion of main thread : DEAD LOCK BY JOIN METHOD.
 */
public class SimplestDeadlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// main thread; waiting for main thread to complete it's execution
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted.");
		}
	}
}