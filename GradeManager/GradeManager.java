package GradeManager;

import java.util.HashMap;

import java.util.Scanner;

public class GradeManager {

	private HashMap<String, Integer> grades;

	public GradeManager() {

		grades = new HashMap<>();

	}

	// Method to add a new student

	public void addStudent(String name, int grade) {

		grades.put(name, grade);

		System.out.println("Student " + name + " added with grade " + grade + ".");

	}

	// Method to remove a student

	public void removeStudent(String name) {

		if (grades.containsKey(name)) {

			grades.remove(name);

			System.out.println("Student " + name + " removed.");

		} else {

			System.out.println("Student " + name + " not found.");

		}

	}

	// Method to display a student's grade by name

	public void displayGrade(String name) {

		Integer grade = grades.get(name);

		if (grade != null) {

			System.out.println("Grade of " + name + ": " + grade);

		} else {

			System.out.println(name + " is not found in the grade list.");

		}

	}

	public static void main(String[] args) {

		GradeManager manager = new GradeManager();

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("\n1. Add Student");

			System.out.println("2. Remove Student");

			System.out.println("3. Display Grade");

			System.out.println("4. Exit");

			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			scanner.nextLine(); // Consume newline

			switch (choice) {

			case 1:

				System.out.print("Enter student name: ");

				String addName = scanner.nextLine();

				System.out.print("Enter student grade: ");

				int addGrade = scanner.nextInt();

				manager.addStudent(addName, addGrade);

				break;

			case 2:

				System.out.print("Enter student name to remove: ");

				String removeName = scanner.nextLine();

				manager.removeStudent(removeName);

				break;

			case 3:

				System.out.print("Enter student name to display grade: ");

				String displayName = scanner.nextLine();

				manager.displayGrade(displayName);

				break;

			case 4:

				System.out.println("Exiting...");

				System.exit(0);

				break;

			default:

				System.out.println("Invalid choice. Please enter a number between 1 and 4.");

			}

		}

	}

}
