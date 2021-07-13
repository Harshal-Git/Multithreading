Thread pools / Executor framework important types of pools:

1. newFixedThreadPool() - Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.

2. newWorkStealingPool() - Creates a thread pool that maintains enough threads to support the given parallelism level, and may 
use multiple queues to reduce contention. 

3. newSingleThreadExecutor() - Creates an Executor that uses a single worker thread operating off an unbounded queue.

4. newCachedThreadPool() - Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads 
when they are available. These pools will typically improve the performance of programs that execute many short-lived asynchronous tasks.

5. newSingleThreadScheduledExecutor() - Creates a single-threaded executor that can schedule commands to run after a given delay, or to 
execute periodically.

6. newScheduledThreadPool() - Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.


###

In case when return values are not expected from a job, java.lang.Runnable can be used.

In case when return values are expected after job completion, java.util.concurrent.Callable is expected to be used.