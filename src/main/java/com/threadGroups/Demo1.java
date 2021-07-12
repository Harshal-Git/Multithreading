/**
 * 
 */
package com.threadGroups;

/**
 * @author Harshal-Git
 *
 */
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// find main thread's group name
		System.out.println("Main thread's group: "+Thread.currentThread().getThreadGroup());
		System.out.println("Main thread's group name: "+Thread.currentThread().getThreadGroup().getName());
		
		// parent group of main group
		System.out.println("Main thread's group parent group: "+Thread.currentThread().getThreadGroup().getParent().getName());
		System.out.println();
		
		/**
		 * create a thread group 
		 * This line is executed by main thread. 
		 * So this group will become sub group of main group.
		 */
		ThreadGroup tg1 = new ThreadGroup("MyGroup1");
		System.out.println("Custom group 1 name: "+tg1.getName());
		System.out.println("Custom group 1's parent group name: "+tg1.getParent().getName());
		System.out.println();

		/**
		 * create a thread group; for which parent group is some else group
		 */
		ThreadGroup tg2 = new ThreadGroup(tg1, "MyGroup2");
		System.out.println("Custom group 2 name: "+tg2.getName());
		System.out.println("Custom group 2's parent group name: "+tg2.getParent().getName());
	}

}
