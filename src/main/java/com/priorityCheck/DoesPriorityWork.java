/**
 * 
 */
package com.priorityCheck;

/**
 * @author Harshal-Git
 *
 *	-> Some OS or platform doesn't provide support for thread priority. So needs to confirm it before using.
 */
public class DoesPriorityWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare child class & set it's priority higher than main thread
		// though JVM will not provide priority to child thread over main.
		MyClass runnable = new MyClass();
		Thread t1 = new Thread(runnable);
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		
		// meanwhile main thread also will perform some work
		for(int i = 1; i <= 5; i++) {
			System.out.println("main thread");
		}
	}
}

class MyClass implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("child thread");
		}
	}
}