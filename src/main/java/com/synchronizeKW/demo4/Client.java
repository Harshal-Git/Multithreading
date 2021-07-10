/**
 * 
 */
package com.synchronizeKW.demo4;

/**
 * @author Harshal-Git
 *
 *	-> if a  single thread has acquired class level lock; and if it tries to execute both / multiple "static synchronized"
 *		methods for the same shared object; then that thread will be able to execute; only in sequence.
 *
 * 		There will be no exception raised for the same.
 *	
 *	-> because it's single thread trying to execute both methods; they will work in synch. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// display object
		Display disp = new Display();

		// prepare thread
		RunnableINS runnable = new RunnableINS(disp);
		Thread t1 = new Thread(runnable);
		t1.start();
	}

}
