import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * i mean do not add the sum of multiples of 3 and 5 starting from beginng till N as the test cases have very large values for N and it will result in "Terminated due to Timeout"....
O(1)
Instead, take a small N and write the multiples of 3 and 5! Now try to figure out a formula which will give you the sum.. See {Arithmetic Progression } It will run in constant time for any value of N.
Check corner cases like n%15 == 0
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
	private static void calculateCase(Long N) throws IOException{
		long max = N;
		long sum = 0;
		if (D) System.out.println("Processing: " + max);
		long times5 = max / 5;
		long times3 = max / 3;
		for (int i = 1; i <= times5 && i * 5 < max; i++){
			sum += i * 5;
			if (D) System.out.println("adding: " + i * 5);
		}
		for (int i = 1; i <= times3 && i * 3 < max; i++){
			if( i * 3 % 5 != 0){ 
				sum += i * 3;
				if (D) System.out.println("adding: " + i * 3);
			}
			
		}
		
		
		System.out.println(sum);
	}
}
