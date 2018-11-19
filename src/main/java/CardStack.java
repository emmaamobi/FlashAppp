import java.util.*;

public class CardStack {
    private Stack<Flashcard> stackOCards;
    
    private void push(Flashcard f)// method pushes flashcard to top of stack
    {
        stackOCards.push(f);   
    } 
    
    private Flashcard pop(){ // method returns flashcard from top of stack and removes it
        return stackOCards.pop();

    }
    
    private Flashcard peek(){ // method returns flashcard from top of stack but doesn't remove itcd 
        return stackOCards.peek();
    }
    
    
    
    
}
