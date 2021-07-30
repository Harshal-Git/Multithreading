/**
 * 
 */
package com.interthreadCommWaitNotify;

/**
 * @author Harshal-Git
 *
 *	-> approach 4: a possible incorrect way of programming to let the main() wait indefinitely. 
 *
 *	-> suppose after initiating the child thread; main thread goes to sleep. in this scenario; main thread might 
 *		get into permanent waiting state; which is not an appropriate idea.
 *
 *	-> for such cases; we should terminate main thread's waiting state after some time.
 */
public class Case5IMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CounterThread2 ct1 = new CounterThread2();
		Thread t1 = new Thread(ct1); 
		t1.start();

		// after initiating child thread, main thread goes to sleep
		try {
			System.out.println("main thread will sleep...");
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			System.out.println("sleeping main() thread got interrupted.");
		}

		// send main thread in waiting state; for an update from child thread
		synchronized (t1) {
			try {
				System.out.println("main thread waiting for childThread...");
				
				//t1.wait(); 	// not at all good approach to wait forever
				 
				t1.wait(1000);	// main thread should wait for a definite amount of time
				
				System.out.println("main thread got notification.");
			} catch (InterruptedException e) {
				System.out.println("t1.join() interrupted.");
			}
		}
		System.out.println("Total from main thread: "+ct1.getTotal());
	}
}
