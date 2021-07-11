/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 *
 *	-> approach 2: until the calculation is done; main thread can wait to join() child thread's execution.
 *
 *	-> this is also not good approach as main thread will wait for the full execution of child thread which may take it's own time
 *		doing many other operations apart from calculating total. This will unnecessary increase result calculation time.
 */
public class Case3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CounterThread1 ct1 = new CounterThread1();
		Thread t1 = new Thread(ct1); 
		t1.start();
		
		// main thread will wait for the t1 calculation to get over
		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println("t1.join() interrupted.");
		}
		System.out.println("Total from main thread: "+ct1.getTotal());
	}
}
