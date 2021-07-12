/**
 * 
 */
package com.threadGroups;

/**
 * @author Harshal-Git
 *
 *	-> method to print all internal threads for a JVM; and whether they are daemon OR not?
 */
public class EnumerateMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// get system thread group
		ThreadGroup systemGroup = Thread.currentThread().getThreadGroup().getParent();
		
		// prepare an empty enumerator array
		Thread[] threadArr = new Thread[systemGroup.activeCount()];
		
		System.out.println("There are "+systemGroup.activeCount()+" active system group threads ==> ");
		
		// fill the enumerator array
		systemGroup.enumerate(threadArr);
		
		// print all active thread information
		for(Thread t : threadArr) {
			System.out.println("\n'"+t.getName()+"'"+" with priority = "+t.getPriority()+" is a daemon thread? "+t.isDaemon());
		}
	}
}
