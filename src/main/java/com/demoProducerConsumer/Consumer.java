/**
 * 
 */
package com.demoProducerConsumer;

import java.util.Queue;

/**
 * @author Harshal-Git
 *
 */
public class Consumer implements Runnable {

	private Queue<Integer> queue = null;

	private String tName = null;

	// till what time we want to keep feeding the data to queue
	private long startTime;

	/**
	 * param constructor 
	 */
	public Consumer(String name, Queue<Integer> q) {
		this.queue = q;
		this.tName = name;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		System.out.println("Consumer started...");
		// process until Producer ends processing
		while(System.currentTimeMillis() < (startTime+11000)) {
			synchronized (queue) {
				// read data from queue if not empty
				if(!queue.isEmpty()) {
					int value = queue.poll();
					System.out.println(this.tName+" read - "+value);
				} else {
					// if empty : wait for a while
					try {
						//System.out.println(this.tName+" waiting for data...");
						queue.wait(1000);
					} catch (InterruptedException e) {
						System.out.println(this.tName+" waiting for data in queue.");
					}
				}
			}
		}
	}
}