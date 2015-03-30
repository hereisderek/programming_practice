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
	public static boolean D = !true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();
	static final int ROW = 20, COLUME = 20, ADJACENT = 4;
	static int[][] array = new int[ROW][COLUME];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner s = new Scanner(in);
		// store input
		for (int i = 0; i < ROW; i ++){
			for (int j = 0; j < COLUME; j++){
				array[i][j] = s.nextInt();
			}
		}
		if (D) System.out.println("Finished reading array:\n" + Arrays.deepToString(array));
		int result = 0;
		for (int i = 0; i < ROW; i ++){
			for (int j = 0; j < COLUME; j++){
				result = Math.max(result, calculateCell(i, j));
			}
		}
		System.out.println(result);
	}

	private static void calculateCase(Long input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		
		long result = 0L;

		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
//	TODO: generic cases
	private static int calculateCell(int r, int c){
		int max = 0;
//		not working for generic cases
//		down
		if (r + ADJACENT - 1 < ROW) max = Math.max(max, array[r][c] * array[r+1][c] * array[r+2][c] * array[r+3][c]); 
//		right
		if (c + ADJACENT - 1 < COLUME) max = Math.max(max, array[r][c] * array[r][c+1] * array[r][c+2] * array[r][c+3]);
//		up right
		if (c + ADJACENT < COLUME + 1 && r - ADJACENT + 1 >= 0) max = Math.max(max, array[r][c] * array[r-1][c+1] * array[r-2][c+2] * array[r-3][c+3]);
//		down right
		if (r + ADJACENT - 1 < ROW && c + ADJACENT - 1 < COLUME) max = Math.max(max, array[r][c] * array[r+1][c+1] * array[r+2][c+2] * array[r+3][c+3]);
		
		return max;
	}
}
