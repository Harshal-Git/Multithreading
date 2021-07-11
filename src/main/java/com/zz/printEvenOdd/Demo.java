/**
 * 
 */
package com.zz.printEvenOdd;

/**
 * @author Harshal-Git
 *
 *	-> printing 1 -> 10 in sorted order by 2 threads.
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// prepare shared printer object
		Printer print = new Printer();
	    
		// odd number thread
		Thread t1 = new Thread(new EvenOddTaskThread(print, 10, 1), "T1");
		System.out.println("Initiating therad: "+ t1.getName());
	    
		// even number thread
		Thread t2 = new Thread(new EvenOddTaskThread(print, 10, 2), "T2");
		System.out.println("Initiating therad: "+ t2.getName());
		
		// start both threads
	    t1.start();
	    t2.start();
	}
}
