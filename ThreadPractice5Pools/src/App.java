import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

    private int id;
    public Processor(int id){
        this.id = id;
    }

    public void run(){
        System.out.println("Starting: " + this.id);
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e){

        e.printStackTrace();
    }
        System.out.println("Completed " + this.id);
    }
}


public class App {

    public static void main(String [] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //thread pool is like having workers in the factory.
        //so in this case we have two.
        for (int i = 0; i < 5; i++){

            executor.submit(new Processor(i));
        }
        executor.shutdown();
        //it will shutdown after all threads complete what they are doing

        System.out.println("All tasks submitted.");
        try {
        executor.awaitTermination(1, TimeUnit.DAYS);}
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("All tasks completed");
    }

}
