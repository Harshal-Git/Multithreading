/**
 * 
 */
package com.threadDeadlock.withLockedObjects;

/**
 * @author Harshal-Git
 *
 */
public class B {
	
	/*
	 * m1() from B
	 */
	public synchronized void m1(A a1) {
	//public void m1(A a1) {
		System.out.println("m1() from B");
		System.out.println("B.m1() calling A.m2()");
		a1.m2();
	}

	public synchronized void m2() {
		System.out.println("m2() from B");
	}
}
