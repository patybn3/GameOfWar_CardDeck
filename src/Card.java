import java.util.Stack;

public class Card<T> extends Stack<Card>
{
    public static final String[] SUITS = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    public static final String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

    private int suit;
    private int face;

    public Card(T suit, T face)
    {
        this.suit = (int) suit;
        this.face = (int) face;
    }

    public int getSuit()
    {
        return suit;
    }

    //I fail to understand why sets are needed, but here they are as required by the interface
    public void setSuit(int suit)
    {
        this.suit = suit;
    }

    public int getFace()
    {
        return face;
    }

    public void setFace(int face)
    {
        this.face = face;
    }

    public String toString()
    {
        //the value is passed to the array so we can print the actual value stored in the index and not the index itself
        return "Card = " + FACES[face] + " of " + SUITS[suit];
    }
}
