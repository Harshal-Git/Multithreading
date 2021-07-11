/**
 * 
 */
package com.daemonThreads;

/**
 * @author Harshal-Git
 *
 *	-> if main / non-daemon thread is completed; all daemon threads will be terminated abruptly. 
 *
 *	-> abrupt child thread end can be seen in numbers getting printed.
 */
public class DaemonThreadStatusDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// initiate a child thread & make it daemon
		ChildT ct1 = new ChildT();
		Thread t1 = new Thread(ct1);
		t1.setDaemon(true);	// make child a daemon thread
		t1.start();
		// main thread will finish now: so as the daemon will also abruptly terminate
		System.out.println("main thread will end.");
	}
}

// child thread with some implementation
class ChildT implements Runnable {

	@Override
	public void run() {
		for(long i = 1; i <= 1000; i++) {
			System.out.println("child thread -"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("child therad interrupted.");
			}
		}
	}
}