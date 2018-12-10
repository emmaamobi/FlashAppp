public class Flashcard {

    /**Flashcard object that contains
     * the term and definition that
     * the user enters.
     *
     *
     * This object utilizes strings!
     */

    private String term;
    private String definition;

    /** Constructor that initializes the creation of
     * a Flashcard with the term and definition
     * entered by the user.
     *
     * Throws an error if the user attempts to enter
     * null data.
     */
    public Flashcard(String term, String definition){
        if (term == null){
            throw new IllegalArgumentException("term is null");
        }
        if (definition == null){
            throw new IllegalArgumentException("definition is null");
        }
        this.term = term;
        this.definition = definition;
    }

    /**Returns the flashcard's term **/
    public String getTerm(){
        return term;
    }

    /**Returns the flashcard's definition **/
    public String getDefinition(){
        return definition;
    }

    /**Returns the flashcard as a string **/
    public String toString(){
        return "Term: " + getTerm() + "\n Definition: " + getDefinition();
    }

    /**Changes the term using a new term passed
     * in through parameters. **/
    public void setTerm(String newTerm){
        term = newTerm;
    }

    /**Changes the definition using a new term passed
     * in through parameters. **/
    public void setDef(String newDef){
        definition = newDef;
    }
}
