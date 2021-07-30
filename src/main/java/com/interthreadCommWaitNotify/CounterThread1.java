/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 *
 */
public class CounterThread1 implements Runnable{

	private int total = 0;
	
	public int getTotal() {
		return this.total;
	}
	
	@Override
	public void run() {
		System.out.println("childThread started execution...");
		for(int i = 1; i <= 100; i++) {
			total += i;
		}
	}
}
