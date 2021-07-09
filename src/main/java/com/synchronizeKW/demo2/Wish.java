/**
 * 
 */
package com.synchronizeKW.demo2;

/**
 * @author Harshal-Git
 *
 */
public class Wish {

	/*
	 * "static synchronized" method 
	 */
	//public static synchronized void wish(String name) {
		
	/*
	 * unsynchronized method
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
