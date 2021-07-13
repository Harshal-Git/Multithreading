/**
 * 
 */
package com.threadLocal.demo1;

/**
 * @author Harshal-Git
 *
 *	-> main thread handling thread local object
 *
 *	-> the current thread which is executing the thread local lines; will be in control.  
 */
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a thread local 
		ThreadLocal<String> tLocal = new ThreadLocal<>();

		// get current thread name
		String tName = Thread.currentThread().getName();
		
		// get initial value
		System.out.println("For "+tName+" thread default Thread local value (1): "+tLocal.get());
		
		// set value
		tLocal.set("FirstVal");
		System.out.println("For "+tName+" thread Thread local value after set() (2): "+tLocal.get());
		
		// remove value
		tLocal.remove();
		System.out.println("For "+tName+" thread Thread local value after remove() (3): "+tLocal.get());
	}

}
