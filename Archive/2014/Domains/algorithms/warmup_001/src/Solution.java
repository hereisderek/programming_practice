/**
 * 
 */


import java.util.Scanner;

/**
 * @author derek 27/08/2015 2015 Solution.java
 */
public class Solution {

	static int solveMeFirst(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a;
		a = in.nextInt();
		int b;
		b = in.nextInt();
		int sum;
		sum = solveMeFirst(a, b);
		System.out.println(sum);
	}
}
