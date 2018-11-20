
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TestStack {

    private CardStack fixture;

    @Before
    public void setUp(){
        fixture = new CardStack();
    }

    @After
    public void tearDown(){
        fixture = null;
    }

    @Test
    public void testPush(){
        //tests push method
        Flashcard test1 = new Flashcard("carbon", "6 protons");
        Flashcard test2 = new Flashcard("oxygen", "8 protons");
        Flashcard test3 = new Flashcard("nitrogen", "7 protons");
        fixture.push(test1);
        assertEquals(test1, fixture.peek());
        fixture.push(test2);
        assertEquals(test2, fixture.peek());
        fixture.push(test3);
        assertEquals(test3, fixture.peek());

    }

    @Test
    public void testPop(){
        Flashcard test1 = new Flashcard("carbon", "6 protons");
        Flashcard test2 = new Flashcard("oxygen", "8 protons");
        Flashcard test3 = new Flashcard("nitrogen", "7 protons");
        fixture.push(test1);
        fixture.push(test2);
        fixture.push(test3);
        assertEquals(test3, fixture.pop());
        assertEquals(test2, fixture.pop());
        assertEquals(test1, fixture.pop());
        assertTrue(fixture.empty());
    }

    @Test
    public void testPeek(){
        Flashcard test1 = new Flashcard("carbon", "6 protons");
        Flashcard test2 = new Flashcard("oxygen", "8 protons");
        Flashcard test3 = new Flashcard("nitrogen", "7 protons");
        fixture.push(test1);
        assertEquals(test1, fixture.peek());
        fixture.push(test2);
        assertEquals(test2, fixture.peek());
        fixture.push(test3);
        assertEquals(test3, fixture.peek());
        fixture.pop();
        assertEquals(test2, fixture.peek());

    }






}
