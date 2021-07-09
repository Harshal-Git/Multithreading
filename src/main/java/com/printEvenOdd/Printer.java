/**
 * 
 */
package com.printEvenOdd;

/**
 * @author Harshal-Git
 *
 *	-> EvenOddTaskThread thread has to execute methods from this class alternatively.
 *
 *	-> So 2 such EvenOddTaskThread class threads; will execute single instance of "Printer" class in synchronized manner. 
 */
public class Printer {

	// this keeps changing so volatile
	private volatile boolean isOdd;

	// print even number : synchronized method
	public synchronized void printEven(int number) {
		while (!isOdd) {
			try {
				wait();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("printEven() wait() interrupted.");
			}
		}
		System.out.print(number+" ");
		isOdd = false;
		notifyAll();
	}

	// print odd number : synchronized block
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
			System.out.print(number+" ");
			isOdd = true;
			notifyAll();
		}
	}
}