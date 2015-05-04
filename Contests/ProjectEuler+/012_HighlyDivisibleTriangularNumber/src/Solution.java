import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler012
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean D = true;
	public static long[] results = new long[1000];
	private static int index = 0;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
//			calculateCase(Long.parseLong(in.readLine())); 
			calculateCase(Integer.parseInt(in.readLine())); 
		}
		
		
	}

	private static void calculateCase(int input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		long result = 0L;
		
		for (int i = index + 1; i <= index + input; i++){
			
			results[i] = results[i-1] + i + 1;
			if (D) System.out.println("calculating " + i + " : " + results[i]);
			if (i == index + input) result = results[i];
		}
		

		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
}
