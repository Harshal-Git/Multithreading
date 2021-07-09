/**
 * 
 */
package com.synchronizeKW.demo3;

/**
 * @author Harshal-Git
 *
 */
public class Thread1 implements Runnable{

	private Display dispObj;
	
	/**
	 * parameterized constructor 
	 */
	public Thread1(Display d) {
		this.dispObj = d;
	}
	
	@Override
	public void run() {
		dispObj.printC();
	}

}
