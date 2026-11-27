import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    public void testTypicalGrades() {
        List<Integer> grades = Arrays.asList(70, 80, 90);
        assertEquals(80.0, calculator.calculateAverage(grades), 0.0001);
    }

    @Test
    public void testSingleGrade() {
        assertEquals(55.0, calculator.calculateAverage(Collections.singletonList(55)), 0.0001);
    }

    @Test
    public void testBoundaryValuesZeroAndHundred() {
        List<Integer> grades = Arrays.asList(0, 100);
        assertEquals(50.0, calculator.calculateAverage(grades), 0.0001);
    }

    @Test
    public void testEmptyOrNullList() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(Collections.emptyList()));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(null));
    }

    @Test
    public void testOutOfRangeGrade() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(Arrays.asList(80, -1, 90)));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(Arrays.asList(101)));
    }
}
