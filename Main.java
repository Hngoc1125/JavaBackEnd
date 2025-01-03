import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Number entered is: " + num);

        int sum = num;
        sc.nextLine();

        while (true) {
            System.out.print("Enter a series number (or :s to stop): ");
            String input = sc.nextLine();

            if (input.trim().equals(":s")) {
                System.out.println("Sum of the entered numbers is: " + sum);
                break;
            }

            try {
                int number = Integer.parseInt(input);
                sum += number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        sc.close();
    }
}
