/**
 * 
 */
package com.threadDeadlock.withLockedObjects;

/**
 * @author Harshal-Git
 *
 */
public class ThreadInstance extends Thread{

	private A a;
	private B b;
	
	/**
	 * parameterized constructor 
	 */
	public ThreadInstance() {
		this.a = new A();
		this.b = new B();
	}
	
	// called by main thread
	public void m1() {
		// main thread calling start() method; child thread started
		this.start();
		
		// main thread running m1() method on A
		a.m1(b);
	}
	
	@Override
	public void run() {
		// child thread running m1() method on B
		b.m1(a);
	}

}
