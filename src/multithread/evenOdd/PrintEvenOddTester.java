package multithread.evenOdd;

public class PrintEvenOddTester {
    public static void main(String... args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, true),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, false),"Even");
        t1.start();
        t2.start();
    }
}
