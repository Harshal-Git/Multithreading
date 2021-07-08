/**
 * 
 */
package com.priorityCheck;

/**
 * @author Harshal-Git
 *
 *	-> Main thread has default priority = 5
 *
 *	-> Every other thread will have it's default priority : inherited from it's parent. (mostly main thread)
 */
public class PrioritySetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// print main thread priority
		System.out.println("Main thread priority: "+Thread.currentThread().getPriority());		
		
		// change main thread priority
		Thread.currentThread().setPriority(7);
		
		System.out.println("Main thread new priority: "+Thread.currentThread().getPriority());

		// child thread priority taken from main thread as for child thread
		// main thread is parent thread which initiates it.
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("child thread.");
			}
		});
		t1.start();
		System.out.println("T1 thread priority: "+t1.getPriority());
	}
}