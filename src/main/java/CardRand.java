import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class CardRand {
    private ArrayList<Flashcard> arr;
    private HashMap<Flashcard,Integer> myMap;

    public CardRand(){
        arr = new ArrayList<>();
        myMap = new HashMap<>();
    }

    public void add(Flashcard card){
        //if element is there, return
        if (myMap.get(card) != null){
            return;
        }
        // Put element in the array and get the index with size
        int index = arr.size();
        arr.add(card);

        //put it in hash map
        myMap.put(card,index);

    }

    public void remove (Flashcard card){
        //Check if element is present
        Integer index = myMap.get(card);
        if (index == null){
            return;
        }
        if (myMap.size() == 1){
            myMap.remove(card);
            arr.remove(0);
            return;
        }
        //Remove from map
        myMap.remove(card);

        //Swap element with last element.
        int size = arr.size();
        Flashcard last = arr.get(size-1);
        Collections.swap(arr,index,size-1);

        //Remove last element
        arr.remove(size-1);

        //Update hash map for new index of last element
        myMap.put(last,index);
    }

    public Flashcard getRandom(){

        //Find random index
        Random rand = new Random();

        int index = rand.nextInt(arr.size());
        //Return element at index
        return arr.get(index);
    }

    public boolean isArrEmpty(){
        return arr.isEmpty();
    }
    public boolean isMapEmpty() { return myMap.isEmpty();}

    public String toArrString(){
        //prints the arr out to a string
        return arr.toString();
    }

    public String toMapString(){
        return myMap.toString();
    }
}
