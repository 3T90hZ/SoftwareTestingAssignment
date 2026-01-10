package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public double calculateValidAverage(List<Double> scores) {
        if(scores.isEmpty()) {
            return 0.0;
        }
        int validScoreCount = 0;
        double sum = 0.0;
        for(Double score : scores) {
            if(score >=0.0 && score <= 10.0) {
                validScoreCount += 1;
                sum += score;
            }
        }
        if(validScoreCount == 0) {
            return 0.0;
        }
        return sum/validScoreCount;
    }
    public static void  main(String[] args)
    {
        StudentAnalyzer studentAnalyzer = new StudentAnalyzer();
        List<Double> scores = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập điểm(vd: 10 7 4 9): ");
        String input = scan.nextLine();
        String[] a = input.split(" ");
        for(int i = 0; i < a.length; i++) {
            scores.add(Double.parseDouble(a[i]));
        }
        System.out.println("Số học sinh đạt loại giỏi:");
        System.out.println(studentAnalyzer.countExcellentStudents(scores));
        System.out.println("Điểm trung bình:");
        System.out.println(studentAnalyzer.calculateValidAverage(scores));
    }
}
