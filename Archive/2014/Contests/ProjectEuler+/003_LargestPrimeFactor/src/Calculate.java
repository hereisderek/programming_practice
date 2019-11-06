import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculate {
	public static boolean D = true;
	private static long factor = 2;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		long max = (long) Math.pow(10, 12);
		System.out.print("Input the max range of prime number to generate, default is: " + max + " ");
		String input = "";
		try {
			input = in.readLine();
			max = Long.parseLong(input);
		} catch (NumberFormatException e){
			if (input.trim().equals("")){
				System.out.println("no input, using default");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		if (D) System.out.println("using max: " + max);
		if (D) System.out.println("Prime numbers: ");
		for (int i = 2; i <= max; i++){
			if (isPrime(i)) System.out.print(i + " "); 
		}
		int[] a = {1,2}; 
		
	}
	public static boolean isPrime(long l) {
        for(long num = 2, max = l / 2 ; num < max; num++) {
            if(l % num == 0) {
                return false;
            }
        }
        return true;
    }
/*	public static void PrimeSieve(long l) { 

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[l + 1];
        for (long i = 2; i <= l; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i*i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes++;
        }
        System.out.println("The number of primes <= " + N + " is " + primes);
    }*/
}
