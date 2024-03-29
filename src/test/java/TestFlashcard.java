
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlashcard {

    Flashcard makeFixture(String term, String defintion){
        return new Flashcard(term, defintion);
    }

    @Test
    public void testValidTerm(){
        try {
            makeFixture(null, "no term");
            fail("should have thrown IllegalArgumentException");
        } catch (final Throwable ex) {

        }
    }

    @Test
    public void testValidDefinition(){
        try {
            makeFixture("no definition", null);
            fail("should have thrown IllegalArgumentException");
        } catch (final Throwable ex) {

        }
    }

    @Test
    public void testGetTerm(){
        Flashcard test = makeFixture("cow", "ushi");
        assertEquals("cow", test.getTerm());

        Flashcard abc = makeFixture("cat", "mammal");
        assertEquals("cat", abc.getTerm());
    }
    @Test
    public void testSetTerm(){
        Flashcard test = makeFixture("cow", "ushi");
        assertEquals("cow", test.getTerm());
        test.setTerm("vaca");
        assertEquals("vaca", test.getTerm());

        Flashcard abc = makeFixture("cat", "mammal");
        assertEquals("cat", abc.getTerm());
        abc.setTerm("dog");
        assertEquals("dog", abc.getTerm());
    }

    @Test
    public void testGetDefinition(){
        Flashcard test = makeFixture("cow", "ushi");
        assertEquals("ushi", test.getDefinition());

        Flashcard a = makeFixture("French", "a language originating from France");
        assertEquals("a language originating from France", a.getDefinition());
    }

    @Test
    public void testSetDefinition(){
        Flashcard test = makeFixture("cow", "ushi");
        assertEquals("ushi", test.getDefinition());
        test.setDef("vaca");
        assertEquals("vaca", test.getDefinition());

        Flashcard a = makeFixture("French", "a language originating from France");
        assertEquals("a language originating from France", a.getDefinition());
        a.setDef("a type of food");
        assertEquals("a type of food", a.getDefinition());
    }


}
