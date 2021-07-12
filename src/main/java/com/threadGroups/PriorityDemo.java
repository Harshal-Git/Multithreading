/**
 * 
 */
package com.threadGroups;

/**
 * @author Harshal-Git
 *
 *	-> priority related methods for thread group.
 *
 *	-> a thread group when created; will have it's max priority = 10. So all threads having priority <= 10 will be allowed.
 *
 *	-> thread/s created referring to this group; will have it's default priority = 5; unless intentionally changed. So those thread
 *		will be allowed.
 *
 *	-> now if there are some threads already part of this group and if the group priority is changed, then those existing threads 
 *		will not have any impact of this new priority.
 *
 * 	-> once max priority changed for a group; all new joining threads will have the new priority as their default priority.
 */
public class PriorityDemo {

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
		
		// print priorities for all
		System.out.println("T1 priority: "+t1.getPriority());
		System.out.println("T2 priority: "+t2.getPriority());
		System.out.println("T3 priority: "+t3.getPriority());
	}
}
