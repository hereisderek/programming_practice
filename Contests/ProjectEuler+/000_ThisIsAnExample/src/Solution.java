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
			calculateCase(Long.parseLong(in.readLine())); 
		}
		
		
	}

	private static void calculateCase(Long input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		
		long result = 0L;

		
		if (D) System.out.print("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
}
