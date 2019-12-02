package multithread.evenOdd;

public class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isOddNumber;

    TaskEvenOdd(Printer print, int max, boolean isOddNumber) {
        this.print = print;
        this.max = max;
        this.isOddNumber = isOddNumber;
    }

    @Override
    public void run() {
        int number = isOddNumber == true ? 1 : 2;
        while (number <= max) {
            if (isOddNumber) {
                print.printOdd(number);
            } else {
                print.printEven(number);
            }
            number += 2;
        }
    }
}

