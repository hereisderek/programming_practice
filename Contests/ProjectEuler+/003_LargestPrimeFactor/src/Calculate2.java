import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Calculate2 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args){
		
		long prime = 3;
		int index = 1;
		
		while (true){
//			if (D) System.out.println("calculating " + (index +1));
			boolean isPrime = true;
			for (int i = 2; i <= Math.sqrt(prime) + 1; i++){
				if (prime % i == 0 && prime != i){						
					isPrime = false;
					break;
				}
			} 
			if (isPrime){
//				prime;
				try {
					bw.write(prime + " ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					index ++;
					if (index % 100 == 0){
						try {
							bw.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
			prime ++;
		}
	}
}
