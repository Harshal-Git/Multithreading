/**
 * 
 */
package com.synchronizedBlock.demo2;

/**
 * @author Harshal-Git
 *
 */
public class Display {

	public void wish(String name) {

		// some time waste
		for(long i = 1; i <= 1000000000; i++) { 
			if(i == 99999) {
				System.out.println("some time waste before...");
			}
		}

		// actual work (making this block synchronized at object level)
		synchronized (this) {
			for(int i = 1; i <= 5; i++) {
				System.out.print("Good morning ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("wish() method interrupted.");
				}
				System.out.println(name);
			}
		}
		System.out.println();

		// some time waste again
		for(long i = 1; i <= 1000000000; i++) {
			if(i == 99999) {
				System.out.println("some time waste after...");
			}
		}
	}
}
