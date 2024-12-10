import java.util.*;

public class RPSMenu extends Menu
{
    Scanner imp = new Scanner(System.in); //summon the imp
    private String RPS = "rps"; 
    private String RPSDU = "unicorn";
    private String exit = "exit";
    
    public void displayRPSMenu()
    {
        RockPaperScissors newGame = new RockPaperScissors();//object for game traversal
        /*
         * menu body
         */
        System.out.println("\nWhat would you like to play?\n");
        System.out.println("Type RPS to play");
        System.out.println("Rock,Paper,Scissors\n");
        System.out.println("Or type UNICORN to play");
        System.out.println("Rock,Paper,Scissors,Donut,Unicorn\n");
        System.out.println("Type exit to go back to the main menu.");
        System.out.print(">>> ");
        /*
         * process and validate user input
         */
        choice = imp.nextLine();
        choice = choice.toLowerCase();
        Boolean flag = true;
        while(flag)
        {
            if(choice.equals(RPS))
            {
                newGame.playRPS();
                flag = false;
            }
            else if(choice.equals(RPSDU))
            {
                newGame.playUnicorn();
                flag = false;
            }
            else if(choice.equals(exit))
            {
                displayMainMenu();
                flag = false;
            }
            else
            {
                System.out.println("\nInvalid Input.\n");
                System.out.println("What would you like to play?\n");
                System.out.println("Type RPS to play");
                System.out.println("Rock,Paper,Scissors\n");
                System.out.println("Or type UNICORN to play");
                System.out.println("Rock,Paper,Scissors,Donut,Unicorn\n");
                System.out.println("Type exit to go back to the main menu.");
                choice = imp.nextLine();
                choice = choice.toLowerCase();
            }
        }
    }
}