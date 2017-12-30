package demo1;

//to use thread in Java, you need to extend Thread class.
class Runner extends Thread {
    //thread class has method called run
    public void run(){

        for(int i = 0; i < 10; i++){
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
                //runs this for 100 miliseconds, sleep pauses your thread
            } catch (InterruptedException e){

                e.printStackTrace();
            }

        }

    }
}

public class App {

    public static void main(String [] args){
        Runner runApp1 = new Runner();
        runApp1.start(); //calling start is used instead of run because if I call run(),
                        //this will start the main thread, but by using start, I force
                        //thread class to run void run() in its own special thread
        //to check it is running concurrently, you add below code
        Runner runApp2 = new Runner();
        runApp2.start();
        //now output should go hello 0 hello 0 and so on.

    }
}
