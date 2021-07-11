/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 *
 *	-> approach 1: main thread will print correct result if we put it in sleep for a while to let the calculation complete.
 *
 *	-> not a good approach as we can never know in advance how much time actual computation will take and that much time will 
 *		be wasted.
 */
public class Case2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CounterThread1 ct1 = new CounterThread1();
		Thread t1 = new Thread(ct1); 
		t1.start();
		
		// main thread will sleep for a while and then prints the data
		try {
			Thread.sleep(0, 1);
		} catch (InterruptedException e) {
			System.out.println("main() thread interrupted.");
		}
		System.out.println("Total from main thread: "+ct1.getTotal());
	}
}
