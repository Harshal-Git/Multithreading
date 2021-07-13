/**
 * 
 */
package com.threadLocal.inheritance.demo1;

/**
 * @author Harshal-Git
 *
 *	-> In inheritance relation with ThreadLocal; values set by parent thread will not be accessible to child threads.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// parent thread : initiated by main thread
		ParentThread pt = new ParentThread();
		pt.start();
	}
}
