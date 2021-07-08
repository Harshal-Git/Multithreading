/**
 * 
 */
package com.threadExecutionPrevention;

/**
 * @author Harshal-Git
 *
 *	-> Case : One thread allowing execution of other waiting threads after certain period. After that thread will resume.
 *
 *	-> yield() to allow JVM to run other threads waiting to be executed. 
 *
 *	-> yield() method not all platforms supported.
 */
public class YieldDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		// initiate child thread
		MyCls runnableI = new MyCls();
		Thread t1 = new Thread(runnableI);
		t1.start();

		// start main thread after some time (let child finish first)
		Thread.sleep(10);
		// main thread job
		for(int i = 1; i <= 10; i++) {
			System.out.println("main thread");
		}
	}
}

class MyCls implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("child thread.");
			try {
				// make child thread sleep for a while
				Thread.sleep(2);
			} catch (InterruptedException e) {
				System.out.println("MyCls Thread interrupted");
			}
			// after certain point; yield child thread
			if(i > 5) {
				Thread.yield();
			}
		}
	}
}