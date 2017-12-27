import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.LineNumberReader;
import java.io.FileReader;

public class MovieProject {

    public static void main (String [] args) throws Exception{

        System.out.println("Start of movie project");
        File fp = new File("movietitles.txt");
        Scanner fileScanner = new Scanner(fp);
        Double r = Math.random()*5;
        Integer conv = (r.intValue());
        //System.out.println("Random number check " + conv);

        FileReader fileReader = new FileReader(fp);
        LineNumberReader lineReader = new LineNumberReader(fileReader);
        int LineNumber = 0;
        while (lineReader.readLine() != null)
        {
            LineNumber += 1;
        }

        MoviesManager theaterList = new MoviesManager(LineNumber);
        Integer wordCounts = 0;
        while (fileScanner.hasNextLine())
        {
            String newLine = fileScanner.nextLine();
            //System.out.println(newLine);
            String currentName = newLine.split(":")[0];
            String currentYear = newLine.split(":")[1];
            //System.out.println();
            wordCounts = currentName.split(" ").length;
            theaterList.add(currentName, currentYear, wordCounts);
        }
        System.out.println();
        System.out.println("Movies that are stored: ");
        theaterList.view();

        System.out.println();
        String randomMovie = theaterList.movieLists[conv].returnName();
        System.out.println("Randomly chosen movie is: " + randomMovie);

        String hideTitle = "";
        for (int i =0; i < randomMovie.length(); i++)
        {
            //System.out.println(randomMovie.charAt(i));
            if(randomMovie.charAt(i) != '_')
            {
                //System.out.println("I'm here");
                hideTitle += "_";
            }
        }
        System.out.println(hideTitle);


        char[] theAnswer = hideTitle.toCharArray();
        String guessLists = "";
        Integer chance = 0;
        while(chance < 10) {
            System.out.println("You currently have " + (10 - chance) + " chances remaining");
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please guess the movie name: ");
            String guess = userInput.nextLine();

            for (int j = 0; j < randomMovie.length(); j++) {
                if (randomMovie.charAt(j) == ' ') {
                    theAnswer[j] = ' ';
                }
                else if (randomMovie.charAt(j) == guess.charAt(0)) {
                    //System.out.println("Guess correct!")
                    theAnswer[j] = guess.charAt(0);
                }
            }
            if (!randomMovie.contains(guess))
            {
                guessLists += guess + " ";
                System.out.println(guess + " is an incorrect guess");
                System.out.println("Wrong guesses so far: " + guessLists);
            }
            String finalAnswer = String.valueOf(theAnswer);

            if (finalAnswer.equals(randomMovie))
            {
                System.out.println("Congradulations, you have correctly guessed the movie!");
                System.exit(0);
            }

            System.out.println(finalAnswer);
            chance += 1;
        }
        System.out.println("Sorry, try again next time");

    }

}

class Movies {
    private String movieTitle;
    private String movieYear;
    private Integer movieWC;
    public Movies(String inputTitle, String inputYear, Integer inputWC)
    {
        this.movieTitle = inputTitle;
        this.movieYear = inputYear;
        this.movieWC = inputWC;
    }
    void insertName(String name){
        this.movieTitle = name;

    }
    void insertYear(String year){
        this.movieYear = year;
    }
    String returnName(){

        return movieTitle;

    }
    String returnYear(){
        return movieYear;
    }

}

class MoviesManager {
    Integer movieCounts;
    Movies [] movieLists;

/*    MoviesManager(){
        this.movieCounts = 0;
        this.movieLists = new Movies[(movieCounts)];
    }
    */
    MoviesManager (int inputNum){
        this.movieCounts = 0;
        this.movieLists = new Movies[inputNum];
    }
    void add(String movieN, String movieY, Integer wordC){
        //System.out.println("Current movie counts " + (movieCounts+1));
        movieLists[movieCounts] = new Movies(movieN, movieY, wordC);
        this.movieCounts += 1;
    }
    void view()
    {
        for (Integer counter = 0; counter < movieLists.length; counter++){
            System.out.println(movieLists[counter].returnName() +  movieLists[counter].returnYear());

        }
    }

}