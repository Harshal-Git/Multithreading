/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 *
 *	-> original case : main thread may OR may not print correct calculation result and that's where the issue lies.
 */
public class Case1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CounterThread1 ct1 = new CounterThread1();
		Thread t1 = new Thread(ct1); 
		t1.start();
		
		// main thread printing count
		System.out.println("Total from main thread: "+ct1.getTotal());
	}
}