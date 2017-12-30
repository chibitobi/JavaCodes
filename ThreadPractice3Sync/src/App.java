public class App {

    private int count = 0;

    public synchronized void increment(){

        count++;
        //every object in java has "intrinsic lock" or "mutex"
        //by using synchronized method, this utilized these said locks.
        //this is implicit synchronization method
    }
    //now this is synchronized method.

    public static void main(String [] args){

        App appVar = new App();
        appVar.doWork();

    }

    public void doWork(){

        Thread t1 = new Thread(new Runnable() {

            public void run(){

                for(int i = 0; i < 10000; i++){

                    increment();

                }
            }


        });
        Thread t2 = new Thread(new Runnable() {

            public void run(){

                for(int i = 0; i < 10000; i++){

                    count+=1;

                }
            }


        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            //by adding these two functions, now thread waits until one is finished. Therefore EXPECTED value
            //is 20000, but this is NOT consistent. The reason is atomicity is not enforced.
        }
        catch (InterruptedException e){

            e.printStackTrace();
        }
        System.out.println("Count is " + count);
        //notice how both of these threads are accessing the SAME variable.
        //this gets output 0 without wait as the procedure of creating the thread makes System.out.println
        //print the value without having the chance to run through the loop.


    }

}

