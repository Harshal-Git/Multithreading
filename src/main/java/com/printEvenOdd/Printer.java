/**
 * 
 */
package com.printEvenOdd;

/**
 * @author Harshal-Git
 *
 */
public class Printer {

	// this keeps changing so volatile
	private volatile boolean isOdd;

	// print even number
	public void printEven(int number) throws InterruptedException {
		synchronized(this) {
			while (!isOdd) {
				wait();
			}
			Thread.sleep(100);
			System.out.println(number);
			isOdd = false;
			notifyAll();
		}
	}

	// print odd number
	public void printOdd(int number) throws InterruptedException {
		synchronized(this) {
			while(isOdd) {
				wait();
			}
			Thread.sleep(100);
			System.out.println(number);
			isOdd = true;
			notifyAll();
		}
	}
}