public class Flashcard {

    private String term;
    private String definition;

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

    public String getTerm(){
        return term;
    }

    public String getDefinition(){
        return definition;
    }

    public String toString(){
        return "Term: " + getTerm() + "\n Definition: " + getDefinition();
    }
}
