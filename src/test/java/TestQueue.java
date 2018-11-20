

import org.junit.*;
import static org.junit.Assert.*;


public class TestQueue {

    CardQueue fixture;

    @Before
    public void setUp(){
        fixture = new CardQueue();
    }

    @After
    public void tearDown(){
        fixture = null;
    }

    @Test
    public void testInitial(){
        //tests the queue functions before loading queue
        assertTrue(fixture.empty());
        assertNull(fixture.peek());
        assertNull(fixture.poll());
    }

    @Test
    public void testEmpty(){
        //tests empty method in CardQueue
        assertTrue(fixture.empty());
        Flashcard test = new Flashcard("Paris", "France");
        fixture.offer(test);
        assertFalse(fixture.empty());
        fixture.poll();
        assertTrue(fixture.empty());
    }

    @Test
    public void testPeek(){
        //tests peek method in CardQueue
        Flashcard test = new Flashcard("Paris", "France");
        Flashcard test1 = new Flashcard("London", "England");
        fixture.offer(test);
        assertEquals(test, fixture.peek());
        fixture.offer(test1);
        assertEquals(test, fixture.peek());
        assertEquals(test, fixture.poll());
        assertEquals(test1, fixture.peek());
    }

    @Test
    public void testOffer(){
        //tests offer method in CardQueue
        Flashcard test = new Flashcard("Amsterdam", "Netherlands");
        Flashcard test1 = new Flashcard("Reykjavik", "Iceland");
        fixture.offer(test);
        assertEquals(test, fixture.peek());
        fixture.offer(test1);
        assertEquals(test, fixture.peek());
        fixture.poll();
        assertEquals(test1, fixture.peek());

    }

    @Test
    public void testPoll(){
        //tests poll method in CardQueue
        Flashcard test = new Flashcard("Tokyo", "Japan");
        Flashcard test1 = new Flashcard("Rome", "Italy");
        fixture.offer(test);
        fixture.offer(test1);
        assertEquals(test, fixture.poll());
        assertEquals(test1, fixture.poll());
    }
}
