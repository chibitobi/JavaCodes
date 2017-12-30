package demo3;

public class App3 {

    public static void main(String [] args){

        //this is method to not create an entire class for thread.
        Thread t1 = new Thread(new Runnable() {
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

        });
        t1.start();
    }

}
