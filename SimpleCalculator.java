import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.println("Welcome to the Simple Calculator!");

        while (true) {
            // Get first number
            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();

            // Get operator
            System.out.print("Enter operator (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            // Validate operator
            if (!isValidOperator(operator)) {
                System.out.println("Invalid operator! Please try again.");
                continue;
            }

            // Get second number
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            // Perform calculation
            result = calculate(num1, num2, operator);

            // Display result
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            // Ask for another calculation
            System.out.print("Do you want to perform another calculation? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice != 'y' && choice != 'Y') {
                break;
            }
        }

        System.out.println("Thank you for using the Simple Calculator!");
    }

    private static boolean isValidOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }
    }
}
