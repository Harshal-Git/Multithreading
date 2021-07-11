/**
 * 
 */
package com.threadDeadlock.withLockedObjects;

/**
 * @author Harshal-Git
 *
 *	-> Case 1: 
 *		if methods m1() & m2() in class A & B doesn't are not synchronized; both threads will independently execute these methods
 *		without acquiring lock. 
 *
 *	-> Case 2:
 *		If m1() is 'synchronized' but not m2(); then also during accessing m2(); no thread would need a lock and execution will
 *		continue on the same thread without any deadlock.
 *
 * 	-> Case 3:
 * 		If m1() is not 'synchronized' but m2(); then during accessing m2(); both thread would acquire a lock; which has not been 
 * 		acquired till now on any object. So execution will happen properly.
 * 
 * -> Case 4:
 * 		When both methods becomes 'synchronized'; threads which have already acquired locks for m1() method; will try to acquire
 * 		lock on another object to execute m2() and that's where both threads will be waiting for each other to release the 
 * 		existing lock; and would wait for that to happen indefinitely.
 *  
 * 		THAT'S DEAD LOCK WITHOUT ANY METHOD / WITH LOCKED OBJECTS.
 * 
 * 	-> Case 5: 
 * 		If at-least one 'synchronized' keyword is removed out of 4; the program will not enter into deadlock situation. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// main thread initiate object
		ThreadInstance t1 = new ThreadInstance();
		// and calls m1() method
		t1.m1();
	}
}