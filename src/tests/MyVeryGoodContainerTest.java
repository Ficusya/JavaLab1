package tests;

import main.MyVeryGoodContainer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class MyVeryGoodContainerTest {
    private MyVeryGoodContainer container;

    @Before
    public void setUp() {
        container = new MyVeryGoodContainer();
    }

    @Test
    public void testAddToHead() {
        container.addToHead(1);
        assertEquals(1, container.extractFirst());
    }

    @Test
    public void testAddToTail() {
        container.addToTail(1);
        assertEquals(1, container.extractLast());
    }

    @Test
    public void testAddToIndex() {
        container.addToHead(1);
        container.addToIndex(1, 2);
        assertEquals(2, container.extractAtIndex(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddToIndexException() {
        container.addToIndex(1, 2);
    }

    @Test
    public void testDeleteFirst() {
        container.addToHead(1);
        container.deleteFirst();
        assertEquals(0, container.getSize());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteFirstException() {
        container.deleteFirst();
    }

    @Test
    public void testDeleteLast() {
        container.addToTail(1);
        container.deleteLast();
        assertEquals(0, container.getSize());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteLastException() {
        container.deleteLast();
    }

    @Test
    public void testDeleteAtIndex() {
        container.addToHead(1);
        container.addToTail(2);
        container.deleteAtIndex(1);
        assertEquals(1, container.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexException() {
        container.deleteAtIndex(0);
    }

    @Test
    public void testExtractFirst() {
        container.addToHead(1);
        container.addToTail(2);
        assertEquals( 1, container.extractFirst());
        assertEquals(1, container.getSize());
    }

    @Test
    public void testExtractLast() {
        container.addToHead(1);
        container.addToTail(2);
        assertEquals(2, container.extractLast());
        assertEquals(1, container.getSize());
    }

    @Test
    public void testExtractAtIndex() {
        container.addToHead(1);
        container.addToTail(2);
        container.addToTail(3);
        assertEquals(2, container.extractAtIndex(1));
        assertEquals(2, container.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExtractAtIndexException() {
        container.extractAtIndex(0);
    }
}