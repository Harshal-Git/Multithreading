/**
 * 
 */
package com.threadLocal.demo1;

/**
 * @author Harshal-Git
 *
 *	-> main thread handling thread local object with default initial value.
 *
 *	-> the current thread which is executing the thread local lines; will be in control.
 */
public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a thread local 
		ThreadLocal<String> tLocal = new ThreadLocal<>() {
			/*
			 * override default value for run time
			 */
			@Override
			protected String initialValue() {
				return "DefaultVal";
			}
		};

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
