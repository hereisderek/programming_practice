import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler013
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	private static long result = 0;
	public static boolean D = true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
//			cut the 13th digit
			String numbers = in.readLine();
			int len = numbers.length();
			numbers = numbers.substring(0, 13);
			Long temp;
			calculateCase(temp = Long.parseLong(numbers)); 
//			calculateCase(Integer.parseInt(in.readLine())); 
		}
		System.out.println((""+result).substring(0, 10));
		
		
	}

	private static void calculateCase(Long input) throws IOException{
		result += input;

//		if (D) System.out.println("Processing: " + input);
//		long time = System.nanoTime();
//		
//		long result = 0L;
//
//		
//		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
//		if (!D) System.out.println(result);
	}
}
