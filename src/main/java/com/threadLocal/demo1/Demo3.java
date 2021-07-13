/**
 * 
 */
package com.threadLocal.demo1;

/**
 * @author Harshal-Git
 *
 *	-> for every thread; a separate thread ID will be maintained by Thread local object.
 *
 *	-> the current thread which is executing the thread local lines; will be in control.
 */
public class Demo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare runnable instances
		MyThread r1 = new MyThread("T1");
		MyThread r2 = new MyThread("T2");
		MyThread r3 = new MyThread("T3");
		MyThread r4 = new MyThread("T4");

		// prepare threads
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);

		// start threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

// class to maintain thread behavior
class MyThread implements Runnable {

	// maintain static counter to be shared among all instances 
	private static int threadID = 0;

	// maintain a shared thread local for all instances
	private static ThreadLocal<Integer> tLocal = new ThreadLocal<>() {

		@Override
		protected Integer initialValue() {
			// we are not setting value for thread local
			// default value needs to be computed at run time
			return ++threadID;
		}
	};

	// name for each thread instance
	private String tName;

	/**
	 * param constructor 
	 */
	public MyThread(String name) {
		this.tName = name;
	}

	@Override
	public void run() {
		System.out.println(this.tName+" thread got thread ID ="+tLocal.get().intValue());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(this.tName+" interrupted.");
		}
		System.out.println(this.tName+" thread completed it's execution with ID = "+tLocal.get().intValue());
	}
}