/**
 * 
 */
package com.synchronizeKW.demo2;

/**
 * @author Harshal-Git
 *
 *	if unsynchronized com.synchronizeKW.demo2.Wish.wish(String) method with:
 *	-> multiple threads with shared instance : irregular output
 *
 *	if "static synchronized" com.synchronizeKW.demo2.Wish.wish(String) method with:
 *	-> multiple threads with shared instance : regular output
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// single wish object
		Wish wishObj = new Wish();
		
		// prepare first instance
		RunInstance r1 = new RunInstance("P1", wishObj);
		Thread t1 = new Thread(r1);
		
		// prepare second instance
		RunInstance r2 = new RunInstance("P2", wishObj);
		Thread t2 = new Thread(r2);

		// start threads
		t1.start();
		t2.start();
	}
}
