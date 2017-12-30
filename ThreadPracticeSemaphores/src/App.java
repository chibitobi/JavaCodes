import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main (String [] args) throws Exception{
        Semaphore sem = new Semaphore(1);

        sem.release(); //increment
        sem.acquire(); //decrement

        System.out.println("Available permits: " + sem.availablePermits());

        //thing about semaphore is that this "lock" is not tied to a single thing.
        //therefore semaphore is spread out different threads, and different threads can
        //release

        Connection.getInstance().connect();

        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 200; i++)
        {
            executor.submit(new Runnable() {
                public void run(){
                    Connection.getInstance().connect();
                }
            });

        }

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.DAYS);

    }
}
