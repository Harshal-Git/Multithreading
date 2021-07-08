/**
 * 
 */
package com.threadExecutionPrevention;

/**
 * @author Harshal-Git
 *
 *	-> Case : When child thread & main thread both are waiting for each other for completing their execution. A DEAD LOCK.
 */
public class JoinDeadlockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare & start child thread
		JoinCls4 runnableImpl = new JoinCls4(Thread.currentThread());
		Thread t1 = new Thread(runnableImpl);
		t1.start();
		
		// make main thread wait for child thread
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e1) {
			System.out.println("Main thread interrupted.");
		}

		// job for main thread : as join() is invoked inside child thread job,
		// until main thread gets finished; child thread will wait.
		for(int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(100);
				System.out.println("main thread");
			} catch (InterruptedException e) {
				System.out.println("Main Thread interrupted");
			}
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
		// job for child thread
		for(int i = 1; i <= 5; i++) {
			// wait for main thread & then continue 
			// child thread execution
			try {
				mainThread.join();
				System.out.println("JoinCls thread");
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				System.out.println("JoinCls Thread interrupted");
			}
		}
	}
}