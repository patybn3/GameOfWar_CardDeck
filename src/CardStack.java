import java.util.Stack;

public class CardStack implements Project1StackInterface<Card>
{
    private Stack<Card> cardsStack;

    public CardStack()
    {
        this.cardsStack = new Stack<>();
        insertAllCard();;
    }

    public void insertAllCard()
    {
        if(isFull())
        {
            throw new StackOverflowException("This Deck is Full.");
        }
        else {
            for (int i = 0; i < 13; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    push(j, i);
                }
            }
        }
    }

    @Override
    public void push(int suit, int face)
    {
        cardsStack.add(new Card(suit, face));
    }

    @Override
    public Card pop() {
        return null;
    }

    @Override
    public Card top() {
        return null;
    }

    @Override
    public Card popTop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public boolean isFull()
    // Returns false - a linked stack is never full
    {
        return !cardsStack.isEmpty();
    }
}
