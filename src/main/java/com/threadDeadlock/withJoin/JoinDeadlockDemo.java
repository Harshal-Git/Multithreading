/**
 * 
 */
package com.threadDeadlock.withJoin;

/**
 * @author Harshal-Git
 *
 *	-> Case : When child thread & main thread both are waiting for each other for completing their execution. 
 *		A DEAD LOCK BY JOIN METHOD.
 */
public class JoinDeadlockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("main() thread started");

		// prepare & start child thread
		JoinCls4 runnableImpl = new JoinCls4(Thread.currentThread());
		Thread t1 = new Thread(runnableImpl);
		t1.start();

		// make main thread wait for child thread
		try {
			System.out.println("main() thread waiting for child thread's execution");
			t1.join();
		} catch (InterruptedException e1) {
			System.out.println("main thread interrupted.");
		}
	}
}

class JoinCls4 implements Runnable {

	// main thread instance
	private Thread mainThread;

	/**
	 * parameterized constructor 
	 */
	public JoinCls4(Thread mainT) {
		this.mainThread = mainT;
	}

	@Override
	public void run() {
		// child thread execution
		System.out.println("child thread started");
		System.out.println("child thread waiting for main thread's execution");
		try {
			// wait for main thread's execution
			mainThread.join();
		} catch (InterruptedException e) {
			System.out.println("child thread interrupted");
		}
	}
}