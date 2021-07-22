/**
 * 
 */
package com.shutdownHookDemo;

/**
 * @author Harshal-Git
 *
 */
public class MyShutdownHook implements Runnable{

	@Override
	public void run() {
		System.out.println("Custom shutdown hook...");
		System.out.println("Closing all resources...");
	}

}
