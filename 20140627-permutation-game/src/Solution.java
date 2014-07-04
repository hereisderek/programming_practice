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
			calculateCase(Integer.parseInt(in.readLine())); 
		}
		
		
	}
	private static void calculateCase(int N) throws IOException{
		int sequences[] = new int[N];
		Scanner scanner = new Scanner(in.readLine());
		for (int i = 0; i < N; i++){
			sequences[i] = scanner.nextInt();
		}
		System.out.println("sequences: " + Arrays.toString(sequences));
		int noOfIncreadingNum[] = new int[N];
		for (int i = 0; i < N; i++){
			int base = sequences[i];
			int counter = 1;
			for (int j = i; j < N; j++){
				if (sequences[j] > base){
					base = sequences[j];
					counter ++;
				}
			} 
			noOfIncreadingNum[i] = counter;
		}
		System.out.println("noOfIncreadingNum: " + Arrays.toString(noOfIncreadingNum));
		
		System.out.println( (N - findMaxInIntArray(noOfIncreadingNum)) % 2 == 1 ? "Alice" : "Bob" );
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
