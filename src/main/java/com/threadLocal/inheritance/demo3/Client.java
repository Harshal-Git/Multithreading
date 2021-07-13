/**
 * 
 */
package com.threadLocal.inheritance.demo3;

/**
 * @author Harshal-Git
 *
 *	-> In inheritance relation with InheritableThreadLocal; default value for child thread can overridden.
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
