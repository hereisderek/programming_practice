import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * 
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean D = true;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }
        
        res = maxDifference(_a);
        System.out.println(res);
        
    }
    
    static int maxDifference(int[] a) {
    	int max = a[1] - a[0];
    	for (int i = 0; i < a.length-1; i++){
    		for (int j = i+1; j < a.length; j++){
    			int r = a[j] - a[i];
    			if (max < r) max = r;
    		}
    	}
    	return max;
    }
}
