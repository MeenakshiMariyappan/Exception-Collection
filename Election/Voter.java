package Election;

import java.util.Scanner;

public class Voter {
	private int voterId;
	private String name;
	private int age;

	// Parameterized constructor
	public Voter(int voterId, String name, int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Invalid age for voter");
		}
		this.voterId = voterId;
		this.name = name;
		this.age = age;
	}

	// Getters
	public int getVoterId() {
		return voterId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// Setters
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Invalid age for voter");
		}
		this.age = age;
	}

	// Main method for testing
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Voter ID: ");
		int voterId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();

		try {
			Voter voter = new Voter(voterId, name, age);
			System.out.println("Voter details:");
			System.out.println("Voter ID: " + voter.getVoterId());
			System.out.println("Name: " + voter.getName());
			System.out.println("Age: " + voter.getAge());
		} catch (InvalidAgeException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}