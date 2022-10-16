public interface Project1StackInterface<T>
{
    void push(int suit, int face); //adds and element to the stack

    T pop(); //removes the top element of the stack, no return

    T top(); //returns the top element of the stack

    T popTop(); //does a top then a pop

    int size(); //returns the number of elements in the stack

    void clear(); //empties the stack

    boolean isEmpty(); //returns true if the stack is empty
}
