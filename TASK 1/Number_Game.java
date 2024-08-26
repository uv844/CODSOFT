import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    static int NumberOfAttempts=0; // counter variable to calculate no. of attempts
    static Scanner sc = new Scanner(System.in); // Scanner class to take input from user

    public static int Random_Number_Generator() {

        // generating random number between 1 and 100
        Random rand = new Random();
        int random_no = rand.nextInt(100) + 1; // generating random number including both 1 and 100
        System.out.println("\nNumber Generated");
        return random_no;
    }

    public static void Compare_Guess(int random_no) {
        
        ++NumberOfAttempts;
        if(NumberOfAttempts>3) // checking if attempts exceeds the limit or not
        {
            System.out.println("\n================================================================================");
            System.out.println("The correct number is "+random_no);
            System.out.println("Better Luck next time");
            return;
        }

        System.out.println("\nAttempt "+NumberOfAttempts); // printing attempt number
        int guess = sc.nextInt(); // taking user's guess
        
        while ( !(guess > 0 && guess < 101)) // checking if guess is within the range or not and if not taking correct input 
        {
            System.out.println("Please guess the number between 1 and 100");
            guess = sc.nextInt();
        }

        if(guess == random_no) // checking if guess is equal to generated number
        {
            System.out.println("\n================================================================================");
            System.out.println("Hey! You guessed it right");
            System.out.println("The number is "+random_no);
            return;
        }

        else
        {
            if( guess > random_no)
                System.out.println("\nYour guess is too high");
            else
                System.out.println("\nYour guess is too low");
                
            Compare_Guess(random_no);
        }
    }

    public static void displayScore() {
        // displaying score
        
        if(NumberOfAttempts>3)
            System.out.println("Your Score: 0/3");
        
        else
        {
            int score = 3-(NumberOfAttempts - 1)*1; // Score = Maximum possible score - (Number of attempts - 1) * Score deduction per attempt
            System.out.println("Your Score: "+score+"/3");
        }
        System.out.println("================================================================================\n");
    }

    public static void Game_Starts() {

        int random_no = Random_Number_Generator();
        System.out.println("Please guess a number between 1 and 100");
        Compare_Guess(random_no);
        displayScore();
    }

    public static void main(String[] args) {
        
        Game_Starts();
        int choice;
        do{
            System.out.println("\nEnter your choice\n");
            System.out.println("1. Play again");
            System.out.println("2. Display Score");
            System.out.println("3. Exit the Game");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: NumberOfAttempts=0;
                        Game_Starts();
                        break;

                case 2: System.out.println("\n================================================================================");
                        displayScore();
                        break;

                case 3: System.out.println("\nThank You :)");
                        break;
                        
                default:System.out.println("Choose the option from the list");
                        choice=sc.nextInt();
                        break;
            }
        }while(choice!=3);
        sc.close();
    }
}