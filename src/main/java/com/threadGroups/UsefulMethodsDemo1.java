/**
 * 
 */
package com.threadGroups;

/**
 * @author Harshal-Git
 *
 *	-> some useful methods of ThreadGroup class
 */
public class UsefulMethodsDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create a thread group
		ThreadGroup tg1 = new ThreadGroup("Tg1");
		
		// create threads with above group
		Thread t1 = new Thread(tg1, "T1");	// default priority 5
		Thread t2 = new Thread(tg1, "T2");  // default priority 5
		
		// change the group max priority to 3
		tg1.setMaxPriority(3);
		
		// create new thread
		Thread t3 = new Thread(tg1, "T3");	// default priority 3 (followed by group's max priority)
		
		// print threads from this group
		System.out.print("Thread group information: ");
		tg1.list();
		
		// start 1 thread : to see the active group count 
		t1.start();
		// print active threads
		System.out.println("Active threads for thread group: "+tg1.activeCount());
		
		// print number of active groups from current group
		System.out.println("Active groups for thread group: "+tg1.activeGroupCount());
	}
}
