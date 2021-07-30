/**
 * 
 */
package com.usage.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Harshal-Git
 *
 *	-> we can provide a number of tasks to CountDownLatch and for those many tasks to get over; the main task will wait 
 *		by await() method.
 *	
 *	-> Once those many tasks are done (no matter in any order); main task will resume it's execution.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// for how many tasks; main task will have to wait
		CountDownLatch latch = new CountDownLatch(2);

		// prepare runnable instances
		WorkerRunnable w1 = new WorkerRunnable("Worker-1", latch);
		WorkerRunnable w2 = new WorkerRunnable("Worker-2", latch);
		WorkerRunnable w3 = new WorkerRunnable("Worker-3", latch);
		WorkerRunnable w4 = new WorkerRunnable("Worker-4", latch);

		// prepare threads 
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		Thread t3 = new Thread(w3);
		Thread t4 = new Thread(w4);

		// start threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// cause current thread (main thread) to wait until all threads are finished
		try {
			System.out.println(Thread.currentThread().getName()+" awaiting on CountDownLatch...");
			latch.await();
		} catch (InterruptedException e) {
			System.out.println("main() thread await interrupted.");
		} 
		System.out.println("main() thread will finish now.");
	}
}