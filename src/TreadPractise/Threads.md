## Thread lifecycle and Thread pool

### Thread Life Cycle
A thread goes through several states during its lifetime:

- New State: The thread has been created but not yet started. No system resources are allocated.
- Runnable State: After calling start(), the thread enters the runnable state and is waiting for the CPU to execute it.
- Running State : The CPU selects the thread for execution, and it starts running.
- Timed Waiting State : A thread enters this state when it calls sleep(). It returns to the runnable state when the sleep duration expires.
- Waiting State :  A thread enters this state when it calls wait(). It remains here until another thread calls notify() or notifyAll().
- Blocked State : If a thread encounters an I/O operation, it enters a blocked state until the operation is completed.
- Terminated State : The thread finishes its execution, either normally or due to an exception. Once terminated, it cannot be restarted.

### Thread Pool :
A thread pool is a managed collection of reusable threads. Instead of creating and destroying threads for every task, a thread pool allows you to reuse existing threads, which offers several benefits:

 - Resource Management : Prevents system overload by limiting the number of active threads, avoiding unnecessary context switching and resource contention.
 - Performance Improvement : Reduces the overhead of creating and destroying threads, leading to better performance.
 - Maintainability and Task Management : Provides better control over thread creation and allows for queuing, scheduling, and monitoring tasks.
 - **Thread Pool Lifecycle** 
   - Pool Creation : The thread pool is created with a set of pre-created "core threads" in a new state. These threads immediately enter a runnable state.
   - Task Submission : When a task is submitted, an idle thread from the pool executes it.
   - Thread Return : Once a task is completed, the thread returns to the pool's runnable state, ready for the next task.
   - Pool Shutdown : The pool can be shut down using shutdown() for graceful termination (completing current tasks) or shutdownNow() for immediate interruption and termination.


## ExecutorService
- execute(): This method is for a "fire and forget" mode. It accepts Runnable tasks only and does not return any result or provide mechanisms for tracking task completion or exceptions. If a task throws an exception, it won't be retrievable.
- submit(): This method returns a Future object, which allows tracking of the task, retrieving results, and checking for exceptions or failures. It accepts both Runnable and Callable tasks.
- invokeAll(): This method allows submitting a collection of Callable tasks and returns a list of Future objects. It can also specify a timeout.
- shutdown(): This method provides a graceful shutdown of the executor service, allowing currently running tasks to complete before termination.
- shutdownNow(): This method performs an instant shutdown, attempting to interrupt running tasks and returning a list of tasks that were not started or were interrupted.
- Monitoring Methods: Includes getActiveCount() and getQueue().size() for performance tuning and debugging.

### ThreadPoolExecutor
- The ThreadPoolExecutor is a powerful and flexible implementation of ExecutorService in Java, designed for advanced management of thread pools. 
- It provides fine-grained control over various aspects of thread management, making it suitable for production-grade concurrent applications.

- **Core Pool Size**: The minimum number of threads that are kept alive in the pool, even if they are idle.
- **Maximum Pool Size**: The maximum number of threads that the pool can create.
- **Queue Capacity**: The size of the queue that holds tasks when all core threads are busy.
- **Keep-Alive Time**: The duration for which idle threads (beyond the core pool size) wait for new tasks before terminating.
- **Rejected Execution Handler**: Defines the policy for handling tasks that cannot be accepted (e.g., when the queue is full and the maximum pool size is reached).

 - #### Task Execution Flow:
   - When a task is submitted, the ThreadPoolExecutor first checks if the number of active threads is less than the corePoolSize. If so, a new thread is created to execute the task.
   If all core threads are busy, the task is added to the internal queue.
   - If the queue is full, and the current number of threads is less than the maximumPoolSize, a new thread is created to handle the task.
   - If both the core threads and the queue are full, and the maximum pool size is reached, the RejectedExecutionHandler is invoked to deal with the unhandled task.

 - #### Benefits:
   - Full Control: Offers extensive control over thread creation, pooling, and task execution, allowing for highly optimized performance tuning.
   -  Resource Management: Prevents resource exhaustion by limiting the number of concurrently running threads.
   - Reusability: Threads are reused for multiple tasks, reducing the overhead of constantly creating and destroying threads.
   - Fair Scheduling: Can be configured to provide fair scheduling among tasks, preventing starvation of lower-priority tasks.
   - Usage in Production : ThreadPoolExecutor is crucial for production environments where precise control over thread behavior and resource utilization is necessary. It is the underlying implementation for various ExecutorService instances created by the Executors factory class.

## Executors (Factory Class)
- newFixedThreadPool(int nThreads): Creates a thread pool with a fixed number of reusable threads. Tasks are queued if all threads are busy.
- newCachedThreadPool(): Creates a thread pool that recycles idle threads and creates new ones as needed, without a fixed size limit.
- newScheduledThreadPool(int corePoolSize): Creates a thread pool that can schedule tasks to run after a delay or periodically.
- newSingleThreadExecutor(): Creates an ExecutorService that uses a single worker thread to execute tasks sequentially.


## ScheduledExecutorService
- schedule(Runnable command, long delay, TimeUnit unit): Schedules a task to run once after a specified delay.
- scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit): Schedules a task to run repeatedly at a fixed rate after an initial delay. The execution is independent of the task's completion time.
- scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit): Schedules a task to run repeatedly with a fixed delay between the completion of one execution and the start of the next.


## Different types of Locks

### Intrinsic Locks (Synchronized Keyword): 
This is the built-in locking mechanism in Java. When a thread enters a synchronized method or block, it automatically acquires the lock on the object and releases it upon exiting, even if an exception occurs.

### Explicit Locks (Lock Interface):
These provide more sophisticated features than intrinsic locks. The java.util.concurrent.locks package offers explicit locking with higher flexibility, allowing for non-blocking operations like tryLock().

### Reentrant Lock:
- A specific implementation of the Lock interface where the thread that holds the lock can re-acquire it without causing deadlocks. 
- It allows for advanced control over locking, such as timed lock attempts and interruptible lock acquisition.

### Read-Write Lock:
- This allows multiple threads to read a shared resource simultaneously, provided no thread is writing to it. 
- However, it ensures exclusive access for writing; if a writer holds the lock, no other readers or writers can access the resource.

### Semaphores: 
Unlike locks, which enforce exclusive access for a single thread, semaphores control access to a specific number of resources. 
They maintain a count of permits. Threads must acquire a permit before accessing a resource and release it when finished.

### Binary Semaphore: 
A semaphore with only one permit, acting similarly to a mutex or a simple lock.

### Counting Semaphore:
A semaphore allowing a specified number of threads to access a resource concurrently.