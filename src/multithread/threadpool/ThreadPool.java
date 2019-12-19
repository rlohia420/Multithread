package multithread.threadpool;

public class ThreadPool {

	BlockingQueue <Runnable> queue;
    public ThreadPool(int queueSize, int nThread) {
        queue = new BlockingQueue<>(queueSize);
        String threadName = null;
        TaskExecutor taskExecutor = null;
        for (int count = 0; count < nThread; count++) {
        	threadName = "Thread-"+count;
        	taskExecutor = new TaskExecutor(queue);
            Thread thread = new Thread(taskExecutor, threadName);
            thread.start();
        }
    }

    public void submitTask(Runnable task) throws InterruptedException {
        queue.enqueue(task);
    }
}
