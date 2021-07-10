/**
 * 
 */
package com.synchronizedBlock.demo1;

/**
 * @author Harshal-Git
 *
 *	-> For a shared object; outside synchronized block; both threads will be allowed to execute any function inside it in 
 *		any manner.
 *	
 *	-> Just inside the "synchronized" block; both threads will be in synch. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Display d = new Display();
		
		// create thread 1
		RunnableInst run1 = new RunnableInst(d, "P1");
		Thread t1 = new Thread(run1);
		
		// create thread 2
		RunnableInst run2 = new RunnableInst(d, "P2");
		Thread t2 = new Thread(run2);
		
		// start thread
		t1.start();
		t2.start();
	}

}
