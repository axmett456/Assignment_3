import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println(" exam registration  ");

            System.out.print("Enter student ID: ");
            String studentId = input.nextLine();
            if (studentId.isEmpty()) {
                throw new InvalidRegistrationException("Student ID cannot be empty.");
            }

            System.out.print("Enter student name: ");
            String studentName = input.nextLine();
            if (studentName.isEmpty()) {
                throw new InvalidRegistrationException("Student name cannot be empty.");
            }

            System.out.print("Enter age: ");
            int age = input.nextInt();
            if (age < 18) {
                throw new InvalidRegistrationException("Student must be at least 18 years old.");
            }

            System.out.print("Enter exam mark (0-100): ");
            double mark = input.nextDouble();
            if (mark < 0 || mark > 100) {
                throw new InvalidRegistrationException("Mark must be between 0 and 100.");
            }

            System.out.print("Enter number of subjects (1-5): ");
            int subjects = input.nextInt();
            if (subjects < 1 || subjects > 5) {
                throw new InvalidRegistrationException("Choose between 1 and 5 subjects.");
            }

            System.out.println("Registration successful!");
            System.out.println("Student ID: " + studentId);
            System.out.println("Student name: " + studentName);
            System.out.println("Student age: " + age);
            System.out.println("Exam mark: " + mark);
            System.out.println("Subjects: " + subjects);

        } catch (InputMismatchException e) {
            System.out.println("\nRegistration failed. Enter numbers for age, mark, and subjects.");
        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration failed: " + e.getMessage());
        } finally {
            System.out.println("Registration attempt completed.");
         }
    }
}

class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}
