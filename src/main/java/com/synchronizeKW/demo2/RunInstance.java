/**
 * 
 */
package com.synchronizeKW.demo2;

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
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		wishObj.wish(name);
	}

	
}
