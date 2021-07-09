/**
 * 
 */
package com.synchronizeKW.demo3;

/**
 * @author Harshal-Git
 *
 *	-> A class to display either number OR a digit
 */
public class Display {

	/*
	 * method to print numbers
	 */
	//public synchronized void printN() {
		
	public void printN() {	
		for(int i = 1; i <= 10; i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.out.println("printN() got interrupted.");
			}
		}
	}

	/*
	 * method to print characters
	 */
	//public synchronized void printC() {
	
	public synchronized void printC() {
		for(int i = 65; i <= 75; i++) {
			System.out.print(((char)i)+" ");
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.out.println("printN() got interrupted.");
			}
		}
	}
}
