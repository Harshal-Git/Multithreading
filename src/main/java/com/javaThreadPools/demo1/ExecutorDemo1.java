/**
 * 
 */
package com.javaThreadPools.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Harshal-Git
 *
 *	-> Feed the jobs to executor framework & let it run with some number of thread/s 
 */
public class ExecutorDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare print jobs
		PrintJob1 [] jobs = {new PrintJob1("Job#1"), new PrintJob1("Job#3"),new PrintJob1("Job#6"),
				new PrintJob1("Job#2"), new PrintJob1("Job#4"), new PrintJob1("Job#5")};

		// feed these jobs to executor framework with some threads
		ExecutorService service = Executors.newFixedThreadPool(3);

		// register start time
		for(PrintJob1 job : jobs) {
			service.submit(job);
		}
		// shutdown service
		service.shutdown();
	}
}
