/**
 * 
 */
package com.synchronizedBlock.demo4;

/**
 * @author Harshal-Git
 *
 *	-> a thread can acquire locks for multiple objects. 
 *
 *	-> ex: here when t1 gets hold of ClassX with runnable instance; the runX() method internally has to 
 *		create object of ClassY & ClassZ. 
 *
 *	-> locks for these objects will be acquired by t1 thread only. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RunnableInst runnable = new RunnableInst();
		Thread t1 = new Thread(runnable);
		t1.start();
	}
}
