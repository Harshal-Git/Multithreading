/**
 * 
 */
package com.threadInterruptDemo;

/**
 * @author Harshal-Git
 *
 *	-> how a sleeping / waiting thread can be interrupted.
 *
 *	-> If any thread is not in it's waiting / sleeping stage and if at that time interrupt() is called; then the interrupt call 
 *		will wait and in future whenever the thread changes it's status, it will be interrupted. This is taken care by JVM.
 */
public class InterruptedDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntClass2 runnableI = new IntClass2();
		Thread t1 = new Thread(runnableI);
		t1.start();
		
		// main thread interrupts child thread
		t1.interrupt();
		
		// main thread will continue it's execution 
		System.out.println("End of main thread.");
	}
}


class IntClass2 implements Runnable {
	@Override
	public void run() {
		try {
			// no matter even thread has completed it's work and later at 
			// sometime if it goes for sleep; it will be interrupted.
			for(int i = 1; i <= 10000; i++) {
				System.out.println("thread-"+i);
			}
			System.out.println("IntClass2 will sleep.");
			Thread.sleep(500);
		} catch(InterruptedException e) {
			System.out.println("IntClass thread got interrupted.");
		}
	}
}