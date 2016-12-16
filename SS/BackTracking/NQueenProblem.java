class NQueenProblem{

	class Positions{
		int row;
		int col;
		public Positions(int r, int c){
			row = r;
			col = c;
		}
	}

	public Positions[] nQueenSolution(int n){
		Positions[] p = new Positions[n];
		boolean hasSolution = nQueenSolutionUtil(p, 0, n);
		if(hasSolution){
			return p;
		}
		else{
			return new Positions[0];
		}
	}

	private boolean nQueenSolutionUtil(Positions[] p, int row, int n){
		if(row == n)
			return true;
		for(int col = 0; col < n; col++){
			boolean flag = true;
			for(int q = 0; q<row; q++){
				if(col == p[q].col || row - col == p[q].row - p[q].col || row + col == p[q].row + p[q].col){
					flag = false;
					break;					
				}
			} 
			if(flag){
				p[row] = new Positions(row, col);
				if(nQueenSolutionUtil(p, row+1, n)){
					return true;	
				}	
			}
		}
		return false;
	}
	public static void main(String[] args){
		NQueenProblem ob = new NQueenProblem();
		Positions[] res = ob.nQueenSolution(4);
		for(int i=0; i<res.length; i++){
			System.out.println(res[i].row + " " + res[i].col);
		}
	}
}
