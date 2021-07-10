/**
 * 
 */
package com.synchronizedBlock.demo3;

/**
 * @author Harshal-Git
 *
 */
public class RunnableInst implements Runnable {

	private Display disp;
	private String name;
	
	/**
	 * parameterized constructor 
	 */
	public RunnableInst(Display display, String value) {
		this.disp = display;
		this.name = value;
	}
	
	@Override
	public void run() {
		disp.wish(name);
	}
}
