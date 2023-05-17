package practice2;

import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("hry", 1);
		ht.put("hey", 2);
		ht.put("ey", 3);
		System.out.println("ey".hashCode());
		System.out.println("hey".hashCode());
		System.out.println("hry".hashCode());
		System.out.println(ht);
		System.out.println(ht.get("hr"));
		System.out.println(ht.get("ey"));
	}
}
