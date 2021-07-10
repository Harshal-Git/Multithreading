/**
 * 
 */
package com.synchronizeKW.demo3;

/**
 * @author Harshal-Git
 *
 *	2 threads with a shared object
 *	-> without "synchronized" methods : irregular output
 *
 *	2 threads with a shared object
 *	-> with "synchronized" methods : regular output
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// common display object
		Display disp = new Display();
		
		// thread 1 : character printing
		Thread1 r1 = new Thread1(disp);
		Thread t1 = new Thread(r1);
		
		// thread 2 : number printing
		Thread2 r2 = new Thread2(disp);
		Thread t2 = new Thread(r2);
		
		// start threads
		t1.start();
		t2.start();
	}
}
