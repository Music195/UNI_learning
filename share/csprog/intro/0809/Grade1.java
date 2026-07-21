import java.util.Scanner;

public class Grade1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your marks:");
        int marks = sc.nextInt();
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks entered. Please enter a value between 0 and 100.");
            return;
        }else if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 80) {
            System.out.println("Grade: B");
        } else if (marks >= 70) {
            System.out.println("Grade: C");
        } else if (marks >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}