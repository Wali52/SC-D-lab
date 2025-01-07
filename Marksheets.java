package marksheets;
import java.util.Scanner;

public class Marksheets {
    private final String name;
    private final double totalMarks;
    private final double obtainedMarks;

    // Constructor
    public Marksheets(String name, double totalMarks, double obtainedMarks) {
        this.name = name;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
    }

    // Calculate percentage
    public double calculatePercentage() {
        return (obtainedMarks / totalMarks) * 100;
    }

    // Calculate grade
    public String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else {
            return "F";
        }
    }

    // Calculate GPA
    public double calculateGPA(String grade) {
        return switch (grade) {
            case "A+" -> 4.0;
            case "A" -> 3.7;
            case "B" -> 3.0;
            case "C" -> 2.0;
            default -> 0.0;
        };
    }

    // Display results
    public void displayResults() {
        double percentage = calculatePercentage();
        String grade = calculateGrade(percentage);
        double gpa = calculateGPA(grade);

        System.out.println("Student Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Obtained Marks: " + obtainedMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) {
        // Taking inputs
        try (Scanner scanner = new Scanner(System.in)) {
            // Taking inputs
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter total marks: ");
            double totalMarks = scanner.nextDouble();
            
            System.out.print("Enter obtained marks: ");
            double obtainedMarks = scanner.nextDouble();
            
            // Creating an object and displaying results
            Marksheets marksheet = new Marksheets(name, totalMarks, obtainedMarks);
            marksheet.displayResults();
        }
    }
}
