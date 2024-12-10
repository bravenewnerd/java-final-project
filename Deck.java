public class Deck 
{
    private static Card[] cards52 = new Card[52]; // create an array of Card objects

    public Deck() //constructor, creates a Deck object
    {
        int dex = 0; //index value
        for(Suits suit : Suits.values())//for each suit in Suits, return the constant 
            for(Ranks rank: Ranks.values())//for each rank in Ranks, return the constant
                {
                    cards52[dex++]= new Card(rank,suit); //each new card receives the rank and suit argument
                }
    }
}
