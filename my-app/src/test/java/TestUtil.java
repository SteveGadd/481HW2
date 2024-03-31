import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void testCompute_LengthOne() {
    assertFalse(c.compute(1));
}

  @Test
  public void testCompute_LengthEven() {
      assertFalse(c.compute(1, 2, 3, 4));
  }

  @Test(expected = RuntimeException.class)
  public void testCompute_ZeroElement() {
      c.compute(1, 2, 0, 4, 5);
  }


  @Test
  public void testCompute_SumDivisible() {
      assertTrue(c.compute(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 55));
  }
  @Test
  public void testCompute_elementsOdd() {
      assertFalse(c.compute(2, 8, 11));
  }

}