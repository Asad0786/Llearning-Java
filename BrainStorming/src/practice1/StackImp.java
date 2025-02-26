package practice1;

import java.util.Scanner;

public class StackImp {
	static int[] a = new int[6];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int top = -1;
		do {
			System.out.println("Press 1 to insert the stack");
			System.out.println("Press 2 to delete an element");
			System.out.println("Press 3 to view the whole stack");
			System.out.println("Press 4 to see the toppest element in the stack");
			System.out.println("press 0 to exit");
			System.out.print("Enter your Choice:");
			int choice = scan.nextInt();
			int element;
			x: switch (choice) {
			case 0:
				System.exit(0);
			case 1:
				if (top < 5) {
					System.out.println("Enter the element you want to add");
					element = scan.nextInt();
					top = StackImp.insertElement(element, top);
				} else {
					System.out.println("Stack overflow");
				}
				break x;
			case 2:
				top = StackImp.deleteElement(top);
				break x;
			case 3:
				StackImp.viewStack(top);
				break x;

			case 4:
				StackImp.peekStack(top);
				break x;
			default:
				System.out.println("Invalid entry");
			}
		} while (true);

	}

	private static void peekStack(int top) {
		if (top == -1) {
			System.out.println("Empty stack");
		} else {
			System.out.println(a[top] + " ");
		}

	}

	private static void viewStack(int top) {
		if (top == -1) {
			System.out.println("Empty stack");
		} else {
			for (int i = 0; i <= top; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("");
		}

	}

	private static int deleteElement(int top) {
		if (top == -1) {
			System.out.println("Empty stack");
		} else {
			System.out.println(a[top] + " deleted form array");
			top--;
		}
		return top;

	}

	private static int insertElement(int element, int top) {
		top++;
		a[top] = element;
		System.out.println("element inserted");

		return top;

	}

}
