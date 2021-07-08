/**
 * 
 */
package com.threadInterruptDemo;

/**
 * @author Harshal-Git
 *
 *	-> how a sleeping / waiting thread can be interrupted.
 *	
 *	-> once interrupt() method is called; it's JVM's responsibility to make that happen.
 *		Meanwhile; main thread will keep continue it's execution.
 */
public class InterruptedDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntClass1 runnableI = new IntClass1();
		Thread t1 = new Thread(runnableI);
		t1.start();
		
		// main thread interrupts child thread
		t1.interrupt();
		
		// main thread will continue it's execution
		System.out.println("End of main thread.");
	}
}


class IntClass1 implements Runnable {
	@Override
	public void run() {
		try {
			for(int i = 1; i <= 10; i++) {
				System.out.println("thread-"+i);
				// the moment child thread sleeps; immediately
				// it is interrupted by main thread.
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			System.out.println("IntClass thread got interrupted.");
		}
	}
}