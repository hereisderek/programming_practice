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
	public static boolean D = !true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
//			Scanner s = new Scanner(in.readLine());
//			calculateCase(s.nextInt(), s.nextInt());
			calculateCase(Integer.parseInt(in.readLine()));
		}
		
		
	}

	private static void calculateCase(int input) throws IOException{
		int result = 1;
		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		
		for (int i = 1; i <= input; i++){
			if (D) System.out.print("Calculating commonMulti of " + result + " & " + i);
			result = commonMultiple(result, i);
			if (D) System.out.println(" got " + result);
		}
		
		
		if (D) System.out.print("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
	public static int commonMultiple(int a, int b){
		int result = 1;
		for (int i = Math.min(a, b); i > 1; i--){
/*			if (a % i == 0 && b % i == 0){
				a /= i; b /= i;
				result *= i;
			}*/
			while(a % i == 0 && b % i == 0){
				a /= i; b /= i;
				result *= i;
			}
		}
		return result * a * b;
	}
	public static int commonMultiple2(int a, int b){
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
