import java.util.List;

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
