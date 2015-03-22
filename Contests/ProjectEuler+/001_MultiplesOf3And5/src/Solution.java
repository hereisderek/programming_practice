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
	public static boolean _DEBUG_ = true;
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
		for (long i = 1; i < max; i++){
			if (i%3 == 0 || i%5 == 0){
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
