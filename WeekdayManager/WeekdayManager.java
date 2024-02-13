package WeekdayManager;

import java.util.Scanner;

public class WeekdayManager {

	private String[] weekdays;

	public WeekdayManager() {

		weekdays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	}

	public String getDayName(int dayPosition) {

		return weekdays[dayPosition];

	}

	public static void main(String[] args) {

		WeekdayManager manager = new WeekdayManager();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the day position (0-6): ");

		int dayPosition = scanner.nextInt();

		try {

			String dayName = manager.getDayName(dayPosition);

			System.out.println("The day is: " + dayName);

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Error: Invalid day position entered. Please enter a number between 0 and 6.");

		}

	}

}
