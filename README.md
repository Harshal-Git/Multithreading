# Multi threading
Threads &amp; Multi threading concepts

###

Threads & Multi threading basic concepts:

2 ways to initialize thread : 
	1. extending thread class
	2. Implementing runnable interface
	
Thread execution prevention
	1. yield()
	2. join() - actually a wait operation which waits for other threads to finish it's execution
	3. sleep()
	
Thread interruption 
	1. interrupt() 
	
Synchronization : synchronized keyword for 
	1. method 
	2. block
	
-> Object lock is obtained at object level & not at method level.

Inter-thread communication
	1. wait()
	2. notify()
	3. notifyAll()
	
Dead lock

Deamon threads

Multi threading enhancements