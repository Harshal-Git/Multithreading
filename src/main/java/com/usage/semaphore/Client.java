/**
 * 
 */
package com.usage.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Harshal-Git
 *
 *	-> based on the permit we can see that the number of threads accessing the critical area changes.
 *	
 *	-> controlling the number of permits; we can control the thread execution but in any case; output will be always expected.
 *
 *	-> this is using semaphore without any synchronization among all threads.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// custom set permit  
		Semaphore sem = new Semaphore(1);
		
		// prepare runnable instances
		IncrementRunnable r1 = new IncrementRunnable(sem);
		DecrementRunnable r2 = new DecrementRunnable(sem);
		IncrementRunnable r3 = new IncrementRunnable(sem);
		
		// prepare threads
		Thread t1 = new Thread(r1, "Inc1-");
		Thread t2 = new Thread(r2, "Dec-");
		Thread t3 = new Thread(r3, "Inc2-");
		
		// start threads
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("join() operation interrupted.");
		}
		
		// print final count
		System.out.println("Final count result : "+SharedResource.count);
	}
}
