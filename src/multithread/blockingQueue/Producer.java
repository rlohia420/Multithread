package multithread.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i <10; i++) {
				Message m = new Message(" i " + i);
				queue.put(m);
			}
			queue.put(new Message("Exit"));
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
