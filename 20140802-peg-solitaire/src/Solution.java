import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.
// score for each testcase = (1 + #initialPegs - #pegsLeft) * 10/#initialPegs
public class Solution {
	public static boolean _DEBUG_ = true;
	public static enum MOVE {UP, DOWN, LEFT, RIGHT};
	public static enum CHARACTER {
		EMPTY (45), PEG (46), INACCESSIBLE(120);
		
		private int value;
        private CHARACTER(int value) {
                this.value = value;
        }
        public int getValue(){
        	return this.value;
        }
        public static CHARACTER fromValue(int value) throws IllegalArgumentException{
        	try{
        		return CHARACTER.values()[value];
        	} catch( ArrayIndexOutOfBoundsException e ) {
                throw new IllegalArgumentException("Unknown enum value :"+ value);
            }
        }
	};
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Program program = new Solution().new Program();
		program.main(args);
		return;
		
	}
	
	private static int findMaxInIntArray(int[] a){
		if (a.length < 1) throw new NullPointerException("array lengh less than 1");
		int i = a[0];
		for (int j : a){
			if (j > i) i = j;
		}
		return i;
	}
	private static void printMatrix(int[][] a){
		int n = a.length;
		int m = a[0].length;
		for (int i = 0; i < n; i ++){
			for (int j = 0; j < m; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	private class Program{
		private List<Testcase> testcaseList;
		public Program() {
			// TODO Auto-generated constructor stub
			testcaseList = new ArrayList<Testcase>();
		}
		private void main(String[] args) throws NumberFormatException, IOException {
			Scanner scanner = new Scanner(in);
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			
			int matrix[][] = new int[n][m];
			for (int i = 0; i < n; i ++){
				String line = in.readLine();
				
				for (int j = 0; j < m; j++){
					matrix[i][j] = line.charAt(j);
				}
			}
			
			Testcase tc = new Testcase(matrix);
			int initialPegs = tc.pegsLeft();
			calculateTestCase(tc);
			
			// calculate the highest score
			Testcase tcResult = testcaseList.get(0);
			double maxScore = tcResult.score(initialPegs);
			for (Testcase t : testcaseList){
				if (maxScore < t.score(initialPegs)){
					maxScore = t.score(initialPegs);
					tcResult = t;
				}
			}
			
			// show result
			if (_DEBUG_) printMatrix(tcResult.getMatrix());
			System.out.println(tcResult.getOutput().size());
			for (String str : tcResult.getOutput()) {
				System.out.println(str);
			}
		}
		private Testcase calculateTestCase(Testcase t){
			boolean stillRuning = false;
			Testcase tcResult = t;
			int m = t.getM();
			int n = t.getN();
			for (int i = 0; i < n; i ++){
				for (int j = 0; j < m; j++){
					for (MOVE k : MOVE.values()) {
						Testcase tc = t.move(j, i, k);
						//System.out.println(k);
						if (tc == null){
							
						} else {
							stillRuning = true;
							tcResult = calculateTestCase(tc);
						}
					}
				}
			}
			if (!stillRuning) {
				if (_DEBUG_) printMatrix(tcResult.getMatrix());
				testcaseList.add(tcResult);
			}
			return tcResult;
		}
	}
	
	private class Testcase{
		private int matrix[][];
		private int m, n;
		private List<String> output;
		//private double _score;
		
		public Testcase(int[][] matrix) {
			// TODO Auto-generated constructor stub
			this.matrix = matrix;
			this.setMatrix(matrix);
			n = matrix.length;
			m = matrix[0].length;
			output = new ArrayList<>();
		}
		
		public int[][] getMatrix() {
			return matrix.clone();
		}

		public void setMatrix(int[][] matrix) {
			this.matrix = matrix.clone();
		}

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public double score(int initialPegs){
			return (1+initialPegs - pegsLeft()) * 10 / initialPegs;
		}
		
		
		public List<String> getOutput() {
			return output;
		}

		public void setOutput(List<String> output) {
			this.output = output;
		}

		@Override
		protected Testcase clone() {
			Testcase tc = new Testcase(this.matrix);
			tc.setOutput(output);
			return tc;
		}
		public Testcase move(int x, int y, MOVE move){
			boolean result = true;
			try{
				if (matrix[y][x] != CHARACTER.PEG.getValue()) throw new Exception(String.format("Position %d, %d is not a PEG", x, y));
				int adjacentX = x, adjacentY = y, holeX = x, holeY = y;
				switch (move) {
				case UP:
					adjacentY --;
					holeY -= 2;
					break;
				case DOWN:
					adjacentY ++;
					holeY += 2;
					break;
				case LEFT:
					adjacentX --;
					holeX -= 2;
					break;
				case RIGHT:
					adjacentX ++;
					holeX += 2;
					break;

				default:
					throw new Exception(String.format("invalid move at position (%d, %d)", x, y));
					//break;
				}
				if (adjacentX > matrix.length - 1 || adjacentX < 0 || adjacentY < 0 || adjacentY > matrix[0].length - 1) throw new Exception(String.format("adjacent position (%d, %d) of (%d, %d) for %s is out of range", adjacentX, adjacentY,  x, y, move));
				if (holeX > matrix.length - 1 || holeX < 0 || holeY < 0 || holeY > matrix[0].length - 1) throw new Exception(String.format("hole position (%d, %d) of (%d, %d) for %s is out of range", holeX, holeY, x, y, move));
				if (matrix[adjacentY][adjacentX] != CHARACTER.PEG.getValue()) throw new Exception(String.format("adjacent position (%d, %d) of (%d, %d) for %s is not a PEG", adjacentX, adjacentY, x, y, move));
				if (matrix[holeY][holeX] != CHARACTER.EMPTY.getValue()) throw new Exception(String.format("hole position (%d, %d) of (%d, %d) for %s is not EMPTY", holeX, holeY, x, y, move));
				
				// do the job
				matrix[adjacentY][adjacentX] = CHARACTER.EMPTY.getValue();
				matrix[holeY][holeX] = CHARACTER.PEG.getValue();
				matrix[y][x] = CHARACTER.EMPTY.getValue();
				
				this.output.add(String.format("%d %d %s", x, y, move));
				if (_DEBUG_) System.out.println(String.format("%d %d %s", x, y, move));;
			} catch (Exception e) {
				if (_DEBUG_) System.out.println(e.getMessage());
				result = false;
			}
			return (result ? this.clone() : null);
		}

		private int pegsLeft(){
			int s = 0;
			for (int i = 0; i < n; i ++){
				for (int j = 0; j < m; j++){
					if (matrix[i][j] == CHARACTER.PEG.getValue()){
						s ++;
					}
				}
			}
			return s;
		}
	}
}
