package multithread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CabServices implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CabServices(CyclicBarrier cyclicBarrier) {
        super();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("....." + Thread.currentThread().getName() + ".....");
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException ex) {
                ex.printStackTrace();
            }
            System.out.println("..Boarded the cab by thread.." + Thread.currentThread().getName() + ".....");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
