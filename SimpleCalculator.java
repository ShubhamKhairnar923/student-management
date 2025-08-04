// package Intership;

import java.util.Scanner;

// import basics.Continues;

public class SimpleCalculator {
	
	public static double add(double a , double b) {
		return a + b;
	}
	
	public static double sub(double a , double b) {
		return a - b;
	}
	
	public static double mul(double a , double b) {
		return a * b;
	}
	
	public static double div(double a , double b) {
		  if (b == 0) {
	            System.out.println("Error: Cannot divide by zero.");
	            return Double.NaN;
	        }
		return a / b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        
        System.out.println("\nChoose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
        System.out.print("Enter choice (1-5): ");
        
        int choice = scanner.nextInt();

        if (choice == 5) {
            keepRunning = false;
            System.out.println("Exiting calculator. Thank you!");
        }
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        
        switch (choice) {
        case 1:
            result = add(num1, num2);
            System.out.println("Result: " + result);
            break;
        case 2:
            result = sub(num1, num2);
            System.out.println("Result: " + result);
            break;
        case 3:
            result = mul(num1, num2);
            System.out.println("Result: " + result);
            break;
        case 4:
            result = div(num1, num2);
            if (!Double.isNaN(result)) {
                System.out.println("Result: " + result);
            }
            break;
        default:
            System.out.println("Invalid choice. Please select between 1 and 5.");
    }
}






	}


