ForkJoinPool framework usage:

Usually this framework will help to resolve bigger problems; which are generally resolved by Divide-and-Conquer approach.

This has 2 main types of tasks; which are subclass of java.util.concurrent.ForkJoinTask<V> abstract class.

1. RecursiveTask<T> - which computes & returns the result.

2. RecursiveAction - which computes and doesn't return anything.

###

3 important methods needed to be considered:

1. fork() - to divide the task 

2. compute() - to perform actual computation of the divided tasks

3. join() - recursively returns the result to the parent calls