import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static String LookAndSay(String start, int n) {
		if (n == 1){
/*			StringBuilder sb = new StringBuilder();
			char currentChar = start.charAt(start.length()-1);
			int currentIndex = start.length()-1;
			int counter = 1;
			for (int i = currentIndex; i > 0; i--){
				for (int j = i; j >= 0; j--){
					
				}
//				while (currentChar == start.charAt(index))
			}*/
			return LookAndSay(start);
		} else {
			return LookAndSay(start, n-1);
		}
    }
	static String LookAndSay(String start){
		StringBuilder sb = new StringBuilder();
		char[] array = start.toCharArray();

		for (int i = 0; i < array.length-1; i++){

			int counter = 1;
			int currentChar =  ('0' + array[i]);
			int nextChar =  ('0' + array[i+1]);
			while (currentChar == nextChar){
				counter ++;
				i+=1;
			}
			sb.append(""+counter+currentChar);
			i-=1;
			
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }
        
        int _n;
        _n = Integer.parseInt(in.nextLine());
        
        res = LookAndSay(_start, _n);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }

}