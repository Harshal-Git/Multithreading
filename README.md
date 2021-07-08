# Multi threading
Threads &amp; Multi threading concepts

###

#PENDING  : Given 2 arrays - {1, 3, 5, 7, 9} and {2, 4, 6, 8, 10} and print 1-10 in sequence using threads.

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
	
Synchronization

Inter-thread communication
	1. wait()
	2. notify()
	3. notifyAll()
	
Dead lock

Deamon threads

Multi threading enhancements