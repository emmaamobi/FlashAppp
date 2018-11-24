
import java.util.*;

public class CardQueue {
    private Queue<Flashcard> queueCard;
    public CardQueue(){
        queueCard = new LinkedList<>();
    }
    //FIFO

    public void offer(Flashcard card){
        //adds card to end of queue
        queueCard.add(card);
    }

    public Flashcard peek(){
        //returns card at front of queue w/o removing
        return queueCard.peek();
    }

    public Flashcard poll(){
        //returns card at front of queue and removes
        return queueCard.poll();
    }

    public boolean empty(){
        //returns if queue is empty
        return queueCard.isEmpty();
    }

}
