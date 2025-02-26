package practice1;

import java.util.Scanner;

public class BinarySearch {
	public static int[] sort(int ar[]) {
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1; j++) {
				if (ar[j] > ar[j + 1]) {

					// System.out.println("a"+j);
					ar[j] = ar[j + 1] + ar[j];
					ar[j + 1] = ar[j] - ar[j + 1];
					ar[j] = ar[j] - ar[j + 1];

				}
			}
		}
		return ar;
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 4, 5, 77, 88, 12, 3, 6, 2, 11 };
		arr = BinarySearch.sort(arr);
		for (int x : arr) {
			System.out.println(x);
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter element to be found:");
		int data = scan.nextInt();
		boolean b = BinarySearch.binarySearch(data, arr);
		// System.out.println("asd");
		System.out.println(b ? "found":"not found");
		scan.close();
	}

	private static boolean binarySearch(int data, int arr[]) {
		int min = 0;
		int max = arr.length - 1;
		while (min < max-1) {
			int mid = (min + max) / 2;
			if (arr[mid] > data)
				max = mid;
			else if (arr[mid] < data)
				min = mid;
			else if (arr[mid] == data) {
				mid = mid + 1;
				System.out.println("Data" + data + " found at location: " + mid);
				return true;
			}
		}

		return false;
	}

}
