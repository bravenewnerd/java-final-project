public enum Suits 
{ //enum for card suits
    HEARTS(1),
    CLUBS(2),
    DIAMONDS(3),
    SPADES(4);

    private final int value;
//constructor and getter for suit values
    private Suits(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
