import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * 
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean D = true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
			Scanner s = new Scanner(in.readLine());
			calculateCase(s.nextInt(), s.nextInt()); 
		}
		
		
	}

	private static void calculateCase(int a, int b) throws IOException{
		int result = 0;
		if (D) System.out.println("Processing: " + a + ", " + b);
		long time = System.nanoTime();
		
		result = commonMultiple(a, b);
		
		if (D) System.out.print("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
	private static int commonMultiple(int a, int b){
		int result = 1;
		for (int i = 2; i < Math.min(a, b); i++){
			if (a % i == 0 && b % i == 0){
				a /= i; b /= i;
				result *= i;
			}
		}
		return result * a * b;
	}
}
