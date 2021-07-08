/**
 * 
 */
package com.threadExecutionPrevention;

/**
 * @author Harshal-Git
 *
 *	-> Case : child thread waiting for main thread to finish it's full execution.
 *
 *	-> join() method will make the executing thread to wait for other thread to finish it's execution.
 *
 *	-> Whichever thread has X.join() method call in it's job; it will continue it's execution once 'X'
 *		finishes it's execution.   
 */
public class JoinDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare & start child thread
		JoinCls3 runnableImpl = new JoinCls3(Thread.currentThread());
		Thread t1 = new Thread(runnableImpl);
		t1.start();

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

class JoinCls3 implements Runnable {

	// main thread instance
	private Thread mainThread;

	/**
	 * parameterized constructor 
	 */
	public JoinCls3(Thread mainT) {
		this.mainThread = mainT;
	}

	@Override
	public void run() {
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