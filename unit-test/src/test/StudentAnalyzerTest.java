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
    void testCountExcellentStudentsMixedValues() {
        assertEquals(4, analyzer.countExcellentStudents(Arrays.asList(7.5, 8.0, 9.2, 6.8, 10.0, 11.0, -1.0, 8.5)));
    }

    @Test
    void testCoundExcellentStudentsAllScoresInvalid() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-1.0, -5.0, 11.5, 15.0)));
    }

    @Test
    void testCalculateValidAverageAllInvalidScore(){
        assertEquals(0.00, analyzer.calculateValidAverage(Arrays.asList(-1.0, 11.5, -3.0)));
    }
    
    @Test
    void testCountExcellentStudentsEmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    void testCalculateValidAverageMixedValues() {
        assertEquals(8.30, analyzer.calculateValidAverage(Arrays.asList(7.5, 8.0, 9.2, -1.0, 10.0, 11.0, 6.8)));
    }

    @Test
    void testCalculateValidAverageEmptyList() {
        assertEquals(0.00, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test
    void testCalculateValidAverageBoundaryValues() {
        assertEquals(9.00, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0, -0.1, 10.1)));
    }

    @Test
    void testCountExcellentStudentsBoundaryValues(){
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(8.0, 10.0, 7.9, 10.1)));
    }
}
