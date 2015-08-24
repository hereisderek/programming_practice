import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
			out.append(calculateCase(Integer.parseInt(in.readLine())) + "\n"); 
		}
		
		System.out.println(out);
	}
	private static String calculateCase(int N) throws IOException{
		String resultStr = "";
		long sequences[] = new long[N+1];

		for (int i = 0; i < (N + 1) / 2.0; i++){
			calculate(sequences, i);
		}
		for (long i : sequences){
			resultStr += (i + " ");
		}
		return resultStr;
	}
	private static long calculate(long[] results, int index){
		int N = results.length;
		long result;
		if (index == 0) {
			result = 1;
		} else {
			result = (results[index - 1] == 0 ? calculate(results, index - 1) : results[index - 1]);
			result *= ( (double)(N-index) / (index));
		}
		
		results[index] = result;
		results[N-index-1] = result;
		return result;
	}

	private static void printArray(int[] kidRating, int[]kidCandies) {
		if (!_DEBUG_)
			return;
		System.out.print("current array: ");
		for (int i = 0; i < kidRating.length; i++) {
			System.out.print("" + kidRating[i] + ":" + kidCandies[i] + " ");
		}
		System.out.println();
	}
	private static int findMaxInIntArray(int[] a){
		if (a.length < 1) throw new NullPointerException("array lengh less than 1");
		int i = a[0];
		for (int j : a){
			if (j > i) i = j;
		}
		return i;
	}
	
}
