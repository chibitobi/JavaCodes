import java.util.Scanner;

public class GuessingGame {

    public static void main(String [] args) {

        System.out.println("Guessing Game!\n");
        Double r = Math.random();
        Double range = r*100 + 1;
        Integer randomNum = range.intValue(); //type cast
        System.out.println(randomNum);

        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        Integer counter = 0;
        do{
            counter += 1;
            System.out.println("Current try num (you only have 10) " + counter);
            System.out.println("Insert random number");
            Integer userRand = scanner.nextInt();
            if (userRand < randomNum)
            {
                System.out.println("Your guessed number is less than system generated");
            }
            else if (userRand > randomNum)
            {
                System.out.println("Your guessed number is greater than system generated");
            }
            else if (userRand == randomNum)
            {
                System.out.println("Guessed correctly!");
                found = true;
            }
        }while(found == false || counter >= 10);
    }
}
