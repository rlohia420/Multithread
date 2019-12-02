package multithread.sequence;

public class MultithreadSequence implements Runnable {
    static Object lock = new Object();
    static int number = 1;
    public int PRINT_NUMBERS_UPTO = 10;
    int remainder;

    public MultithreadSequence(int remainder) {
        this.remainder=remainder;
    }
    
    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            System.out.println(Thread.currentThread().getName() +" " + number);
            number++;
            lock.notifyAll();
            }
        }
    }
    public static void main(String args[]) {
        MultithreadSequence t11 = new MultithreadSequence(1);
        MultithreadSequence t12 = new MultithreadSequence(2);
        MultithreadSequence t13 = new MultithreadSequence(0);
        Thread t1=new Thread(t11,"A");
        Thread t2=new Thread(t12,"B");
        Thread t3=new Thread(t13,"C");
        
        t1.start();
        t2.start();
        t3.start();   
    }
}
