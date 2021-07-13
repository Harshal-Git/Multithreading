/**
 * 
 */
package com.threadLocal.inheritance.demo3;

/**
 * @author Harshal-Git
 *
 *	-> A parent thread which will acquire the Thread local & set values
 */
public class ParentThread extends Thread {

	public static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<String>() {
		
		// when we want to set separate default value for child thread
		@Override
		protected String childValue(String parentValue) {
			return "Child defalt value";
		}
	};
	
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
