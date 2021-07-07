/**
 * 
 */
package com.printEvenOdd;

/**
 * @author Harshal-Git
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// prepare shared printer object
		Printer print = new Printer();
	    
		// odd number thread
		Thread t1 = new Thread(new EvenOddTaskThread(print, 10, 1));
	    
		// even number thread
		Thread t2 = new Thread(new EvenOddTaskThread(print, 10, 2));
	    
		// start both threads
	    t1.start();
	    t2.start();
	}
}
