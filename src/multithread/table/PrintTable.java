package multithread.table;

public class PrintTable {

    public void print(int n) {
        synchronized (this) {

            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName() + " & " + n + " * " + i + "= " + n * i);
                try//not manadatry
                {
                    Thread.sleep(400);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}
