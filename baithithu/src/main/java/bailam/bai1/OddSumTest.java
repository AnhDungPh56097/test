package bailam.bai1;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
public class OddSumTest {
    private final OddSumCalculator calculator = new OddSumCalculator();

    @Test
    public void testBoundaryCases() {
        assertEquals(0, calculator.sumOddNumbers(0));
        assertEquals(1, calculator.sumOddNumbers(1));
        assertEquals(1, calculator.sumOddNumbers(2));
    }

    @Test
    public void testEquivalentPartitions() {
        assertEquals(1, calculator.sumOddNumbers(1));
        assertEquals(4, calculator.sumOddNumbers(3));
        assertEquals(9, calculator.sumOddNumbers(5));
        assertEquals(4, calculator.sumOddNumbers(4));
        assertEquals(16, calculator.sumOddNumbers(7));
    }

    @Test
    public void testLargeNumber() {
        int n = 1000;
        int expectedSum = 250000;
        assertEquals(expectedSum, calculator.sumOddNumbers(n));
    }

    @Test
    public void testNegativeInput() {
        assertEquals(0, calculator.sumOddNumbers(-5));
    }
}
