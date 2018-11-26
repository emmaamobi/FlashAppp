
import java.util.*;

public class CardStack {
    private Stack<Flashcard> stackOCards;
    public CardStack(){
    stackOCards = new Stack<>();
    }

    //LIFO
    
    public void push(Flashcard f){
        // method pushes flashcard to top of stack
        stackOCards.push(f);   
    } 
    
    public Flashcard pop(){
        // method returns flashcard from top of stack and removes it
        return stackOCards.pop();

    }
    
    public Flashcard peek(){
        // method returns flashcard from top of stack but doesn't remove it
        return stackOCards.peek();
    }

    public boolean empty(){
        //returns whether stack is empty
        return stackOCards.empty();
    }
    
    

}
