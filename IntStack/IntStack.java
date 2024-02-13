package IntStack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class IntStack {
	private int[] stackArray;
	private int top;
	private static final int DEFAULT_CAPACITY = 10;

	// Constructor to initialize the stack with default capacity
	public IntStack() {
		this(DEFAULT_CAPACITY);
	}

	// Constructor to initialize the stack with specified capacity
	public IntStack(int capacity) {
		stackArray = new int[capacity];
		top = -1;
	}

	// Method to push elements onto the stack
	public void push(int element) {
		if (top == stackArray.length - 1) {
			resize(stackArray.length * 2);
		}
		stackArray[++top] = element;
		System.out.println("Element " + element + " pushed onto the stack.");
	}

	// Method to pop elements from the stack
	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int poppedElement = stackArray[top--];
		System.out.println("Element " + poppedElement + " popped from the stack.");
		if (top < stackArray.length / 4) {
			resize(stackArray.length / 2);
		}
		return poppedElement;
	}

	// Method to check if the stack is empty
	public boolean isEmpty() {
		return top == -1;
	}

	// Method to resize the stack
	private void resize(int newCapacity) {
		int[] newArray = new int[newCapacity];
		System.arraycopy(stackArray, 0, newArray, 0, Math.min(stackArray.length, newCapacity));
		stackArray = newArray;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IntStack stack = new IntStack();

		while (true) {
			System.out.println("\n1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter element to push: ");
				int elementPush = scanner.nextInt();
				stack.push(elementPush);
				break;
			case 2:
				try {
					int poppedElement = stack.pop();
					System.out.println("Popped element: " + poppedElement);
				} catch (EmptyStackException e) {
					System.out.println("Stack is empty. Cannot pop.");
				}
				break;
			case 3:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please enter 1, 2, or 3.");
			}
		}
	}
}
