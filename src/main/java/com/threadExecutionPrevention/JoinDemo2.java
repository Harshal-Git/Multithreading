/**
 * 
 */
package com.threadExecutionPrevention;

/**
 * @author Harshal-Git
 *
 *	-> Case : main thread waiting for a specific time for child thread to finish it's partial execution.
 *
 *	-> join() method will make the executing thread to wait for other thread to finish it's execution.
 *
 *	-> Whichever thread has X.join() method call in it's job; it will continue it's execution once 'X'
 *		finishes it's execution.   
 */
public class JoinDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JoinCls2 runnableImpl = new JoinCls2();
		Thread t1 = new Thread(runnableImpl);
		t1.start();

		// here: main thread will call join() method on child 
		// thread; to allow child thread to complete it's execution first.
		try {
			// wait only for given time; later main will continue execution 
			t1.join(600);
		} catch (InterruptedException e) {
			System.out.println("join() method interrupted.");
		}

		// job for main thread
		for(int i = 1; i <= 5; i++) {
			System.out.println("main thread");
		}
	}
}

class JoinCls2 implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("JoinCls thread");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("JoinCls Thread interrupted");
			}
		}
	}
}