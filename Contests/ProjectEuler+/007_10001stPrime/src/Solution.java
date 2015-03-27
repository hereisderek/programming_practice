import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler006
 * http://beginnersbook.com/2014/01/java-program-to-display-first-n-or-first-100-prime-numbers/
 * Just checking all numbers of the form 6n - 1 and 6n + 1 for primality (limiting the divisor to sqrt(num) of course) 
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
		
		
		
/*		int counter = 0;
		for (int i = 0; i < 10002; i++){
			long time = System.nanoTime();
			getPrimeArray(i);
			long endTime = System.nanoTime();			
			if (D) System.out.println("calculate: " + i + " Time required to calculate in nanoseconds: " + (endTime - time));
			if ((endTime - time) >= 4 * Math.pow(10, 9)) {
				System.err.println("Timed out");
				counter ++;
			}
		}
		System.out.println("Total timed out: " + counter);*/
	}

	private static void calculateCase(int input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		long time = System.nanoTime();
		
		long result = getPrimeArray(input)[input - 1];
		
		
		if (D) System.out.println("Final calculate: " + result + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		if (!D) System.out.println(result);
	}
	public static long[] getPrimeArray(int num){
		long[] array = new long[num];
		if (num >= 1){
			array[0] = 2;
			long prime = 3;
			int index = 1;
			
			while (index < num){
//				if (D) System.out.println("calculating " + (index +1));
				boolean isPrime = true;
				for (int i = 2; i <= Math.sqrt(prime) + 1; i++){
					if (prime % i == 0 && prime != i){						
						isPrime = false;
						break;
					}
				} 
				if (isPrime){
					array[index] = prime;
					index ++;
				}
				prime ++;
			}
		}
		return array;
	}
}
