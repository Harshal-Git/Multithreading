/**
 * 
 */
package com.synchronizedBlock.demo3;

/**
 * @author Harshal-Git
 *
 *	-> with both threads having access of independent objects; the class level lock acquired via synchronized block
 *		will not allow both threads to execute simultaneously. 
 *
 * 	-> because of the class level lock; output will be appropriate.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Display d1 = new Display();
		Display d2 = new Display();
		
		// create thread 1
		RunnableInst run1 = new RunnableInst(d1, "P1");
		Thread t1 = new Thread(run1);
		
		// create thread 2
		RunnableInst run2 = new RunnableInst(d2, "P2");
		Thread t2 = new Thread(run2);
		
		// start thread
		t1.start();
		t2.start();
	}
}
