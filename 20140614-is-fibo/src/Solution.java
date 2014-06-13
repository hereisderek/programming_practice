import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
	public static void main(String[]  args){
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int methodIndex = in.nextInt();
		
		int input;
		while ((input = in.nextInt()) != -1){
			switch (methodIndex) {
			case 1:
				showResult(isFibByGeneration(input));
				break;
			case 2:
				showResult(isFibByFormula(input));
			default:
				break;
			}
		}
		
	}
	public static void showResult(boolean b){
		System.out.println(b ? "IsFibo" : "IsNotFibo");
	}
	public static boolean isFibByGeneration(int x){
		int a = 0;
		int b = 1;
		int f = 1;
		while (b < x){
			f = a + b;
			a = b;
			b = f;
		}
		return x == f;
	}
	private static boolean isFibByFormula(int num) {
		
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
