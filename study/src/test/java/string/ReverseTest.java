package string;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {
    @Test
    public void testTo() {
        assertEquals("cba", Reverse.to("abc", 0, 2));
        assertEquals("acb", Reverse.to("abc", 1, 2));
        assertNull(Reverse.to("", 1, 2));
        assertNull(Reverse.to(null, 1, 2));
    }

    @Test
    public void testToJoinHandle() {
        assertEquals("cba", Reverse.toJoinHandle("abc", 0, 3));
        assertEquals("acb", Reverse.toJoinHandle("abc", 1, 2));
        assertEquals("acbdefghijk", Reverse.toJoinHandle("abcdefghijk", 1, 2));
        assertNull(Reverse.toJoinHandle("", 1, 2));
        assertNull(Reverse.toJoinHandle(null, 1, 2));
    }

    @Test
    public void testToBuilderHandle() {
        assertEquals("cba", Reverse.toBuilderHandle("abc", 0, 3));
        assertEquals("acb", Reverse.toBuilderHandle("abc", 1, 2));
        assertEquals("acbdefghijk", Reverse.toBuilderHandle("abcdefghijk", 1, 2));
        assertNull(Reverse.toBuilderHandle("", 1, 2));
        assertNull(Reverse.toBuilderHandle(null, 1, 2));
    }
}