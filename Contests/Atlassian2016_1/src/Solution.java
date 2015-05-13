import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Base atlassian 
public class Solution {
	private static final char[] sequences = { '0', 'a', 't', 'l', 's', 'i', 'n' };

	/*
	 * Complete the function below.
	 */

	static String convert(long input) {
		String output = Long.toString(input, 7);
		String result = "";
		StringBuilder sb = new StringBuilder();
		for (char a : output.toCharArray()){
//			result += sequences[Integer.parseInt(a+"")];
			sb.append(sequences[Character.getNumericValue(a)]);
		}
//		for (int i = output.length()-1; i >= 0 ; i--){
//			sb.append(sequences[])
//		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res;
		long _in;
		_in = Long.parseLong(in.nextLine());

		res = convert(_in);
		bw.write(res);
		bw.newLine();

		bw.close();
	}
}