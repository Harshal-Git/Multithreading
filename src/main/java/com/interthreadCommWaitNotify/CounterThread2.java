/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 */
public class CounterThread2 implements Runnable{

	private int total = 0;

	public int getTotal() {
		return this.total;
	}

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("childThread started calculation...");
			for(int i = 1; i <= 100; i++) {
				total += i;
			}
			System.out.println("child thread notified.");
			this.notify();
		}
	}
}
