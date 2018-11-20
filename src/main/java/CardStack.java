import java.util.Stack;

public class CardStack {
    private Stack<Flashcard> aStack;


    public void push(Flashcard f){
        aStack.push(f);
    }
    public Flashcard pop(){
        return aStack.pop();
    }
    public Flashcard peek(){
        return aStack.peek();
    }

}
