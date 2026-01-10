package main;

import java.util.List;

public class StudentAnalyzer
{

    public int countExcellentStudents(List<Double> scores) {
        if(scores.isEmpty()) {
            return 0;
        }
        int excellentStudentCount = 0;
        for(Double score : scores) {
            if(score >= 8.0 && score <= 10.0) {
                excellentStudentCount += 1;
            }
        }
        return excellentStudentCount;
    }
}
