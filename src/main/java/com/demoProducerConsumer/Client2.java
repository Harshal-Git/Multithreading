/**
 * 
 */
package com.demoProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Harshal-Git
 *
 *	-> Single Producer / Multiple Consumer problem with ConcurrentLinkedQueue
 */
public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a concurrent queue
		Queue<Integer> q = new ConcurrentLinkedQueue<>();

		// prepare consumer & producer runnable instances
		Consumer c1 = new Consumer("Consumer:1", q);
		Consumer c2 = new Consumer("Consumer:2", q);
		Producer p = new Producer("Producer", q);

		// prepare Consumer & Producer threads
		Thread pThread = new Thread(p);
		Thread cThread1 = new Thread(c1);
		Thread cThread2 = new Thread(c2);

		// start threads
		pThread.start();
		cThread1.start();
		cThread2.start();

		// wait until all are finished
		try {
			pThread.join();
			cThread1.join();
			cThread2.join();
		} catch (InterruptedException e) {
			System.out.println("main() join() interrupted.");
		}
	}
}
