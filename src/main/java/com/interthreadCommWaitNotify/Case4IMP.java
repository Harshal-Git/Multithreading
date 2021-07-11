/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 *
 *	-> approach 3: expected solution to notify the waiting main thread about completion of the calculation.
 */
public class Case4IMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CounterThread2 ct1 = new CounterThread2();
		Thread t1 = new Thread(ct1); 
		t1.start();

		// send main thread in waiting state; for an update from child thread
		synchronized (t1) {
			try {
				System.out.println("main thread waiting for t1.");
				
				/**
				 * this statement : 
				 * 	-> executed by main thread 
				 * 	-> to make it wait for child thread's notification
				 */
				t1.wait();
				
				System.out.println("main thread got notification.");
			} catch (InterruptedException e) {
				System.out.println("t1.join() interrupted.");
			}
		}
		System.out.println("Total from main thread: "+ct1.getTotal());
	}
}
