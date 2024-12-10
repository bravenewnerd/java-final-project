/*
*import statments go here
*/
import java.util.*;
/*
 * This is a super class that defines basic methods 
 * and data fields for all menus
 * as well as the program's main menu
 */
public class Menu
{
    /*
    *Global vars
    */
    public String choice;//var for storing user input string
    private int game;//var for storing user input int
    private Boolean flag;//flag for loops
    /*
     * main menu sentinels
     */
    private String newGame = "games";                
    private String exit = "exit";

    public Menu() 
    {
        //empty constructor
    }
    
    public void displayMainMenu() //method for menu calling
    {
        Scanner imp = new Scanner(System.in); //summon the imp
        /*
        *Display menu options
        */
        System.out.println("Type your selection:");
        System.out.println("Games");
        System.out.println("Exit");
        /*
         * process user input
         */
        flag = true;
        while(flag)//loop for validating input
        {
            choice = imp.nextLine();
            choice = choice.toLowerCase();//convert to lowercase so we don't have to worry about incorrect case
            if (choice.equals(newGame))
            {
                System.out.println('\n');
                displayGames();//display the 'games' menu
                flag = false;
            }
            else if(choice.equals(exit))
            {
                System.out.println('\n');
                displayExit();//exit the program
                flag = false;
            }
            else //invalid input message
            {
                System.out.println("Invalid input.Please try again.\n");
                System.out.println("Type your selection:");
                System.out.println("Games");
                System.out.println("Exit");
            }
        }
        imp.close(); //banish the imp
    }
    
    public void displayExit(){//exit command. kills program
        System.out.println("See you, Space Cowboy!");//display text to confirm exit
    }

    public void displayGames()//method for 'games' menu
    {
        Scanner imp = new Scanner(System.in);//summon the imp
        /*
         * Prints for method body
         */
        System.out.println("Type the number of the game you would like to play.\n");
        System.out.println("1) Rock,Paper,Scissors,Unicorn,Donut");
        System.out.println("2) High Card,Low Card");
        System.out.println("5) Exit");
        System.out.print(" >>> ");
        /*
         * process and validate user input
         */
        flag = true;
        while(flag)
        {
            /*
             * check if the imp brought
             * an integer because
             * a string will cause an
             * exception to be thrown from
             * .nextInt()
             */
            if(imp.hasNextInt())
            {
                
                game = imp.nextInt();
                Boolean nextFlag = true;//flag for integer validation loop
                while(nextFlag)//integer validation loop
                {
                    if(game == 1)
                    {
                        RPSMenu RPS = new RPSMenu();
                        RPS.displayRPSMenu();
                        nextFlag = false;
                        flag = false;
                    }
                    else if(game == 2)
                    {
                        HighLowMenu hl = new HighLowMenu();
                        hl.displayHLMenu();
                        nextFlag = false;
                        flag = false;
                    }
                    else if(game == 3)
                    {
                        
                    }
                    else if(game == 4)
                    {
                        
                    }
                    else if(game == 5)
                    {
                        displayExit();
                        nextFlag = false;
                        flag = false;
                    }
                    /*
                     * if we make it here we know the user
                     * entered an incorrect number
                     */
                    else
                    {
                        System.out.println("Invalid input.Please type a number from the menu.\n");
                        System.out.println("1) Rock,Paper,Scissors,Unicorn,Donut");
                        System.out.println("2) High Card, Low Card");
                        System.out.println("5) Exit");
                        System.out.print(" >>> ");
                        nextFlag = false;
                        choice = imp.nextLine();
                    }
                    //out of loop
                }
            }
            /*
             * this else statement triggers
             * if the user did not input a number at all
             */
            else
            {
                System.out.println("Invalid input.Please type a number.\n");
                System.out.println("Type the number of the game you would like to play.\n");
                System.out.println("1) Rock,Paper,Scissors,Unicorn,Donut");
                System.out.println("2) High Card,Low Card");
                System.out.println("5) Exit");
                System.out.print(" >>> ");
                choice = imp.nextLine();
            }
        }
        //out of loop
        imp.close();//banish the imp
    }
}