package test;

import main.StudentAnalyzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StudentAnalyzer Tests")
class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // ── countExcellentStudents Tests ───────────────────────────────────────

    @Test
    @DisplayName("countExcellentStudents - empty list")
    void shouldReturnZero_WhenListIsEmpty() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    @DisplayName("countExcellentStudents - all invalid scores")
    void shouldReturnZero_WhenAllScoresAreInvalid() {
        List<Double> scores = Arrays.asList(-5.0, -0.1, 10.1, 11.0, 15.5);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    @DisplayName("countExcellentStudents - boundary values around 8.0 and 10.0")
    void shouldCountCorrectly_AtExcellentBoundaries() {
        List<Double> scores = Arrays.asList(
                7.999999,   // just below 8.0   → NOT excellent
                8.0,        // exactly 8.0      → excellent
                8.000001,   // just above 8.0   → excellent
                9.999999,   // just below 10.0  → excellent
                10.0,       // exactly 10.0     → excellent
                10.000001   // just above 10.0  → NOT excellent
        );
        assertEquals(4, analyzer.countExcellentStudents(scores));
    }

    @Test
    @DisplayName("countExcellentStudents - typical case with mixed values")
    void shouldCountCorrectly_WithMixedScores() {
        List<Double> scores = Arrays.asList(
                5.5, 7.8, 8.0, 8.9, 9.5, 10.0, 10.2, -1.0, 11.5
        );
        assertEquals(4, analyzer.countExcellentStudents(scores));
    }

    // ── calculateValidAverage Tests ────────────────────────────────────────

    @Test
    @DisplayName("calculateValidAverage - empty list")
    void ShouldReturnZeroAverageScore_WhenListIsEmpty() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()));
    }

    @Test
    @DisplayName("calculateValidAverage - all scores invalid")
    void shouldReturnZero_WhenAllScoresInvalid() {
        List<Double> scores = Arrays.asList(-0.0001, -5.0, 10.0001, 11.5);
        assertEquals(0.0, analyzer.calculateValidAverage(scores));
    }

    @Test
    @DisplayName("calculateValidAverage - boundary values around 0 and 10")
    void shouldCalculateCorrectly_AtValidRangeBoundaries() {
        List<Double> scores = Arrays.asList(
                -0.000001,   // invalid
                0.0,         // valid
                0.000001,    // valid
                9.999999,    // valid
                10.0,        // valid
                10.000001    // invalid
        );
        assertEquals(5.00, analyzer.calculateValidAverage(scores));
    }

    @Test
    @DisplayName("calculateValidAverage - typical mixed valid & invalid scores")
    void shouldCalculateCorrectly_WithMixedValidAndInvalidScores() {
        List<Double> scores = Arrays.asList(
                7.5, 8.0, 9.2, -1.0, 10.0, 11.0, 6.8, 9.5
        );
        // valid: 7.5, 8.0, 9.2, 10.0, 6.8, 9.5 → sum = 51.0 → avg = 8.5
        assertEquals(8.50, analyzer.calculateValidAverage(scores));
    }

    @Test
    @DisplayName("calculateValidAverage - rounding behavior check")
    void shouldRoundCorrectly_ToTwoDecimalPlaces() {
        List<Double> scores = Arrays.asList(8.1, 7.9, 9.25);
        // sum = 25.25 → avg = 8.41666... → should be 8.42
        assertEquals(8.42, analyzer.calculateValidAverage(scores));
    }

    @Test
    @DisplayName("calculateValidAverage - single valid score")
    void shouldReturnTheScore_WhenOnlyOneValidScoreExists() {
        assertEquals(7.50, analyzer.calculateValidAverage(Arrays.asList(7.5, -1.0, 11.0)));
    }
}