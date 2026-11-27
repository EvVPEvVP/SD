import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculator {
    public double calculateAverage(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Список оценок не должен быть null или пустым");
        }
        long sum = 0;
        for (Integer grade : grades) {
            if (grade == null) {
                throw new IllegalArgumentException("Оценка не должна быть null");
            }
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Оценка должна быть в диапазоне 0..100");
            }
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}

class GradeCalculatorTest {
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
