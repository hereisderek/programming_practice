import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler004
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
		int max = 0;
		for (int i = 100; i < 1000; i++){
			for(int j = i; j < 1000; j++){
				if ( i*j > input) break;
				if (isPalindrome(i * j)){
					if (D) System.out.println("get a palindrome: " + i + "*" + j + "=" + i * j);
					if (i * j > max) {
						max = i * j;
						if (D) System.out.println("got a new max: " + max);
					}
				}
			}
		}

		
		if (D) System.out.print("For input:" + input + " Final calculate: " + max);
		if (!D) System.out.println(input);
	}
	
	private static boolean isPalindrome(int number){
		if (D) System.out.print(number + " isPalindrome?");
		if (number <= 999999 && number >= 100000){
			boolean b1, b2, b3;
			b1 = (number / 100000 == (number - number / 10 * 10));
			int tmp = (number - number / 100000 * 100000) / 10000;
			int tmp2 = (number - number / 100 * 100) / 10;
			b2 = tmp == tmp2;
			b3 = (number - number / 10000 * 10000) / 1000 == (number - number / 1000 * 1000) / 100;
//			if (D) System.out.println((number - number / 10000 * 10000) / 1000 + " " + (number - number / 1000 * 1000) / 100);
//			if (D) System.out.println(b1 + " " + b2 + " " + b3);
//			return (b1 && true);
			if (b1 && b2 && b3){
				if (D) System.out.println(" true");
				return true;
			}
		}
		
		if (D) System.out.println(" false");
		return false;
	}
}
