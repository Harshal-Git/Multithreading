/**
 * 
 */
package com.basics.initialization;

/**
 * @author Harshal-Git
 *
 *	-> Second way of initialization of thread
 */
public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread2 runnableInt = new MyThread2();
		Thread t1 = new Thread(runnableInt);
		t1.start();
	}
}

// custom class implementing runnable
class MyThread2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" count - "+(i+1));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" interrupted.");
			}
		}
	}
}
