/**
 * 
 */
package com.javaThreadPools.demo1;

/**
 * @author Harshal-Git
 *
 *	-> Runnable Job 1
 */
public class PrintJob1 implements Runnable {

	private String jobName;
	
	/**
	 * param constructor 
	 */
	public PrintJob1(String name) {
		this.jobName = name;
	}
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(this.jobName+" job started by "+currentThreadName+".");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			System.out.println(currentThreadName+" interrupted.");
		}
		System.out.println(this.jobName+" job completed by "+currentThreadName+".");
	}
}