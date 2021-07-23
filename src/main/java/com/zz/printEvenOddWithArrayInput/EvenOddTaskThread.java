/**
 * 
 */
package com.zz.printEvenOddWithArrayInput;

/**
 * @author Harshal-Git
 *
 */
public class EvenOddTaskThread implements Runnable {

	private int [] arrayInput = null;
	private Printer print = null;

	/**
	 * @param printObj
	 * @param inputs
	 */
	public EvenOddTaskThread(Printer printObj, int [] inputs) {
		this.print = printObj;
		this.arrayInput = inputs;
	}

	@Override
	public void run() {
		// for all array elements
		for(int i = 0; i < arrayInput.length; i++) {
			//if element is even
			if((arrayInput[i]%2) == 0) {
				print.printEven(arrayInput[i]);
			} else {
				// if element is odd
				print.printOdd(arrayInput[i]);
			}
		}
	}
}