import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler006
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
			calculateCase(Integer.parseInt(in.readLine())); 
		}
		
		
	}

	private static void calculateCase(int input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		
		long result = sumSquare(input) - squareSum(input);
		 result = result > 0 ? result : -result;
		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
//	The sum of the squares of the natural numbers
	public static Long sumSquare(int max){
		long result = 0;
		for (int i = 1; i <= max; i++){
			result += i * i;
		}
		return result;
	}
//	The square of the sum of the natural numbers
	public static Long squareSum(int max){
		long result = 0;
		for (int i = 1; i <= max; i++){
			result += i;
		}
		return result * result;
	}
}
