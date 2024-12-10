import java.util.*;

public class HighLow{
    //utility objects
    Random rand = new Random();
    Scanner imp = new Scanner(System.in);
    //menu object
    Menu menu = new Menu();
    //Arrays for the various decks
    private Card[] heartCards = new Card[14];
    private Card[] clubCards = new Card[14];
    private Card[] diamondCards = new Card[14];
    private Card[] spadeCards = new Card[14];
    private Card[] smallDeck = new Card[14];
    private Card[] deck = new Card[52];
    //integer values
    private int dex = 0; //index value
    //random seeds 
    private int largeFirstCardSeed;
    private int largeSecondCardSeed;
    private int smallFirstCardSeed;
    private int smallSecondCardSeed;
    private int smallDeckSeed;
    //comparison values
    private int firstValue;
    private int secondValue;
    //processing user input
    private String guess;
    private String high = "high";
    private String low = "low";
    private String suits = "suits";
    //these hold the RANK of SUIT string
    private String firstCard;
    private String secondCard;
    //Booleans for comparison processing
    private Boolean secondCardHigher = false;
    private Boolean secondCardLower = false;
    private Boolean equal = false;
    private Boolean flag = true;
    //various ranks and suits objects
    //first are for adding up total card values
    private Ranks firstRank;
    private Ranks secondRank;
    private Suits firstSuit;
    private Suits secondSuit;
    //for building suit decks
    private Suits hearts = Suits.HEARTS;
    private Suits clubs = Suits.CLUBS;
    private Suits diamonds = Suits.DIAMONDS;
    private Suits spades = Suits.SPADES;
    /**
     * class methods
     */

    /**
     * builds 4 single suit,14 card decks
     */
    private void makeSmallDecks(){
        for(Ranks rank : Ranks.values()){//for each rank in Ranks, interate over the constant

            heartCards[dex] = new Card(rank, hearts); //deck of hearts
            clubCards[dex] = new Card(rank, clubs);//deck of clubs
            diamondCards[dex] = new Card(rank, diamonds); //deck of diamonds
            spadeCards[dex] = new Card(rank, spades);//deck of spades
            dex++;
        }
    }
    /**
     * builds a four suit, 52 card deck
     */
    private void makeBigDeck(){
        dex = 0;//reset index value
        for(Suits suit : Suits.values())
            for(Ranks rank : Ranks.values()){
                deck[dex++] = new Card(rank,suit);//full deck
            }
    }
    /**
     * controls logic and deck state for easy mode
     */
    public void easyMode(){
        HighLowMenu hlm = new HighLowMenu();
        makeSmallDecks();
        do{smallFirstCardSeed = rand.nextInt(14);
        smallSecondCardSeed = rand.nextInt(14);
        smallDeckSeed = rand.nextInt(5);
        if(smallDeckSeed == 1){
            smallDeck = heartCards;
        }
        else if(smallDeckSeed == 2){
            smallDeck = clubCards;
        }
        else if(smallDeckSeed == 3){
            smallDeck = diamondCards;
        }
        else if(smallDeckSeed == 4){
            smallDeck = spadeCards;
        }
        firstRank = smallDeck[smallFirstCardSeed].getRank();
        firstSuit = smallDeck[smallFirstCardSeed].getSuit();
        secondRank = smallDeck[smallSecondCardSeed].getRank();
        secondSuit = smallDeck[smallSecondCardSeed].getSuit();
        firstCard = smallDeck[smallFirstCardSeed].toString();
        secondCard = smallDeck[smallSecondCardSeed].toString();
        firstValue = firstRank.getValue() + firstSuit.getValue();
        secondValue = secondRank.getValue() + secondSuit.getValue();
        equal = (firstValue == secondValue); }while(equal);
        System.out.println("The first card is "+firstCard+".");
        System.out.println("Will the next card be HIGH or LOW?");
        System.out.print(">>> ");
        guess = imp.nextLine();
        guess = guess.toLowerCase();
        while(flag){
            if(guess.equals(suits)){
                hlm.displaySuitsHelp();
                System.out.println("\nThe first card is "+firstCard+".");
                System.out.println("Will the next card be HIGH or LOW?");
                System.out.print(">>> ");
                guess = imp.nextLine();
                guess = guess.toLowerCase();
            }
            secondCardLower = firstValue > secondValue;
            secondCardHigher = firstValue < secondValue;
            if(secondCardHigher && guess.equals(high)){
                //second card higher than first card. correct guess
                System.out.println(secondCard+" beats "+firstCard);
                System.out.println("You Win! Nice One!");
                flag = false;
            }
            else if(secondCardLower && guess.equals(high)){
                //second card lower than first card. incorrect guess
                System.out.println(firstCard+" beats "+secondCard);
                System.out.println("You Lose. You'll Get 'Em Next Time.");
                flag = false;
            }
            else if(secondCardHigher && guess.equals(low)){
                //second card higher than first card.incorrect guess
                System.out.println(secondCard+" beats "+firstCard);
                System.out.println("You Lose. You'll Get 'Em Next Time.");
                flag = false;
            }
            else if(secondCardLower && guess.equals(low)){
                //second card lower than first card.correct guess
                System.out.println(firstCard+" beats "+secondCard);
                System.out.println("You Win! Nice One!");
                flag = false;
            }
            else{
                System.out.println("\n...INVALID INPUT...");
                System.out.println("The first card is "+firstCard+".");
                System.out.println("Will the next card be HIGH or LOW?");
                System.out.print(">>> ");
                guess = imp.nextLine();
                guess = guess.toLowerCase();
            }
        }
        hlm.displayHLMenu();
    }
    /**
     * controls the logic and deck state for hard mode
     */
    public void hardMode(){
        HighLowMenu hlm = new HighLowMenu();
        makeBigDeck();
        do{largeFirstCardSeed = rand.nextInt(52);
        largeSecondCardSeed = rand.nextInt(52); 
        firstRank = deck[largeFirstCardSeed].getRank();
        firstSuit = deck[largeFirstCardSeed].getSuit();
        secondRank = deck[largeSecondCardSeed].getRank();
        secondSuit = deck[largeSecondCardSeed].getSuit();
        firstCard = deck[largeFirstCardSeed].toString();
        secondCard = deck[largeSecondCardSeed].toString();
        firstValue = firstRank.getValue() + firstSuit.getValue();
        secondValue = secondRank.getValue() + secondSuit.getValue();
        equal = (firstValue == secondValue); }while(equal);
        System.out.println("The first card is "+firstCard+".");
        System.out.println("Will the next card be HIGH or LOW?");
        System.out.print(">>> ");
        guess = imp.nextLine();
        guess = guess.toLowerCase();

        while(flag){
            if(guess.equals(suits)){
                hlm.displaySuitsHelp();
                System.out.println("\nThe first card is "+firstCard+".");
                System.out.println("Will the next card be HIGH or LOW?");
                System.out.print(">>> ");
                guess = imp.nextLine();
                guess = guess.toLowerCase();
            }
            secondCardLower = firstValue > secondValue;
            secondCardHigher = firstValue < secondValue;
            if(secondCardHigher && guess.equals(high)){
                //second card higer than first card. correct guess
                System.out.println(secondCard+" beats "+firstCard);
                System.out.println("You Win! Nice One!");
                flag = false;
            }
            else if(secondCardLower && guess.equals(high)){
                //second card lower than first card. incorrect guess
                System.out.println(firstCard+" beats "+secondCard);
                System.out.println("You Lose. You'll Get 'Em Next Time.");
                flag = false;
            }
            else if(secondCardHigher && guess.equals(low)){
                //second card higher than first card.incorrect guess
                System.out.println(secondCard+" beats "+firstCard);
                System.out.println("You Lose. You'll Get 'Em Next Time.");
                flag = false;
            }
            else if(secondCardLower && guess.equals(low)){
                //second card lower than first card.correct guess
                System.out.println(firstCard+" beats "+secondCard);
                System.out.println("You Win! Nice One!");
                flag = false;
            }
            else{
                System.out.println("\n...INVALID INPUT...");
                System.out.println("The first card is "+firstCard+".");
                System.out.println("Will the next card be HIGH or LOW?");
                System.out.print(">>> ");
                guess = imp.nextLine();
                guess = guess.toLowerCase();
            }
        }
        hlm.displayHLMenu();
    }
}