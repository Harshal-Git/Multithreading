/**
 * 
 */
package com.threadLocal.inheritance.demo1;

/**
 * @author Harshal-Git
 *
 *	-> A parent thread which will acquire the Thread local & set values
 */
public class ParentThread extends Thread {

	public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	@Override
	public void run() {
		// set thread local data
		System.out.println("Parent thread setting thread local value...");
		threadLocal.set("Parent thread");
		// get thread local data 
		System.out.println("Parent thread local value: "+threadLocal.get());
		// initiate child thread
		ChildThread ct1 = new ChildThread("Child thread");
		ct1.start();
	}
}
