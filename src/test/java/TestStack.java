
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
        Flashcard f = new Flashcard("carbon", "6 protons");
        fixture.push(f);
        assertEquals(f, fixture.peek());
    }

    @Test
    public void testPop(){
        Flashcard f = new Flashcard("carbon", "6 protons");
        fixture.push(f);
        assertEquals(f, fixture.peek());
        assertEquals(f, fixture.pop());
    }

    @Test
    public void testPeek(){

    }






}
