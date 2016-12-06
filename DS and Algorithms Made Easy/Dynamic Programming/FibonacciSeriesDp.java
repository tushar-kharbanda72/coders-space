import java.util.*;
class FibonacciSeriesDp{
	public static int fibonacci(int n, int[] dp){
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(dp[n] != 0) return dp[n];
		return dp[n] = (fibonacci(n-1, dp) + fibonacci(n-2, dp));
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] dp = new int[n+1];
		System.out.println(fibonacci(n, dp));	
	}
}
