/**
 * 
 */
package com.zz.printNumbersFromMultithreads;

/**
 * @author Harshal-Git
 *
 */
public class RunnableService implements Runnable {

	public static int MAX_NUM = 20;
	public static volatile int START_NUM = 1;

	// shared lock object
	private static Object lockObj = new Object();

	private int validRemainder = 0;

	/**
	 * param demo 
	 */
	public RunnableService(int remainder) {
		this.validRemainder = remainder;
	}

	@Override
	public void run() {
		// the end value (MAX_NUM-1) is obtained after debug
		while(START_NUM < MAX_NUM-1) {
			// first acquire lock on common shared object
			synchronized (lockObj) {					
				// check whether current start number has remainder which is passed via param?
				// if not; then wait for it to happen.
				if((START_NUM % 3) != validRemainder) {
					try {
						lockObj.wait(500);
						Thread.sleep(100);
					} catch(InterruptedException exc) {
						System.out.println("wait() method interrupted.");
					}
				}
				// once that is achieved; print the start number
				System.out.println(Thread.currentThread().getName()+" printed- "+START_NUM+" ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" sleep interrupted.");
				}
				// increment the start number
				START_NUM++;
				// notify all waiting threads on the same object
				lockObj.notifyAll();	
			}
		}
	}
}
