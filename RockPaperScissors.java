import java.util.*;//utility package for scanner and random

public class RockPaperScissors
{
    Random rand = new Random(); //new object for generating random numbers
    Menu menu = new Menu();//object for main menu traversal
    /*
     * loop sentinels
     */
    private int rounds; //number of rounds player will go through
    private int loops = 0;//sentinel for rounds loop
    Boolean flag = true;
    Boolean roundsCheck;
    /*
     * RPSUD set as numbers for 
     * checking opponent weapon 
     * against player choice
     */
    private int rock = 1;
    private int paper = 2;
    private int scissors = 3;
    private int unicorn = 4;
    private int donut = 5;
    private int opp;//the opponent
    /*
     * random seeds with bounds
     */
    private int RPSSeed;
    private int UnicornSeed = rand.nextInt(6);
    /*
     * player variables
     * for tracking stats
     * and selecting weapon
     */
    private int player;
    private int wins;
    private int losses;
    private int draws;
    /*
    * menu sentinels
    */
    private String choice;
    private String help = "help";
    private String exit = "exit";
    private String yes = "yes";
    private String no = "no";
    /*
     * This method plays the traditional
     * Rock paper scissors
     */
    public void playRPS()
    {
        RPSMenu rps = new RPSMenu();
        Scanner imp = new Scanner(System.in);

        System.out.println("\nWelcome to Rock, Paper, Scissors");
        System.out.println("How many rounds would you like to play today?\n");
        System.out.println("Type help for instructions or exit to go back!");
        System.out.print(">>> ");
        roundsCheck = imp.hasNextInt();
        choice = imp.nextLine();
        choice = choice.toLowerCase();
        /*
         * process and validate input
         */
        while(flag)
        {
            if(choice.equals(help))//instructions
            {
                System.out.println("\nRock smashes Scissors");
                System.out.println("Scissors cuts Paper");
                System.out.println("Paper covers Rock");
                System.out.println("Press Enter to Start.");
                imp.nextLine();
                playRPS();
                flag = false;
            }
            else if(choice.equals(exit))//return to main menu
            {
                System.out.println("");
                menu.displayGames();
                flag = false;
            }
            else if(roundsCheck)
            {
                rounds = Integer.parseInt(choice);//turn input string to an integer
                flag = false;
            }
            else
            {
                System.out.println("\nInvalid input");
                System.out.println("\nWelcome to Rock, Paper, Scissors");
                System.out.println("How many rounds would you like to play today?\n");
                System.out.println("Type help for instructions or exit to go back!");
                System.out.print(">>> ");
                roundsCheck = imp.hasNextInt();
                choice = imp.nextLine();
                choice = choice.toLowerCase();
            }
        }
        while(loops<rounds)//rounds control loop
        {
            RPSSeed = rand.nextInt(4);
            opp = RPSSeed + 1;//plus one because java lists start at 0 and are boundary exclusive
            System.out.println("Enter the number of your selection");
            System.out.println("1) Rock\n2) Paper\n3) Scissors");
            player = imp.nextInt();
            imp.nextLine();
            System.out.println("");
            Boolean flag = true;
            while(flag)//RPS comparison control loop.Also Validates input
            {
                /*
                 * Rock if-else
                 */
                if(opp == rock && player == rock)
                {
                    System.out.println("Rock and Rock. You tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == rock && player == paper)
                {
                    System.out.println("Paper covers Rock.You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == rock && player == scissors)
                {
                    System.out.println("Rock smashes Scissors! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                /*
                 * Paper if-else
                 */
                else if(opp == paper && player == rock)
                {
                    System.out.println("Paper covers Rock! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == paper && player == paper)
                {
                    System.out.println("Paper and Paper. You Tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == paper && player == scissors)
                {
                    System.out.println("Scissors cuts Paper! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                /*
                 * Scissors if-else
                 */
                else if(opp == scissors && player == rock)
                {
                    System.out.println("Rock smashes Scissors! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == scissors && player == paper)
                {
                    System.out.println("Scissors cuts Paper! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == scissors && player == scissors)
                {
                    System.out.println("Scissors and Scissors. You Tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else//input (in)validation
                {
                    System.out.println("\nInvalid Input.\n");
                    System.out.println("Enter the number of your selection");
                    System.out.println("1) Rock\n2) Paper\n3) Scissors");
                    player = imp.nextInt();
                    imp.nextLine();
                    System.out.println("");
                }
            }
            loops++;
        }
        //OUT OF LOOP
        System.out.println("\nYou played a total of "+rounds+" round(s).");
        System.out.println("You won "+wins+" round(s).");
        System.out.println("You lost "+losses+" round(s).");
        System.out.println("You tied "+draws+" round(s).\n");
        System.out.println("Input YES to play again.\n Or NO to return to the main menu.");
        choice = imp.nextLine();
        choice = choice.toLowerCase();
        flag = true;
        while(flag)//play again input validation
        {
            if(choice.equals(yes))
            {
                rps.displayRPSMenu();
                flag = false;
            }
            else if(choice.equals(no))
            {   
                menu.displayGames();
                flag = false;
            }
            else
            {
                System.out.println("Invalid input.");
                System.out.println("Input YES to play again.\n Or NO to return to the main menu.");
                choice = imp.nextLine();
                choice = choice.toLowerCase();
            }
        }
        imp.close();//banish the imp
    }
    /*
     * this method plays
     * Rock,Paper,Scissors,Donut,unicorn
     */
    public void playUnicorn()
    {
        RPSMenu rps = new RPSMenu();//object for RPS game menu traversal
        Scanner imp = new Scanner(System.in);

        System.out.println("\nWelcome to Rock, Paper, Scissors, Unicorn, Donut");
        System.out.println("How many rounds would you like to play today?");
        System.out.println("Type help for instructions or exit to go back!");
        roundsCheck = imp.hasNextInt();
        choice = imp.nextLine();
        choice = choice.toLowerCase();
        flag = true;
        while(flag)
        {
            if(choice.equals(help))
            {
                System.out.println("Rock crushes Donut");
                System.out.println("Donut chokes Unicorn");
                System.out.println("Unicorn stomps Scissors");
                System.out.println("Scissors cuts Paper");
                System.out.println("Paper covers Rock");
                System.out.println("Rock smashes Scissors");
                System.out.println("Scissors slices Donut");
                System.out.println("Donut sits on Paper");
                System.out.println("Paper blinds Unicorn");
                System.out.println("Unicorn tramples Rock");
                System.out.println("");
                System.out.println("Get it?");
                imp.nextLine();
                playUnicorn();
                flag = false;
            }
            else if(choice.equals(exit))
            {
                menu.displayMainMenu();
                flag = false;
            }
            else if(roundsCheck)
            {
                rounds = Integer.parseInt(choice);
                flag = false;
            }
            else
            {
                System.out.println("\nInvalid input");
                System.out.println("\nWelcome to Rock, Paper, Scissors, Unicorn, Donut");
                System.out.println("How many rounds would you like to play today?\n");
                System.out.println("Type help for instructions or exit to go back!");
                System.out.print(">>> ");
                roundsCheck = imp.hasNextInt();
                choice = imp.nextLine();
                choice = choice.toLowerCase();
            }
        }
        while(loops<rounds)
        {
            UnicornSeed = rand.nextInt(6);
            opp = UnicornSeed + 1;
            System.out.println("Enter the number of your selection");
            System.out.println("1) Rock\n2) Paper\n3) Scissors\n4) Unicorn\n5) Donut");
            player = imp.nextInt();
            imp.nextLine();
            flag = true;
            while(flag)
            {
                /*
                 * Rock if-else
                 */
                if(opp == rock && player == rock)
                {
                    System.out.println("Rock and Rock. You tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == rock && player == paper)
                {
                    System.out.println("Paper covers Rock.You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == rock && player == scissors)
                {
                    System.out.println("Rock smashes Scissors! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == rock && player == unicorn)
                {
                    System.out.println("Unicorn tramples Rock! You Win! Good Job:)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == rock && player == donut)
                {
                    System.out.println("Rock smashes Donut! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                /*
                 * Paper if-else
                 */
                else if(opp == paper && player == rock)
                {
                    System.out.println("Paper covers Rock! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == paper && player == paper)
                {
                    System.out.println("Paper and Paper. You Tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == paper && player == scissors)
                {
                    System.out.println("Scissors cuts Paper! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == paper && player == unicorn)
                {
                    System.out.println("Paper blinds Unicorn! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == paper && player == donut)
                {
                    System.out.println("Donut sits on Paper! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                /*
                 * Scissors if-else
                 */
                else if(opp == scissors && player == rock)
                {
                    System.out.println("Rock smashes Scissors! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == scissors && player == paper)
                {
                    System.out.println("Scissors cuts Paper! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == scissors && player == scissors)
                {
                    System.out.println("Scissors and Scissors. You Tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == scissors && player == unicorn)
                {
                    System.out.println("Unicorn stomps Scissors! You Win! Good Job!\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == scissors && player == donut)
                {
                    System.out.println("Scissors slices Donut! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                /*
                 * Unicorn if-else
                 */
                else if(opp == unicorn && player == rock)
                {
                    System.out.println("Unicorn tramples Rock! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == unicorn && player == paper)
                {
                    System.out.println("Paper blinds Unicorn! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == unicorn && player == scissors)
                {
                    System.out.println("Unicorn stomps Scissors! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == unicorn && player == unicorn)
                {
                    System.out.println("Unicorn and Unicorn. You Tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == unicorn && player == donut)
                {
                    System.out.println("Donut chokes Unicorn. You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                /*
                 * Donut if-else
                 */
                else if(opp == donut && player == rock)
                {
                    System.out.println("Rock smashes Donut! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == donut && player == paper)
                {
                    System.out.println("Donut sits on Paper! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == donut && player == scissors)
                {
                    System.out.println("Scissors slices Donut! You Win! Good Job :)\n");
                    System.out.println("Press Enter.");
                    wins++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == donut && player == unicorn)
                {
                    System.out.println("Donut chokes Unicorn! You Lose. I'm Sorry :(\n");
                    System.out.println("Press Enter.");
                    losses++;
                    imp.nextLine();
                    flag = false;
                }
                else if(opp == donut && player == donut)
                {
                    System.out.println("Donut and Donut. You Tied :/\n");
                    System.out.println("Press Enter.");
                    draws++;
                    imp.nextLine();                
                    flag = false;
                }
                else
                {
                    System.out.println("Invalid Input\n");
                    System.out.println("Enter the number of your selection");
                    System.out.println("1) Rock\n2) Paper\n3) Scissors\n4) Unicorn\n5) Donut");
                    imp.skip("\n");
                    player = imp.nextInt();
                    imp.nextLine();
                }
            }
            loops++;
        }
        //OUT OF LOOP
        System.out.println("You played a total of "+rounds+" round(s).");
        System.out.println("You won "+wins+" round(s).");
        System.out.println("You lost "+losses+" round(s).");
        System.out.println("You tied "+draws+" round(s).");
        System.out.println("Input YES to play again.\n Or NO to return to the main menu.");

        choice = imp.nextLine();
        choice = choice.toLowerCase();

        Boolean flag = true;
        while(flag)
        {
            if(choice.equals(yes))
            {
                rps.displayRPSMenu();
                flag = false;
            }
            else if(choice.equals(no))
            {   
                menu.displayGames();
                flag = false;
            }
            else
            {
                System.out.println("Invalid input.");
                System.out.println("Input YES to play again.\n Or NO to return to the main menu.");
                choice = imp.nextLine();
                choice = choice.toLowerCase();
            }
        }
        imp.close();//banish the imp
    }
}