import java.util.Collections;
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
    public Card pop()
    {
        if(isEmpty())
        {
            throw new StackUnderflowException("There are no cards to draw.");
        }
        else {
            return cardsStack.pop();
        }
    }

    @Override
    public Card top()
    {
        if(isEmpty())
        {
            throw new StackUnderflowException("There are no cards in the deck.");
        }
        else {
            return cardsStack.peek();
        }
    }

    @Override
    public Card popTop() {
        top();
        return pop();
    }

    @Override
    public int size() {
        return cardsStack.size();
    }

    @Override
    public void clear() {
        cardsStack = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return cardsStack.isEmpty();
    }

    public boolean isFull()
    // Returns false - a linked stack is never full
    {
        return !cardsStack.isEmpty();
    }

    public void shuffle()
    {
        //we are looping through the cards in the deck
        Collections.shuffle(cardsStack);
    }
}
