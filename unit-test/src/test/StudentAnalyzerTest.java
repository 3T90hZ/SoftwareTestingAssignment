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
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(7.5, 8.0, 9.2, 6.8, 10.0, 11.0, -1.0, 8.5)));
        assertEquals(8, analyzer.countExcellentStudents(Arrays.asList(7.5, 8.0, 9.2, 6.8, 10.0, 0.0, 1.0, 8.5)));
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        assertEquals(0, analyzer.calculateValidAverage(Arrays.asList(-1.0, 11.0, -0.5, null)));
    }

    @Test
    void testCalculateValidAverage() {
        assertEquals(8.3, analyzer.calculateValidAverage(Arrays.asList(7.5, 8.0, 9.2, -1.0, 10.0, 11.0, 6.8)));
        assertEquals(6.7, analyzer.calculateValidAverage(Arrays.asList(7.5, 8.0, 9.2, 0.0, 10.0, 5.5, 6.8)));
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()));
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-1.0, 11.0, -0.5, null)));
    }
}