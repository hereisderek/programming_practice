import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler009
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
//	Assuming c>b>a
	public static void calculateCase(int input){

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		int result = -1;
//		N/3 < c < N/2
		for (int c = input / 3; c < input / 2; c++){
//			b > c / 2
			for (int b = c / 2; b < c; b++){
				int a = input - b - c;
				if (a > b) continue;
				if (isRTriangle(a, b, c)){
					if (D) System.out.println("Found a possible : " + a + " " + b + " " + c);
					result = Math.max(result, a*b*c);
				}
			}
		}

		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
	
	public static boolean isInt(double i){
		return i == (int) i;
	}
	public static boolean isRTriangle(int a, int b, int c){
		return c * c == a * a + b * b;
	}
}
