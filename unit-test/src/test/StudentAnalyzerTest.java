package test;

import main.StudentAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    @Test
    void testCountExcellentStudents() {
        assertEquals(4, analyzer.countExcellentStudents(Arrays.asList(7.5, 8.0, 9.2, 6.8, 10.0, 11.0, -1.0, 8.5)));
        assertEquals(4, analyzer.countExcellentStudents(Arrays.asList(7.5, 8.0, 9.2, 6.8, 10.0, 0.0, 1.0, 8.5)));
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-1.0, 11.0, -0.5, 20.0)));
    }

    @Test
    void testCalculateValidAverage() {
        assertEquals(8.30, analyzer.calculateValidAverage(Arrays.asList(7.5, 8.0, 9.2, -1.0, 10.0, 11.0, 6.8)));
        assertEquals(6.71, analyzer.calculateValidAverage(Arrays.asList(7.5, 8.0, 9.2, 0.0, 10.0, 5.5, 6.8)));
        assertEquals(0.00, analyzer.calculateValidAverage(Collections.emptyList()));
        assertEquals(0.00, analyzer.calculateValidAverage(Arrays.asList(-1.0, 11.0, -0.5, 20.0)));
    }
}