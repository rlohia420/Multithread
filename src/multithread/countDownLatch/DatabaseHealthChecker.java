package multithread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker  extends BaseHealthChecker{
    public DatabaseHealthChecker (CountDownLatch latch)  {
        super("DataBase health check Service", latch);
    }
     
    @Override
    public void verifyService() 
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(7000);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }

}
