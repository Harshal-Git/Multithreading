/**
 * 
 */
package com.usage.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Harshal-Git
 *
 */
public class IncrementRunnable implements Runnable {

	private Semaphore sem;

	/**
	 * param constructor 
	 */
	public IncrementRunnable(Semaphore semObj) {
		this.sem = semObj;
	}

	@Override
	public void run() {
		String name = null;
		try {
			// get current thread name
			name = Thread.currentThread().getName();
			System.out.println(name+" thread asking for permission from Semaphore...");
			sem.acquire();

			// increment count
			for(int i = 1; i <= 5; i++) {
				SharedResource.count++;
				System.out.println(name+" incrementing count...");
				
				// just an intermediate status
				//System.out.println(sem.getQueueLength()+" waiting for permit.");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(name+" got interrupted while processing.");
				}
			}
		} catch (InterruptedException e) {
			System.out.println(name+" got interrupted while acquiring permission.");
		} finally {
			// release the permission
			sem.release();
			System.out.println(name+" thread has released permit.");
		}
	}
}
