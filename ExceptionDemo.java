import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {

    // Method that throws custom exception
    static void checkAge(int age) throws CustomAgeException {
        if (age < 18) {
            // Manually throwing custom exception
            throw new CustomAgeException("Age must be 18 or above.");
        }
        System.out.println("Access granted. Age is valid.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // 1️⃣ Runtime Exception (ArithmeticException)
            System.out.print("Enter a number: ");
            int number = sc.nextInt();
            int result = 10 / number;   // may cause divide by zero
            System.out.println("Result: " + result);

            // 2️⃣ Custom Exception
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            checkAge(age);

            // 3️⃣ Checked Exception (IOException)
            File file = new File("test.txt");
            FileReader fr = new FileReader(file); // file may not exist

        }
        catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
            e.printStackTrace(); // logging
        }
        catch (CustomAgeException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("File Error: File not found.");
            e.printStackTrace(); // logging
        }
        catch (Exception e) {
            // Generic exception handler
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
        finally {
            // 4️⃣ Cleanup code
            sc.close();
            System.out.println("Program ended. Resources closed.");
        }
    }
}
