import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;
  MessageQueue mq;
    
  @Test
    public void testIsEmpty() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        when(mq.size()).thenReturn(0);
        assertEquals(-1, c.countNumberOfOccurrences("test"));
    }

    @Test
    public void testElementNotPresent() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        when(mq.size()).thenReturn(3);
        when(mq.contains("test")).thenReturn(false);
        assertEquals(0, c.countNumberOfOccurrences("test"));
    }

    @Test
    public void testElementPresentOnce() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        when(mq.size()).thenReturn(3);
        when(mq.contains("test")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("test");
        when(mq.getAt(1)).thenReturn("other");
        when(mq.getAt(2)).thenReturn("another");
        assertEquals(1, c.countNumberOfOccurrences("test"));
    }

    @Test
    public void testElementPresentMultipleTimes() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        when(mq.size()).thenReturn(5);
        when(mq.contains("test")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("test");
        when(mq.getAt(1)).thenReturn("other");
        when(mq.getAt(2)).thenReturn("test");
        when(mq.getAt(3)).thenReturn("another");
        when(mq.getAt(4)).thenReturn("test");
        assertEquals(3, c.countNumberOfOccurrences("test"));
    }
}