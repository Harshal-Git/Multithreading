/**
 * 
 */
package com.cyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Harshal-Git
 *
 */
public class RunnableService implements Runnable {

	private String serviceName = null;

	private CyclicBarrier barrier = null;

	/**
	 * param constrctor 
	 */
	public RunnableService(String name, CyclicBarrier barrierObj) {
		this.serviceName = name;
		this.barrier = barrierObj;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.serviceName+" service started...");
			Thread.sleep(1500);
			
			System.out.println(this.serviceName+" waiting at Barrier...");
			barrier.await();
			
			//System.out.println("Waiting parties @ service "+this.serviceName+" ==> "+barrier.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println(this.serviceName+" got interrupted OR Barrier broken.");
		} finally {
			System.out.println(this.serviceName+" service ended.");
		}
	}
}
