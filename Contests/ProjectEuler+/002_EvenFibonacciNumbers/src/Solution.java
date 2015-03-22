import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler002
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
			calculateCase(Long.parseLong(in.readLine())); 
		}
		
		
	}
	private static void calculateCase(Long max) throws IOException{
		if (D) System.out.println("Processing: " + max);
		long[] fib;
		fib = new long[30];
		
		fib[0] = 2; fib[1] = 10;
		long cal1 = (long) 5, cal2 = (long) 8;
		int index = 1;

		for (int i = 1; i < max; i++){
			long newCal = cal1 + cal2;
			if (newCal >= max) break;
			if (D) System.out.print("Getting a new cal: " + newCal);
			if (newCal %2 == 0){
				index++;
				if (D) System.out.println("   And it is an odd number, adding to index: " + (index));
				fib[index] = newCal + fib[index-1];
				
			} else {
				if (D) System.out.println("   But it is not an odd number");
			}
			cal1 = cal2;
			cal2 = newCal;
			
		}


		if (D) System.out.print("Final calculate: ");
		System.out.println(fib[index]);
	}
}
