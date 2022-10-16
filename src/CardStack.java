import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardStack implements Project1StackInterface<Card>
{
    private Stack<Card> cardsStack;
    List<Card> drawComputer;
    List<Card> drawPlayer2;
    List<Card> discardComputer;
    List<Card> discardPlayer2;
    protected int countOne = 0;
    protected int countTwo = 0;

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
        //cut cards
        drawComputer = cardsStack.subList(26, 51);
        drawPlayer2 = cardsStack.subList(0, 26);
    }

    public void playCards()
    {
        //create two players
        Card player1Card, player2Card;
        int i = 0;

        System.out.println("There are "+ size() + " cards in the deck");
        System.out.println("Deck is being shuffled\n");
        shuffle();
        //6 rounds, even number to allow ties
        while(i < 6)
        {
            //player 1 gets a card
            player1Card = pop();
            System.out.print("Player 1 drew the " + player1Card);
            System.out.println(" - " + size() + " cards left in the deck");
            //player 2 gets a card
            player2Card =  pop();
            System.out.print("Player 2 drew the " + player2Card);
            System.out.println(" - " + size() + " cards left in the deck\n");

            // order suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
            //comparison
            if(player1Card.getSuit() == player2Card.getSuit()) //when the suits of each player are equal, ex. HEARTS $ HEARTS
            {
                //if the face (number) is also equal
                if(player1Card.getFace() == player2Card.getFace())
                {
                    System.out.println("Its a tie!! \n- Player 1 with " + player1Card);
                    System.out.println("- Player 2 with " + player2Card + "\n");
                    //both players get points
                    countOne++;
                    countTwo++;
                }
                else if(player1Card.getFace() > player2Card.getFace()) //if the value of player 1 is greater, Player 1 is the winner
                {
                    System.out.println("Round Winner = PLayer 1 with " + player1Card + "\n");
                    countOne++;
                }
                else
                {   //if player 2 is greater, player 2 is the winner
                    System.out.println("Round Winner = Player 2 with " + player2Card + "\n");
                    countTwo++;
                }

            }
            else if (player1Card.getSuit() > player2Card.getSuit()) //when the value of player 1 suit is greater than player 2
            {
                //player 1 is the winner
                System.out.println("Round Winner = PLayer 1 with " + player1Card + "\n");
                countOne++;
            }
            else
            {
                //if not greater (player 2 is greater), then player two is the winner
                System.out.println("Round Winner = Player 2 with " + player2Card +  "\n");
                countTwo++;
            }
            //loops 6 times
            i++;
        }

        //counting points
        if(countOne == countTwo) //points are equal, its a tir
        {
            System.out.println("Player 1 points: " + countOne + " vs. Player 2 points: " + countTwo);
            System.out.println("\nWe have a tie!!!");
        }
        else if(countOne > countTwo) //player 1 is the winner
        {
            System.out.println("Player 1 points: " + countOne + " vs. Player 2 points: " + countTwo);
            System.out.println("\nWINNER = Player 1");
        }
        else //player 2 is the winner
        {
            System.out.println("Player 1 points: " + countOne + " vs. Player 2 points: " + countTwo);
            System.out.println("\nWINNER = Player 2");
        }
    }
}
