import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler008
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean D = !true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
//			calculateCase(Long.parseLong(in.readLine())); 
			Scanner s = new Scanner(in.readLine());
/*			if (D) System.out.println(s.nextInt() + " " +
										s.nextInt() + " " + 
										Long.parseLong(in.readLine())
//										s.nextLine()
					);*/
			calculateCase(s.nextInt(), s.nextInt(), Long.parseLong(in.readLine()));
		}
		
		
	}

	private static void calculateCase(int N, int K, Long input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		
		int result = 0;
		String inputStr = ""+input;
		for (int i = 0; i < inputStr.length() - K + 1; i++){
			String inputCut = inputStr.substring(i, i + K);
			if (D) System.out.println("calculating " + inputCut);
			int output = calculateProduct(inputCut);
			result = Math.max(result, output);
		}
		
		
		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
	
	public static int calculateProduct(String inputStr){
		int result = 1;
		if (inputStr.contains("0")){
			result = 0;
		} else {
			for(char i : inputStr.toCharArray()){
				result *= Integer.parseInt(i+"");
			}
		}
		return result;
		
	}
}
