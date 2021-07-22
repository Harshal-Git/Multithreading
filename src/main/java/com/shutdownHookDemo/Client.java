/**
 * 
 */
package com.shutdownHookDemo;

/**
 * @author Harshal-Git
 *
 *	-> the moment main threads is over; shutdown hook is automatically called no matter where the process for 
 *		main thread is declared.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// add shutdown hook to current runtime
		Runtime.getRuntime().addShutdownHook(new Thread(new MyShutdownHook()));
		
		// some process for main thread
		for(int i = 1; i <= 10; i++) {
			try {
				System.out.println("main() thread working on "+i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("main() thread sleeping...");
			}
		}
	}

}
