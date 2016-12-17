class EggDropProblem{

	public int eggDropSolution(int eggs, int floors){
		int[][] dp = new int[eggs+1][floors+1];
		for(int i=0; i<=floors; i++){
			dp[1][i] = i;		
		}

		for(int e = 2; e <= eggs; e++){
			for(int f = 1; f <= floors; f++){
				dp[e][f] = Integer.MAX_VALUE;
				for(int k = 1; k <= f; k++){
					int c = 1 + Math.max(dp[e-1][k-1], dp[e][f-k]);
					if(dp[e][f] > c){
						dp[e][f] = c;
					}
				}
			}
		}
//		print(dp);
		return dp[eggs][floors];
	}

	public void print(int[][] dp){
		for(int i=0; i<dp.length; i++){
			for(int j=0; j<dp[0].length; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		EggDropProblem e = new EggDropProblem();
		System.out.println(e.eggDropSolution(2, 6));
	}
}
