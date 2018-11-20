import java.util.*;

public class CardStack {
    public Stack<Flashcard> stackOCards = new Stack<>();
    
    public void push(Flashcard f)// method pushes flashcard to top of stack
    {
        stackOCards.push(f);   
    } 
    
    public Flashcard pop(){ // method returns flashcard from top of stack and removes it
        return stackOCards.pop();

    }
    
    public Flashcard peek(){ // method returns flashcard from top of stack but doesn't remove itcd
        return stackOCards.peek();
    }

    public boolean empty(){ //returns whether stack is empty
        return stackOCards.empty();
    }
    
    
    
}
