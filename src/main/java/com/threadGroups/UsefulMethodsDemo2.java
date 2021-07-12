/**
 * 
 */
package com.threadGroups;

/**
 * @author Harshal-Git
 *
 *	-> some useful methods of ThreadGroup class
 */
public class UsefulMethodsDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create a thread group
		ThreadGroup pg = new ThreadGroup("PG");
		
		// create a child group for above group
		ThreadGroup cg1 = new ThreadGroup(pg, "CG1");

		// create threads with parent group
		MYThread t1 = new MYThread(pg, "T1");	
		MYThread t2 = new MYThread(pg, "T2");  

		// start threads : to see the active group count 
		t1.start();
		t2.start();

		// print active threads
		System.out.println("Active threads for thread group: "+cg1.activeCount());
		// print number of active groups from current group
		System.out.println("Active groups for parent group: "+pg.activeGroupCount());
		// print threads from this group
		System.out.print("Thread group information: ");
		pg.list();

		// main thread sleep : mean time both child threads will be finished
		try {
			System.out.println("\nmain() thread will sleep now.");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("main() thread sleep interrupted.");
		}
		System.out.println();
		System.out.println("Active threads for thread group: "+cg1.activeCount());
		System.out.println("Active groups for parent group: "+pg.activeGroupCount());
		System.out.print("Thread group information: ");
		pg.list();
	}
}

// custom class
class MYThread extends Thread {
	
	/**
	 * parameterized constructor 
	 */
	public MYThread(ThreadGroup tg, String name) {
		super(tg, name);
	}
	
	@Override
	public void run() {
		System.out.println("child thread "+this.getName()+" started...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Child thread "+this.getName()+" interrupted.");
		}
	}
}