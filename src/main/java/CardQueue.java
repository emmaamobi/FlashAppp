
import java.util.*;

public class CardQueue {

    /**Queue object that utilizes a First-In-First-Out (FIFO)
     * principle. This class is utilized specifically for
     * a FIFO based mode where the user is quizzed on the Flashcards
     * based on the order they entered the data.
     *
     * The object utilizes a linked list for this implementation.
     *
     * This Queue object handles Flashcard objects.
     */

    /** Constructor that creates the Queue structure.**/
    private Queue<Flashcard> queueCard;
    public CardQueue(){
        queueCard = new LinkedList<>();
    }

    /** Adds the card to the end of the queue.**/
    public void offer(Flashcard card){
        queueCard.add(card);
    }

    /** Returns the card at the front of the queue.
     * This does NOT remove the card.**/
    public Flashcard peek(){
        return queueCard.peek();
    }

    /** Returns the card at the front of the queue and removes it.**/
    public Flashcard poll(){
        return queueCard.poll();
    }

    /** Returns true if the queue is empty, false if it is not empty.**/
    public boolean empty(){
        return queueCard.isEmpty();
    }


}
