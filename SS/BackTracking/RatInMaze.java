class RatInMaze{
	int row = 5;
	int col = 5;
	public void print(int[][] sol){
		for(int i=0; i<sol.length; i++){
			for(int j=0; j<sol.length; j++){
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isSafe(int[][] maze, int i, int j){
		return i >= 0 && i < row && j >= 0 && j < col && maze[i][j] == 1;
	}


	public boolean solveMaze(int[][] maze){
		int[][] sol = new int[row][col];
		if(!solveMazeUtil(maze, sol, 0, 0)){
			System.out.println("There is No Valid Path.");
			return false;
		}
		print(sol);
		return true;
	}


	public boolean solveMazeUtil(int[][] maze, int[][] sol, int i, int j){
		if(i == row-1 && j == col - 1){
			sol[i][j] = 1;
			return true;
		}	
		if(isSafe(maze, i, j)){
			sol[i][j] = 1;
			if(solveMazeUtil(maze, sol, i, j+1))
				return true;
			if(solveMazeUtil(maze, sol, i+1, j))
				return true;
			sol[i][j] = 0;

		}			
		return false;
	}



public static void main(String[] args){
	int[][] maze = {{1, 0, 0, 0, 0}, 
		{1, 1, 1, 0, 0},
		{0, 1, 0, 1, 0},
		{0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1}};
	RatInMaze ob = new RatInMaze();
	ob.solveMaze(maze);
}
}
