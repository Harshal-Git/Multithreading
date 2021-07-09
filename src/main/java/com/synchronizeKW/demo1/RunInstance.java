/**
 * 
 */
package com.synchronizeKW.demo1;

/**
 * @author Harshal-Git
 *
 */
public class RunInstance implements Runnable {

	private String name;
	private Wish wishObj;
	
	/**
	 * parameterized constructor 
	 */
	public RunInstance(String pName, Wish wObj) {
		this.name = pName;
		this.wishObj = wObj;
	}
	
	@Override
	public void run() {
		wishObj.wish(name);
	}

	
}
