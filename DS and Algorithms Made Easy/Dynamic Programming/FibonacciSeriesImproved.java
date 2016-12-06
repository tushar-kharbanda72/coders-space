import java.util.*;
class FibonacciSeriesImproved{
	public static int fibonacci(int n){
		int a = 0;
		int b = 1;
		int fib = 0;
		for(int i=0; i<n; i++){
			fib = a + b;
			a = b;
			b = fib;	
		}
		return fib;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fibonacci(n));	
	}
}
