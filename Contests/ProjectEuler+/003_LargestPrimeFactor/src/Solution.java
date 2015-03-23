import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003
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
		long largestPF = prime(input);
		
		if (D) System.out.print("Final calculate: ");
		System.out.println(largestPF);
	}
	private static long prime(long n){
		long i = 2;
		while ( n % i != 0 && i < n){
			i ++;
		}
		if (D) System.out.println("found factor i: " + i);
		
		if (i < n){
			return prime(n/i);
		} else {
			return n;
		}
	}
	public static int primeFactors(BigInteger number)     {
	    BigInteger copyOfInput = number;
	    int lastFactor = 0;
	    for (int i = 2;
	    BigInteger.valueOf(i)
	    .compareTo(copyOfInput) <= 0; i++) {
	        if (copyOfInput.mod(BigInteger.valueOf(i))
	        .compareTo(BigInteger.ZERO) == 0) 
	        {
	            lastFactor = i;
	            copyOfInput = copyOfInput
	            .divide(BigInteger.valueOf(i));
	            i--;
	        }
	    }
	    return lastFactor;
	}
}
