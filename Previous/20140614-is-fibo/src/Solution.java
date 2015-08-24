import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
	public static void main(String[]  args){
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int methodIndex = 1;//in.nextInt();
		
		long input;
		while (in.hasNext()){
			input = in.nextLong();
			switch (methodIndex) {
			case 1:
				showResult(isFibByGeneration(input));
				break;
			case 2:
				showResult(isFibByFormula(input));
				break;
			default:
				break;
			}
		}
		
	}
	public static void showResult(boolean b){
		System.out.println(b ? "IsFibo" : "IsNotFibo");
	}
	public static boolean isFibByGeneration(long x){
		long a = 0;
		long b = 1;
		long f = 1;
		while (b < x){
			f = a + b;
			a = b;
			b = f;
		}
		return x == f;
	}
	private static boolean isFibByFormula(long num) {
		
//	    double first = 5 * Math.pow((num), 2) + 4;
//	    double second = 5 * Math.pow((num), 2) - 4;
	    double power = (double)num * (double)num;
	    double first = 5 * power + 4;
	    double second = 5 * power - 4;

	    return isWholeNumber(Math.sqrt(first)) || isWholeNumber(Math.sqrt(second));
	}

	private static boolean isWholeNumber(double num) {
	    return num - Math.round(num) == 0;
	}
}
