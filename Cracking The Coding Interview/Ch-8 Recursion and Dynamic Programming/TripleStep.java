// Problem 8.1 - counting the number of ways a student can reach the top of stairs by hoping 1, 2 or 3 stairs at a time.
//Take care of the overflows as taking int will overflow quickly. try taking long or using BigInteger class.
import java.util.Scanner;
import java.util.Arrays;
class TripleStep{

	public int countWays(int n){
		int[] mem = new int[n + 1];
		Arrays.fill(mem, -1);
		return countWays(n, mem);
	}

	private int countWays(int n, int[] mem){
		if(n == 0)
			return 1;
		if(n < 0)
			return 0;
		if(mem[n] == -1){
			mem[n] = countWays(n-1, mem);
			mem[n] += countWays(n-2, mem);
			mem[n] += countWays(n-3, mem);
		}
		return mem[n];
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TripleStep ob = new TripleStep();
		System.out.println(ob.countWays(n));
	}
}