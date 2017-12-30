import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();

    private Semaphore sem = new Semaphore(10, true);
    //furnace parameter, where true enforces fairness

    private int connections = 0;

    private Connection(){

    }
    public static Connection getInstance(){
        return instance;
    }

    public void connect(){
        try{
            sem.acquire();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        try {
            doconnect();
        } finally {
            sem.release();
        }
    }

    public void doconnect(){


        synchronized(this){

            connections++;
            System.out.println("Current connections " + connections);
        }
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        synchronized(this){

            connections--;
        }

    }

}
