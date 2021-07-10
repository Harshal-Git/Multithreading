/**
 * 
 */
package com.synchronizedBlock.demo4;

/**
 * @author Harshal-Git
 *
 */
public class RunnableInst implements Runnable {

	@Override
	public void run() {
		ClassX xObj = new ClassX();
		xObj.runX();
	}
}
