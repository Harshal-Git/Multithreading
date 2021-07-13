/**
 * 
 */
package com.javaThreadPools.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Harshal-Git
 *
 */
public class CallableDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare print jobs
		CallableJob [] jobs = {new CallableJob("Job#1", 10), new CallableJob("Job#3", 50),new CallableJob("Job#6", 66),
				new CallableJob("Job#2", 30), new CallableJob("Job#4", 55), new CallableJob("Job#5", 20)};

		// feed these jobs to executor framework with some threads
		ExecutorService service = Executors.newFixedThreadPool(3);

		// register start time
		Future<Integer> result = null;
		for(CallableJob job : jobs) {
			result = service.submit(job);
			try {
				System.out.println(result.get().intValue());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("Future object interrupted.");
			}
		}
		// shutdown service
		service.shutdown();
	}
}
