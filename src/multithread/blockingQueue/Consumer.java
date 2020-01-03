package multithread.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {String ms=null;
			while (!(ms = queue.take().getMsz()).equals("Exit")) {
				System.out.println(ms);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
