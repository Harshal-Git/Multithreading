/**
 * 
 */
package com.threadDeadlock.withLockedObjects;

/**
 * @author Harshal-Git
 *
 */
public class A {
	
	/*
	 * m1() from A
	 */
	public synchronized void m1(B b1) {
		System.out.println("m1() from A");
		System.out.println("A.m1() calling B.m2()");
		b1.m2();
	}
	
	public synchronized void m2() {
		System.out.println("m2() from A");
	}
}
