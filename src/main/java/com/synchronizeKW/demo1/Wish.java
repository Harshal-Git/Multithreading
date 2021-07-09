/**
 * 
 */
package com.synchronizeKW.demo1;

/**
 * @author Harshal-Git
 *
 */
public class Wish {

	/*
	 * synchronized method
	 */
	//public synchronized void wish(String name) {
	
	/*
	 * not synchronized 
	 */
	public void wish(String name) {
		for(int i = 1; i <= 5; i++) {
			System.out.print("Good morning ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("wish() method interrupted.");
			}
			System.out.println(name);
		}
		System.out.println();
	}
}
