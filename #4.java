public class AverageCalculator {
    public double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return (double) sum / numbers.length;
    }
}




import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageCalculatorTest {

    private final AverageCalculator calculator = new AverageCalculator();

    @Test
    public void testAverageOfPositiveNumbers() {
        assertEquals(3.0, calculator.calculateAverage(new int[]{1, 2, 3, 4, 5}), 0.0001);
    }

    @Test
    public void testSingleElement() {
        assertEquals(42.0, calculator.calculateAverage(new int[]{42}), 0.0001);
    }

    @Test
    public void testAllZeros() {
        assertEquals(0.0, calculator.calculateAverage(new int[]{0, 0, 0}), 0.0001);
    }
}
