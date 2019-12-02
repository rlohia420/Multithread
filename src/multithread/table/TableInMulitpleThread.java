package multithread.table;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TableInMulitpleThread implements Runnable{

    /*
     * desired output -
     * 1*1=1 , 1*2 = 2.....n*n=n
    */
    int table;
    PrintTable pt;
    TableInMulitpleThread(int table , PrintTable pt){
        this.table = table;
        this.pt = pt;
        
    }
    @Override
    public void run() {
        try {
            pt.print(table);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        PrintTable n = new PrintTable();
        Executor ex = Executors.newFixedThreadPool(10);  
        for(int i=1;i<4;i++) {
            ex.execute(new TableInMulitpleThread(i,n));
        }
    }
}
