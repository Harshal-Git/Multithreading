/**
 * 
 */
package com.forkJoin.RecursiveActionDemo;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Harshal-Git
 *
 *	-> A recursive action; which will call itself with narrower inputs to perform a bigger operation.
 */
public class ArrayFillerAction extends RecursiveAction {

	private static final long serialVersionUID = 8710503755864439687L;

	// array to be filled
	private long [] dataFill = null;

	// original array threshold length to  
	// decide when a task needs to be divided
	private static final int THRESHOLD = 10000;

	// local array range initializers
	private int start;
	private int end;

	// to keep track of divison
	private static StringBuffer buffer = new StringBuffer();

	/**
	 * param constructor 
	 */
	public ArrayFillerAction(long[] data, int startPoint, int endPoint) {
		/*
		 * buffer.append("start: ").append(startPoint).
		 * append("-> end: ").append(endPoint).append(" \n");
		 */
		this.dataFill = data;
		this.start = startPoint;
		this.end = endPoint;
	}

	@Override
	protected void compute() {
		// is current division managable to be executed?
		if((this.end - this.start) <= THRESHOLD) {
			for(int index = start; index <= end; index++) {

				// a not thread safe approach
				//dataFill[index] = ((int)Math.random()*100);

				// a thread safe approach (consider: 0 <= num < 100000 only)
				dataFill[index] = (ThreadLocalRandom.current().nextInt(100000));
			}
		} else {
			// otherwise divide the task & feed it to the action
			int halfPoint = (start+((end-start)/2));

			// first half
			ArrayFillerAction a1 = new ArrayFillerAction(dataFill, this.start, halfPoint);
			a1.fork();

			// second half
			ArrayFillerAction a2 = new ArrayFillerAction(dataFill, halfPoint, this.end);
			a2.compute();

			// merge to forked tasks (to let it finish)
			a1.join();
		}
	}

	public String printDivisionsFromBuffer() {
		return buffer.toString();
	}
}
