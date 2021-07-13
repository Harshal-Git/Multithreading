/**
 * 
 */
package com.threadLocal.inheritance.demo2;

/**
 * @author Harshal-Git
 *
 */
public class ChildThread extends Thread{

	/**
	 * param constructor
	 */
	public ChildThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("child thread initiated.");
		// this line executed by child thread : so child thread will try to access 
		// the inherited thread local value set by parent : which will be accessed by child
		System.out.println("Child thread reading thread local value: "+ParentThread.threadLocal.get());
	}
}