/**
 * 
 */
package com.zz.printEvenOddWithArrayInput;

/**
 * @author Harshal-Git
 *
 *	-> given 2 array inputs of even / odd nubers. Print all these numbers in EVEN/ODD sequence (Starting from ODD) 
 *		using 2 threads.
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare shared printer object
		Printer print = new Printer();

		// odd number thread
		Thread t1 = new Thread(new EvenOddTaskThread(print, new int[] {11, 13, 15, 17, 19}), "T1");
		System.out.println("Initiating therad: "+ t1.getName());

		// even number thread
		Thread t2 = new Thread(new EvenOddTaskThread(print, new int[] {12, 14, 16, 18, 20}), "T2");
		System.out.println("Initiating therad: "+ t2.getName());

		// start both threads
		t1.start();
		t2.start();
	}
}
