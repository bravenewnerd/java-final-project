import java.util.*;

public class HighLowMenu extends Menu{
    Scanner imp = new Scanner(System.in);
    HighLow hl = new HighLow();

    private String choice;
    private String easy = "easy";
    //private String normal = "normal";
    private String hard = "hard";
    private String help = "help";
    private String back = "back";
    private String suits = "suits";

    private Boolean flag = false;

    public void displayHLMenu(){
        System.out.println("\nThis is High Card, Low Card!");
        System.out.println("Would you like to play: ");
        System.out.println("EASY\nHARD");
        System.out.println("get HELP for the game");
        System.out.println("or go BACK to the main menu");
        System.out.print(">>> ");
        choice = imp.nextLine();
        choice = choice.toLowerCase();
        flag = true;
        while(flag){
            if(choice.equals(easy)){
                hl.easyMode();
                flag = false;
            }
            //else if(choice.equals(normal)){
                //hl.normalMode();
                //flag = false;
            //}
            else if(choice.equals(hard)){
                hl.hardMode();
                flag = false;
            }
            else if(choice.equals(help) || choice.equals(suits)){
                displayHelpHL();
                flag = false;
            }
            else if(choice.equals(back)){
                displayGames();
                flag = false;
            }
            else{
                System.out.println("Invalid Input.");
                System.out.println("This is High Card, Low Card!");
                System.out.println("Would you like to play: ");
                System.out.println("EASY\nHARD");
                System.out.println("get HELP for the game");
                System.out.println("or go BACK to the main menu");
                System.out.print(">>> ");
                choice = imp.nextLine();
                choice = choice.toLowerCase();
            }
        }
    } 

    private void displayHelpHL(){
        System.out.println("Two cards are drawn");
        System.out.println("You will have to guess if the first card");
        System.out.println("is higher or lower than the second card.");
        System.out.println("In Easy Mode there is only one suit and 14 cards.");
        //System.out.println("In Normal mode, there are two suits and 28 cards.");
        System.out.println("In Hard Mode there are four suits and 52 cards.");
        displaySuitsHelp();
    }

    public void displaySuitsHelp(){
        System.out.println("\nSpades are trump suit");
        System.out.println("Diamonds are second highest");
        System.out.println("Clubs beat Hearts");
        System.out.println("Hearts are the lowest suit");
        System.out.println("Spades > Diamonds > Clubs > Hearts");
        System.out.println("\nType SUITS at any time to see this again.");
        System.out.println("Hit enter to get started");
        imp.next();
    }
}