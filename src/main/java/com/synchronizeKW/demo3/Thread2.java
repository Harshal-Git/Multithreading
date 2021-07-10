/**
 * 
 */
package com.synchronizeKW.demo3;

/**
 * @author Harshal-Git
 *
 *	-> thread to access only number printing methods
 */
public class Thread2 implements Runnable{

	private Display dispObj;
	
	/**
	 * parameterized constructor 
	 */
	public Thread2(Display d) {
		this.dispObj = d;
	}
	
	@Override
	public void run() {
		dispObj.printN();
	}

}
