package practice2;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long fact = 1;
		System.out.println("Enter the number:");
		int num = scan.nextInt();
		scan.close();
		fact = factorial(fact, num);
		System.out.println("Factorial of "+num +" is:"+fact);
	}

	private static long factorial(long fact, int num) {
		while (num > 1) {
			fact = fact * num;
			num = num - 1;
		}
		return fact;
	}
}
