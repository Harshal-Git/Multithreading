/**
 * 
 */
package com.demoProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Harshal-Git
 *
 *	-> Single Producer / Consumer problem with ConcurrentLinkedQueue.
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a concurrent queue
		Queue<Integer> q = new ConcurrentLinkedQueue<>();

		// prepare consumer & producer runnable instances
		Consumer c = new Consumer("Consumer", q);
		Producer p = new Producer("Producer", q);

		// prepare Consumer & Producer threads
		Thread pThread = new Thread(p);
		Thread cThread = new Thread(c);

		// start threads
		pThread.start();
		cThread.start();

		// wait until all are finished
		try {
			pThread.join();
			cThread.join();
		} catch (InterruptedException e) {
			System.out.println("main() join() interrupted.");
		}
	}
}
