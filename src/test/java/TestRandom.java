import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestRandom {

        CardRand fixture;

        @Before
        public void setUp(){
            fixture = new CardRand();
        }

        @After
        public void tearDown(){
            fixture = null;
        }

        @Test
        public void testInitial(){
            //tests isEmpty method and to make sure nothing is preloaded
            assertTrue(fixture.isEmpty());
        }

        @Test
        public void testEmpty(){
            //tests isEmpty method in CardRand
            assertTrue(fixture.isEmpty());
            Flashcard test = new Flashcard("Paris", "France");
            fixture.add(test);
            assertFalse(fixture.isEmpty());
            fixture.remove(test);
            assertTrue(fixture.isEmpty());
        }

        @Test
        public void testAdd(){
            //tests add method in CardRand
            Flashcard test = new Flashcard("Paris", "France");
            Flashcard test1 = new Flashcard("London", "England");
            ArrayList<Flashcard> example = new ArrayList<>();
            HashMap<Flashcard, Integer> map = new HashMap<>();
            example.add(test);
            map.put(test, 0);
            fixture.add(test);
            assertEquals(map.toString(), fixture.toMapString());
            assertEquals(example.toString(), fixture.toArrString());
            example.add(test1);
            fixture.add(test1);
            map.put(test1, 1);
            assertEquals(example.toString(), fixture.toArrString());
            assertEquals(map.toString(), fixture.toMapString());
        }

        @Test
        public void testRemove(){
            //tests remove method in CardRand
            Flashcard test = new Flashcard("Amsterdam", "Netherlands");
            Flashcard test1 = new Flashcard("Reykjavik", "Iceland");
            ArrayList<Flashcard> example = new ArrayList<>();
            HashMap<Flashcard, Integer> map = new HashMap<>();
            example.add(test);
            map.put(test, 0);
            fixture.add(test);
            assertEquals(map.toString(), fixture.toMapString());
            example.add(test1);
            fixture.add(test1);
            map.put(test1, 1);
            assertEquals(map.toString(), fixture.toMapString());
            assertEquals(example.toString(), fixture.toArrString());


            fixture.remove(test);
            example.remove(test);
            map.remove(test);
            map.put(test1, 0);
            assertEquals(example.toString(), fixture.toArrString());
            assertEquals(map.toString(), fixture.toMapString());
            fixture.remove(test1);
            example.remove(test1);
            map.remove(test1);
            assertEquals(example.toString(), fixture.toArrString());
            assertEquals(map.toString(), fixture.toMapString());
            assertTrue(fixture.isEmpty());

        }
}
