public class Card 
{
    private final Ranks rank;
    private final Suits suit;

    public Card(Ranks rank, Suits suit) //constructor, makes a single card
    {
        this.rank = rank;
        this.suit = suit;
    }
//getters and toString override
    public Suits getSuit()
    {
        return suit;
    }

    public Ranks getRank()
    {
        return rank;
    }

    @Override
    public String toString()
    {
        return rank+" of "+suit;
    }
}
