import java.util.Scanner;

class Processor extends Thread{
    //processor gonna run some codes in thread
    private volatile boolean running = true;
    //another thread may cache this value
    //volatile is used to prevent threads caching variables when they are not changed

    public void run(){
        //overriding thread run class

        while(running){

            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
    public void shutdown(){

        this.running = false;
    }


}

public class App {

    public static void main(String [] args){

        Processor proc1 = new Processor();
        proc1.start();
        // you can use thread interruption to gracefully exit or... in this tutorial
        System.out.println("Press return to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
        }

}
