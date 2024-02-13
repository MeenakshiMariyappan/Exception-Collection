package StudentHub;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter student details:");
		System.out.print("Roll No: ");
		int rollNo = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Age: ");
		int age = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Course: ");
		String course = scanner.nextLine();

		try {
			// Creating student object with input details and handling exceptions
			if (age < 15 || age > 21) {
				throw new AgeNotWithinRangeException("Age should be between 15 and 21.");
			}

			if (!isValidName(name)) {
				throw new NameNotValidException("Name should not contain numbers or special symbols.");
			}

			Student student = new Student(rollNo, name, age, course);
			System.out.println("Student details:");
			System.out.println(student);
		} catch (AgeNotWithinRangeException e) {
			System.out.println("AgeNotWithinRangeException caught: " + e.getMessage());
		} catch (NameNotValidException e) {
			System.out.println("NameNotValidException caught: " + e.getMessage());
		}
	}

	private static boolean isValidName(String name) {
		// Check if name contains numbers or special symbols
		for (char c : name.toCharArray()) {
			if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
				return false;
			}
		}
		return true;
	}
}
