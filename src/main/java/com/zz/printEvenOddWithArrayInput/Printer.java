/**
 * 
 */
package com.zz.printEvenOddWithArrayInput;

/**
 * @author Harshal-Git
 *
 *	-> EvenOddTaskThread thread has to execute methods from this class alternatively.
 *
 *	-> So 2 such EvenOddTaskThread class threads; will execute single instance of "Printer" class in synchronized manner. 
 */
public class Printer {

	// this keeps changing so volatile : if initialized to TRUE
	// then result will be 2 1 4 3 6 5 8 7 10 9 
	private volatile boolean isEven = false;

	// print even number : synchronized method
	public void printEven(int number) {
		synchronized (this) {
			while (!this.isEven) {		// while number is ODD: wait
				try {
					this.wait(100);	// wait initiated on current object by executing thread 
					Thread.sleep(0);	// just to delay printing
				} catch (InterruptedException e) {
					System.out.println("printEven() wait() interrupted.");
				}
			}
			// once number gets EVEN; print it
			System.out.println(Thread.currentThread().getName()+" - "+number);
			// change the number status to ODD
			this.isEven = false;
			// notify all waiting threads
			this.notifyAll();
		}
	}

	// print odd number : synchronized block
	public void printOdd(int number) {
		synchronized(this) {	// synchronized on current object
			while(this.isEven) {	// while number is EVEN; wait
				try {
					this.wait(100);	// wait initiated on current object by executing thread 
					Thread.sleep(0); // just to delay printing
				} catch (InterruptedException e) {
					System.out.println("printOdd() wait() interrupted.");
				}
			}
			// once number gets ODD, print it.
			System.out.println(Thread.currentThread().getName()+" - "+number);
			// change the number status to EVEN
			this.isEven = true;
			// notify all waiting threads
			this.notifyAll();
		}
	}
}