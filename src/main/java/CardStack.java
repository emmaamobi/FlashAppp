
import java.util.*;

public class CardStack {

    /**Stack object that utilizes a Last-In-First-Out (LIFO)
     * principle. This class is utilized specifically for
     * a LIFO based mode where the user is quizzed on the Flashcards
     * based on the reversed order the user entered the data.
     *
     * The object utilizes a stack for this implementation.
     *
     * This stack object handles Flashcard objects.
     */

    private Stack<Flashcard> stackOCards;

    /** Constructor that creates the stack structure.**/
    public CardStack(){
    stackOCards = new Stack<>();
    }

    /**Adds the Flashcard object to the top of the stack.**/
    public void push(Flashcard f){
        stackOCards.push(f);   
    }

    /**Returns the Flashcard at the top of the stack and removes it.**/
    public Flashcard pop(){
        return stackOCards.pop();
    }

    /**Returns the Flashcard at the top of the stack but does not removes it.**/
    public Flashcard peek(){
        return stackOCards.peek();
    }

    /**Returns true if the stack is empty.
     * Returns false if the stack is not empty.**/
    public boolean empty(){
        return stackOCards.empty();
    }
    
    

}
