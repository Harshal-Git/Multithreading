/**
 * 
 */
package com.daemonThreads;

/**
 * @author Harshal-Git
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Is main() thread daemon? "+Thread.currentThread().isDaemon());
		
		// trying to change daemon thread of main() : resulting exception
		//Thread.currentThread().setDaemon(true);
		
		// create a child thread to check it's daemon status (which is inherited from it's parent)
		Thread t1 = new Thread("Child");
		System.out.println("Is child thread daemon? "+t1.isDaemon());
		
		// change it's status
		t1.setDaemon(true);
		System.out.println("Is child thread daemon now? "+t1.isDaemon());
	}

}
