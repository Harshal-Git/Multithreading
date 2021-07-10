/**
 * 
 */
package com.synchronizeKW.demo4;

/**
 * @author Harshal-Git
 *
 */
public class RunnableINS implements Runnable{

	private Display disp;

	/**
	 * parameterized constructor 
	 */
	public RunnableINS(Display dis) {
		this.disp = dis;
	}

	/*
	 * run both methods together 
	 */
	@Override
	public void run() {
		disp.printC();
		disp.printN();
	}
}
