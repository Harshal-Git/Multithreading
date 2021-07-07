/**
 * 
 */
package com.basics.initialization;

/**
 * @author Harshal-Git
 *
 *	-> One way of initialization of thread
 */
public class Demo1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){

		// thread instantiation
		MyThread t1 = new MyThread();
		t1.start();
	}
}

// custom class extending java.lang.Thread class
class MyThread extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.getName()+" count - "+(i+1));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(this.getName()+" interrupted.");
			}
		}
	}
}