/**
 * 
 */
package com.usage.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Harshal-Git
 *
 */
public class WorkerRunnable implements Runnable {

	private String workerName = null;

	private CountDownLatch latch = null;

	/**
	 * param constructor 
	 */
	public WorkerRunnable(String name, CountDownLatch latchObj) {
		this.workerName = name;
		this.latch = latchObj;
	}

	@Override
	public void run() {
		// worker thread job
		try {
			System.out.println(this.workerName+" thread started...");
			for(int i = 1; i <= 500; i++) {
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println(this.workerName+" thread interrupted.");
		} finally {
			this.latch.countDown();
			System.out.println(this.workerName+" thread finished.");
		}
	}
}
