import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean _DEBUG_ = true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();
	static int[] kidRating;
	static int[] kidCandies;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numKids = Integer.parseInt(in.readLine());
		// initial variables
		kidRating = new int[numKids];
		kidCandies = new int[numKids];

		// read rating
		for (int i = 0; i < numKids; i++) {
			kidRating[i] = Integer.parseInt(in.readLine());
		}

		// initial candies to 1
		for (int i = 0; i < numKids; i++) {
			kidCandies[i] = 1;
		}
		
		// calculate candies
		int counter = 0;
		do{
			counter ++;
			printArray(kidRating, kidCandies);
		}
		while (sortArray(kidRating, kidCandies, counter % 2 == 0));


		int total = 0;
		for (int i : kidCandies)
			total += i;
		System.out.println(total);
	}


	private static boolean sortArray(int[] kidRating, int[]kidCandies, boolean inverse) {
		boolean ifChanged = false;
		int numKids = kidRating.length;
		//if (inverse) Collections.reverse(Arrays.asList(kidRating));
		for (int i = 1; i < numKids; i++) {
			//kidCandies[i] = (kidRating[i] > kidRating[i - 1]) ? kidRating[i - 1] + 1 : kidCandies[i];
		}
		if (! inverse){
			for (int i = 1; i < numKids; i++) {
				if (kidRating[i] > kidRating[i - 1] && kidCandies[i] <= kidCandies[i - 1]){
					kidCandies[i] = kidCandies[i - 1] + 1;
					ifChanged = true;
				} else {
					// nothing happens here
				}
			}
		} else {
			// inverse order
			for (int i = numKids - 2; i >= 0; i--) {
				if (kidRating[i] > kidRating[i + 1] && kidCandies[i] <= kidCandies[i + 1]){
					kidCandies[i] = kidCandies[i + 1] + 1;
					ifChanged = true;
				} else {
					// nothing happens here
				}
			}
		}
		return ifChanged;
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
}
