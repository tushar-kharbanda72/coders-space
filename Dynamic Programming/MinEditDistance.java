class MinEditDistance{

	public int minEditDistanceSol(String s1, String s2){
		int[][] dp = new int[s2.length()+1][s1.length()+1];
		for(int i=0; i<=s2.length(); i++){
			dp[i][0] = i;
		}
		for(int i=0; i<=s1.length(); i++){
			dp[0][i] = i;
		}
		int min;
		for(int i=1; i<=s2.length(); i++){
			for(int j=1; j<=s1.length(); j++){
				min = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
				if(s2.charAt(i-1) == s1.charAt(j-1)){
					dp[i][j] = min;
				}else{
					dp[i][j] = min + 1;	
				}
			}
		}
		for(int i=0; i<=s2.length(); i++){
			for(int j=0; j<=s1.length(); j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[s2.length()][s1.length()];

	}
	public static void main(String[] args){
		String s1 = "abcdef";
		String s2 = "azced";
		MinEditDistance ob = new MinEditDistance();
		System.out.println(ob.minEditDistanceSol(s1, s2));
	}
}
