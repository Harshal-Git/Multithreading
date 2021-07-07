/**
 * 
 */
package com.printEvenOdd;

/**
 * @author Harshal-Git
 *
 */
public class EvenOddTaskThread implements Runnable {

	private int max;
	private int start;
    private Printer print;
	
	/**
	 * EvenOdd constructor
	 * @param printObj - shared Printer class instance
	 * @param max - max limit
	 * @param startNum - start number for given thread
	 */
	public EvenOddTaskThread(Printer printObj, int max, int startNum) {
		this.max = max;
		this.print = printObj;
		this.start = startNum;
	}

	@Override
	public void run() {
		// while start reaches the max limit
		while (start <= max) {
			// if start is even
			if (start%2 == 0) {
				try {
					print.printEven(start);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					// if start is odd
					print.printOdd(start);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			start += 2;
		}
	}
}