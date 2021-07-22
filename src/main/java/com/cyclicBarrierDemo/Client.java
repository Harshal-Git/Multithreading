/**
 * 
 */
package com.cyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Harshal-Git
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare CyclicBarrier for 2 parties
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		// prepare & execute executor service for 4 parties by 2 threads
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new RunnableService("Service-1", barrier));
		service.execute(new RunnableService("Service-2", barrier));
		service.execute(new RunnableService("Service-3", barrier));
		service.execute(new RunnableService("Service-4", barrier));
		service.execute(new RunnableService("Service-5", barrier));
		service.execute(new RunnableService("Service-6", barrier));
		
		// wait for a while
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			System.out.println("main() thread interrupted.");
		}
		// shutdown the service
		service.shutdown();
	}
}
