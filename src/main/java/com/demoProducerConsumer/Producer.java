/**
 * 
 */
package com.demoProducerConsumer;

import java.util.Queue;

/**
 * @author Harshal-Git
 *
 */
public class Producer implements Runnable {

	private Queue<Integer> queue = null;

	private String tName = null;

	// till what time we want to keep feeding the data to queue
	private long startTime;

	/**
	 * param constructor 
	 */
	public Producer(String name, Queue<Integer> q) {
		this.queue = q;
		this.tName = name;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		System.out.println("Producer started...");
		// process until current system time becomes start time + 1 seconds
		while(System.currentTimeMillis() < (startTime+10000)) {
			// insert data into queue
			int value = ((int)(Math.random()*100));
			queue.add(value);
			System.out.println(this.tName+" added - "+value);
			// sleep for a while & then notify
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Producer() thread got interrupted.");
			}
			// notify to consumer
			synchronized (queue) {
				queue.notify();
			}
		}
	}
}
