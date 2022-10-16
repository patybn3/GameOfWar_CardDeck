import java.util.Stack;

public class Card<T> extends Stack<Card>
{
    public static final String[] SUITS = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    public static final String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

    private int suit;
    private int face;
}
