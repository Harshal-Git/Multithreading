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
	public void printEven(int number) {
		synchronized(this) {
			while (!isOdd) {
				try {
					wait();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("printEven() wait() interrupted.");
				}
			}
			System.out.print(number+" - ");
			isOdd = false;
			notifyAll();
		}
	}

	// print odd number
	public void printOdd(int number) {
		synchronized(this) {
			while(isOdd) {
				try {
					wait();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("printOdd() wait() interrupted.");
				}
			}
			System.out.print(number+" - ");
			isOdd = true;
			notifyAll();
		}
	}
}