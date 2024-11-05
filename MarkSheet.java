package marksheet;
import java.util.Scanner;

public class MarkSheet {
    // Attributes
    private String studentName;
    private int totalMarks;
    private int obtainedMarks;
    private double percentage;
    private String grade;
    private double gpa;

    // Constructor to initialize the student information
    public MarkSheet(String studentName, int totalMarks, int obtainedMarks) {
        this.studentName = studentName;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
        calculatePercentage();
        calculateGrade();
        calculateGPA();
    }

    // Method to calculate the percentage
    private void calculatePercentage() {
        this.percentage = ((double) obtainedMarks / totalMarks) * 100;
    }

    // Method to calculate the grade based on percentage
    private void calculateGrade() {
        if (percentage >= 90) {
            this.grade = "A+";
        } else if (percentage >= 80) {
            this.grade = "A";
        } else if (percentage >= 70) {
            this.grade = "B+";
        } else if (percentage >= 60) {
            this.grade = "B";
        } else if (percentage >= 50) {
            this.grade = "C";
        } else if (percentage >= 40) {
            this.grade = "D";
        } else {
            this.grade = "F";
        }
    }

    // Method to calculate the GPA based on grade
    private void calculateGPA() {
        switch (this.grade) {
            case "A+":
                this.gpa = 4.0;
                break;
            case "A":
                this.gpa = 3.7;
                break;
            case "B+":
                this.gpa = 3.3;
                break;
            case "B":
                this.gpa = 3.0;
                break;
            case "C":
                this.gpa = 2.5;
                break;
            case "D":
                this.gpa = 2.0;
                break;
            default:
                this.gpa = 0.0;
                break;
        }
    }

    // Method to display the mark sheet
    public void displayMarkSheet() {
        System.out.println("---------- MARK SHEET ----------");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Total Marks    : " + totalMarks);
        System.out.println("Obtained Marks : " + obtainedMarks);
        System.out.println("Percentage     : " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade          : " + grade);
        System.out.println("GPA            : " + gpa);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input section
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Total Marks: ");
        int total = scanner.nextInt();

        System.out.print("Enter Obtained Marks: ");
        int obtained = scanner.nextInt();

        // Create MarkSheet object and display the mark sheet
        MarkSheet markSheet = new MarkSheet(name, total, obtained);
        markSheet.displayMarkSheet();

        scanner.close();
    }
}
