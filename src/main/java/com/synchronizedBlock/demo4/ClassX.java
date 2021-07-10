/**
 * 
 */
package com.synchronizedBlock.demo4;

/**
 * @author Harshal-Git
 *
 */
public class ClassX {

	/**
	 * constructor 
	 */
	public ClassX() {
		System.out.println("X() constructor called.");
	}
	
	/*
	 * synchronized method of X(); which will acquire locks
	 * for internal objects
	 */
	public synchronized void runX() {
		ClassY yObj = new ClassY();
		synchronized (yObj) {
			ClassZ zObj = new ClassZ();
		}
	}
}
