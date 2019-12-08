package multithread.cyclicBarrier;
import java.util.concurrent.CyclicBarrier;
public class CyclicBarrierImplementation {
    public static void main(String args[]) {
        CyclicBarrier cb = new CyclicBarrier(3);
        CabServices cs = new CabServices(cb);
        Thread th1 = new Thread(cs);
        th1.start();
        Thread th2 = new Thread(cs);
        th2.start();
        Thread th3 = new Thread(cs);
        th3.start();
    }
}
