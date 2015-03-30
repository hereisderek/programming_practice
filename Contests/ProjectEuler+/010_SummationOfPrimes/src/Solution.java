import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler010
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean D = true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();
	static long[] array = new long[1000001];
	static int index = 1;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		long time = System.nanoTime();
//		getPrimeArray(1000000);
		if (D) System.out.println("Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		
		for (int i = 0; i < numOfCases; i++){
//			calculateCase(Long.parseLong(in.readLine())); 
			calculateCase(Integer.parseInt(in.readLine())); 
		}
		
		
	}

	private static void calculateCase(int input) throws IOException{

		if (D) System.out.println("Processing: " + input);
		System.out.println(sum(getPrimeArray(input), input));
		
	}
	private static long sum(long[] a, int cut){
		long sum = 0L;
		for (long l : Arrays.copyOfRange(a, 0, cut)){
			if (D)System.out.println("adding " + l);
			sum += l;
		}
		return sum;
	}
	public static long[] getPrimeArray(int num){
//		long[] array = new long[num];
		if (num >= 1){
			array[0] = 2;
			long prime = array[index-1] + 1;
//			int index = 1;
			
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
//		return array;
		return Arrays.copyOfRange(array, 0, num);
	}
}
