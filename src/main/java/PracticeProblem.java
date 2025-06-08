public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {
		int col = 0; 
		int row = arr.length - 1; 
	
		
		int moves = 0;
		int result = searchMazeMovesHelper(arr, row, col, moves);
		
		if (result == Integer.MAX_VALUE) {
			return -1;
		} else {
			return result;
		}
	}


	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {
		
		int cols = arr[0].length; 
		int rows = arr.length;  

		if (row < 0 || row >= rows || col < 0 || col >= cols) {
			return Integer.MAX_VALUE;
		} 

		if (arr[row][col].equals("F")) {
			return moves;
		}

		
		int up = searchMazeMovesHelper(arr, row - 1, col, moves + 1);
		int right = searchMazeMovesHelper(arr, row, col + 1, moves + 1);

		int min = Math.min(right, up);

		return min;

	}



	public static int noOfPaths(String[][] patharr) {
		int col = 0;
		int row = patharr.length - 1;
		
		return noOfPathsHelper(patharr, row, col);
	}

	public static int noOfPathsHelper(String[][] patharr2, int row, int col) {
		int cols = patharr2[0].length;
		int rows = patharr2.length;
		

		if (row < 0 || row >= rows || col < 0 || col >= cols) {
			return 0;
		} 

		if (patharr2[row][col].equals("F")) {
			return 1;
		}

		
		int right = noOfPathsHelper(patharr2, row, col + 1); //
		int nor = noOfPathsHelper(patharr2, row - 1, col); //nor is meant to be north but is too long
		return nor + right;

	}
}