/**
 * 
 */
package com.forkJoin.forkJoinTaskDemo;

import java.util.concurrent.RecursiveTask;

/**
 * @author Harshal-Git
 *
 */
public class Fibonacci extends RecursiveTask<Long> {
	
	private static final long serialVersionUID = 8047811546450745530L;
	
	private long seriesLength = 0;

	/**
	 * param constructor 
	 */
	public Fibonacci(long num) {
		this.seriesLength = num;
	}

	@Override
	protected Long compute() {
		if (seriesLength <= 1) {
			return seriesLength;
		}
		Fibonacci f1 = new Fibonacci(seriesLength-1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(seriesLength-2);
		// join() always has to be the last step to call
		return (f2.compute()+f1.join());
	}
}
