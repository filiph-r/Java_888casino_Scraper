import java.util.Scanner;

public class main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your name:");
		String name = scanner.nextLine();
		System.out.println("Hello, " + name + "!");

		System.out.println("Enter your age:");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		if (age < 18) {
			System.out.println("You are underage.");
		} else {
			System.out.println("You are an adult.");
		}

		System.out.println("Enter 'yes' or 'no':");
		String response = scanner.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("You answered yes.");
		} else {
			System.out.println("You answered no.");
		}

		scanner.close();
	}
}
