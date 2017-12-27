public class Main {

    public static void main (String [] args){

        System.out.println("Meh");
        Games Tetris = new Games(1337);
        System.out.println("Initialized Game Score for Tetris: " + Tetris.mScore);
    }
}

class Games {

    int mScore;
    /*Games(){
        mScore = 0; //initializing game score using constructor

    }*/
    // parameterized constructor
    Games(int inputint){
        this.mScore = inputint;
        //self referencing
    }

}