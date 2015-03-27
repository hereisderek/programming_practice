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
	public static boolean D = true;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
//		String test = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		for (int i = 0; i < numOfCases; i++){
//			calculateCase(Long.parseLong(in.readLine())); 
			Scanner s = new Scanner(in.readLine());
/*			if (D) System.out.println(s.nextInt() + " " +
										s.nextInt() + " " + 
										in.readLine()
					);*/
			calculateCase(s.nextInt(), s.nextInt(), in.readLine());
		}
		
		
	}

	private static void calculateCase(int N, int K, String inputStr) throws IOException{

		if (D) System.out.println("Processing: " + inputStr);
		long time = System.nanoTime();
		
		int result = 0;
//		String inputStr = ""+input;
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
