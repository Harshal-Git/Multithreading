/**
 * 
 */
package com.additionalMethods;

/**
 * @author Harshal-Git
 *
 *	-> how to use stop method?
 *
 *	-> using stop method on any thread will terminate the thread abruptly and thread will enter into dead state.
 *
 * 	-> using this method can cause serious issues with object processing and hence it's deprecated since version 1.2
 */
public class StopMethodDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// start main thread and let it initiate child thread
		ChildT runnable = new ChildT();
		Thread t1 = new Thread(runnable);
		t1.start();
		
		// let main thread sleep for a while
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("main() thread interrupted.");
		}
		// kill child thread
		t1.stop();
		System.out.println("main thread stopped child thread.");
	}
}

class ChildT implements Runnable {

	@Override
	public void run() {
		System.out.println("child thread starting...");
		for(int i = 1; i <= 100000; i++) {
			System.out.println("child-"+i);
		}
	}
}
