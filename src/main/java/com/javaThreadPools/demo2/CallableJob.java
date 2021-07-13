/**
 * 
 */
package com.javaThreadPools.demo2;

import java.util.concurrent.Callable;

/**
 * @author Harshal-Git
 *
 * -> java.util.concurrent.Callable job: which can be used with executor framework to get some return type
 */
public class CallableJob implements Callable<Integer> {

	private String jobName;
	private int number;
	
	/**
	 * param constructor 
	 */
	public CallableJob(String name, int num) {
		this.jobName = name;
		this.number = num;
	}
	
	@Override
	public Integer call() throws Exception {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(this.jobName+" job started by "+currentThreadName+".");
		int sum = 0;
		for(int i = 1; i <= this.number; i++) {
			sum+= i;
		}
		System.out.println(this.jobName+" job completed by "+currentThreadName+".");
		System.out.print("sum("+this.number+") = ");
		return sum;
	}
	
	@Override
	public String toString() {
		return this.jobName;
	}
}
