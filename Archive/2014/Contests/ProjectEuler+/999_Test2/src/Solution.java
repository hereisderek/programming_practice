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
	public static boolean D = false;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
			Scanner a = new Scanner(in.readLine());
			calculateCase(a.nextLong(), a.nextLong()); 
		}
	}

	private static void calculateCase(Long a, Long b) throws IOException{

		if (D) System.out.println("Processing: " + a);
		long time = System.nanoTime();
		
		long result = 0L;
		for (long i = a+1; i <= b; i++){
			if (ifSquare(i)) result++;
		}

		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
//		return result;
	}
	private static boolean ifSquare(Long l){
		return (Math.sqrt(l) == (int) (Math.sqrt(l)));
	}
}
