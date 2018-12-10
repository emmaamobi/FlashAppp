import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class CardRand {

    /**This class handles the Random Game mode.
     * It will randomly select one of the Flashcards to be
     * displayed and tested on.
     *
     *
     * This class utilizes an ArrayList and a HashMap.
     */

    private ArrayList<Flashcard> arr;
    private HashMap<Flashcard,Integer> myMap;

    /**Constructor that initializes the ArrayList and HashMap **/
    public CardRand(){
        arr = new ArrayList<>();
        myMap = new HashMap<>();
    }

    /**Adds the Flashcard object to the ArrayList
     * and to the HashMap. The HashMap keeps track
     * of the index that the Flashcard is stored at in
     * the ArrayList.**/
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

    /**Removes the Flashcard from the HashMap and ArrayList.
     * Also adjusts the index stored in the HashMap after
     * the removal from the ArrayList. **/
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

    /**Selects and returns a random Flashcard object
     * from the ArrayList. **/
    public Flashcard getRandom(){

        //Find random index
        Random rand = new Random();

        int index = rand.nextInt(arr.size());
        //Return element at index
        return arr.get(index);
    }

    /**Returns true if the ArrayList is empty.
     * Returns false if the ArrayList is not empty. **/
    public boolean isArrEmpty(){
        return arr.isEmpty();
    }

    /**Returns true if the HashMap is empty.
     * Returns false if the HashMap is not empty. **/
    public boolean isMapEmpty() { return myMap.isEmpty();}

    /**Returns a string that contains the contents of the ArrayList. **/
    public String toArrString(){
        //prints the arr out to a string
        return arr.toString();
    }

    /**Returns a string that contains the contents of the HashMap. **/
    public String toMapString(){
        return myMap.toString();
    }
}
