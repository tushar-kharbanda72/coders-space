// Problem 10.9 search in a M X N matrix in which rows and columns are sorted.
import java.util.Scanner;
public class SortedMatrixSearch{

	// Method 1 - using binary search. O(mlogn).
	public boolean findElement(int[][] matrix, int x){
		int row = 0, col = matrix[0].length - 1;
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == x) return true;

			if(matrix[row][col] > x){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}

	// Method 2 - complicated one, more like binary search.

	public Coordinate findElement2(int[][] matrix, int x){
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		return findElement2(matrix, origin, dest, x);
	}	

	private Coordinate findElement2(int[][] matrix, Coordinate origin, Coordinate dest, int x){
		if(!origin.inBounds(matrix) || !dest.inBounds(matrix)){
			return null;
		}		
		if(matrix[origin.row][origin.col] == x){
			return origin;
		}else if(!origin.isBefore(dest)){
			return null;
		}
		/*set start to the start of diagonal and end to the end of diagonal. Since the grid may not be square always, the end of the diagonal may not be equal to dest*/
		Coordinate start = (Coordinate) origin.clone();
		int diagDist = Math.min(dest.row - origin.row, dest.col - origin.col);
		Coordinate end = new Coordinate(origin.row + diagDist, origin.col + diagDist);
		Coordinate p = new Coordinate(0, 0);		

		/* DO binary Search on diagonal, looking for the first element > x*/
		while(start.isBefore(end)){
			p.setToAverage(start, end);
			if(matrix[p.row][p.col] >= x){
				end.row = p.row - 1;
				end.col = p.col - 1;
			}else{
				start.row = p.row + 1;
				start.col = p.col + 1;
			}
		}
		/* Split the grid into quadrants and search for x in bottom left and top right. */
		return partitionAndSearch(matrix, origin, dest, start, x);
	}

	private Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate start, int x){
		Coordinate lowerLeftOrigin = new Coordinate(start.row, origin.col);
		Coordinate lowerLeftDest = new Coordinate(dest.row, start.col - 1);
		Coordinate upperRightOrigin = new Coordinate(origin.row, start.col);
		Coordinate upperRightDest = new Coordinate(start.row - 1, dest.col);

		Coordinate lowerLeft = findElement2(matrix, lowerLeftOrigin, lowerLeftDest, x);
		if(lowerLeft == null){
			return findElement2(matrix, upperRightOrigin, upperRightDest, x);
		}
		return lowerLeft;
	}

	class Coordinate implements Cloneable{
		public int row, col;
		public Coordinate(int r, int c){
			row = r;
			col = c;
		}
		public boolean inBounds(int[][] matrix){
			return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
		}
		public boolean isBefore(Coordinate ob){
			return row <= ob.row && col <= ob.col;
		}
		public Object clone(){
			return new Coordinate(row, col);
		}
		public void setToAverage(Coordinate a, Coordinate b){
			row = (a.row + b.row) / 2;
			col = (a.col + b.col) / 2;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[][] matrix = {{15, 20, 70, 85}, 
			{20, 35, 80, 95},
			{30, 55, 95, 105},
			{40, 80, 120, 130}};
		int x = in.nextInt();
		SortedMatrixSearch ob = new SortedMatrixSearch();
		System.out.println(ob.findElement(matrix, x));
		Coordinate c = ob.findElement2(matrix, x);
		if(c != null)	
			System.out.println(c.row + " " + c.col);
	}
}
